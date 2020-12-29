package com.song.thread.runner;

import com.song.thread.runner.Animal.Calltoback;

/**
 * @author songfeng
 * @date 2020/12/14
 */
public class LetOneStop implements Calltoback {

  //需要把这个对象给传进来
  Animal animal;

  LetOneStop(Animal animal) {
    this.animal = animal;
  }

  @Override
  public void win() {
    //线程停止
    animal.stop();
  }
}
