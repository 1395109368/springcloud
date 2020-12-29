package com.song.thread.runner;

/**
 * @author songfeng
 * @date 2020/12/14
 */
public class Tortoise extends Animal{

  Tortoise(){
    setName("----乌龟----");
  }


  @Override
  public void running() {
    Integer speed = 20;
    length -= speed;
    System.out.println("乌龟跑了" + speed + "米,还剩" + length + "米");
    if (length <= 0) {
      length = 0;
      System.out.println("乌龟获得了胜利");
      if(calltoback!=null){
        calltoback.win();
      }
    }
    try {
      //设0.1跑2米
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
