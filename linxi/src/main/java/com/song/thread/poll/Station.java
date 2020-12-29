package com.song.thread.poll;

/**
 * 三个售票口同时售出20张票 给每一张票都有标识
 *
 * @author songfeng
 * @date 2020/12/14
 */
public class Station extends Thread {

  private String name;

  Station(String name) {
    //这个相当于每一个窗口的标识
    this.name = name;
  }

  /**
   * 这算是一个共享变量
   */
  static Integer pollNumber = 20;
  static Object  flag = "a";

  @Override
  public void run() {
    while(pollNumber > 0){
        //说明有票
        //重点是给一个锁，让第一个线程进来的时候拿到第一个锁，其他线程等待
        //等到第一个线程结束,第二个线程拿到锁继续执行
        synchronized (flag) {
          if(pollNumber > 0){
            System.out.println(name + "卖出了第" + pollNumber + "张票");
            --pollNumber;
          }else {
            System.out.println("票卖完了");
          }

          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }


        }
    }
  }

  public static void main(String[] args) {

    Station s1 = new Station("第一窗口");
    Station s2 = new Station("第二窗口");
    Station s3 = new Station("第三窗口");
    s1.start();
    s2.start();
    s3.start();

  }

}
