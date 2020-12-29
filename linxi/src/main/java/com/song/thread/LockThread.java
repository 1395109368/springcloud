package com.song.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author songfeng
 * @date 2020/11/24
 */
public class LockThread {

  public static void main(String[] args) {
    //重入锁
    ReentrantLock lock = new ReentrantLock();
    try {
      for (int i = 1; i <= 5; i++) {
        lock.lock();
      }
    } finally {
      lock.unlock();
    }
    System.out.println("哈哈");





  }

}
