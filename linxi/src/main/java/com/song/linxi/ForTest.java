package com.song.linxi;

import java.util.concurrent.locks.LockSupport;

/**
 * @author songfeng
 * @date 2020/11/23
 */
public class ForTest {

  public static void main(String[] args) {
    Thread thread = new Thread(() -> {
      System.out.println("进入到线程中");
      LockSupport.park();
      System.out.println(Thread.currentThread().getName() + "被唤醒");
    });
    thread.start();
    System.out.println("哈哈哈");
    try {
      Thread.sleep(3000);
      System.out.println("沉睡三秒种");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    LockSupport.unpark(thread);


  }

}
