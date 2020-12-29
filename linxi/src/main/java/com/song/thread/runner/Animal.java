package com.song.thread.runner;

/**
 * @author songfeng
 * @date 2020/12/14
 */
public abstract class Animal extends Thread {

  //在定义一个变量
  Integer length = 200;

  public abstract void running();


  //各自维护一个总体的长度，如果谁先到终点
  //就把另一个线程给暂停
  @Override
  public void run() {
    super.run();
    while (length > 0) {
      running();
    }
  }

  // 在需要回调数据的地方（两个子类需要），声明一个接口
  public static interface Calltoback {
    public void win();
  }

  // 2.创建接口对象
  public Calltoback calltoback;

}
