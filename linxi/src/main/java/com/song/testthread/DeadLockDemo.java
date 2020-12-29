package com.song.testthread;

/**
 * @Version 1.0
 * @Author 宋锋
 * @Date 2020/8/28
 * @Content  测试线程类
 */
public class DeadLockDemo extends  Thread{


    public static void main(String[] args) {

      Thread  thread = new Thread(new Runnable() {
          @Override
          public void run() {
              for (int i = 0; i < 10; i++) {
                  System.out.println(Thread.currentThread().getName()+i);
              }


          }
      });


      thread.setName("store----------------");

      thread.start();


    }

}
