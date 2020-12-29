package com.song.thread.runner;

/**
 * @author songfeng
 * @date 2020/12/14
 */
public class Ribbit extends Animal {

  Ribbit(){
    //这个是线程的名字
    setName("----兔子----");
  }


  @Override
  public void running() {
    //
    Integer speed = 50;
    length -= speed;
    System.out.println("兔子跑了" + speed + "米,还剩" + length + "米");
    if (length <= 0) {
      length = 0;
      System.out.println("兔子获得了胜利");
      if(calltoback!=null){
        calltoback.win();
      }
    }

    try {
      if ((2000 - length) % 20 == 0) {
        //说明跑了一秒
        Thread.sleep(1000);
      } else {
        Thread.sleep(100);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
