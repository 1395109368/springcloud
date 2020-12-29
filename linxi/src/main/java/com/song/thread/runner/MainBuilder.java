package com.song.thread.runner;

/**
 * @author songfeng
 * @date 2020/12/14
 */
public class MainBuilder {

  public static void main(String[] args) {
    Ribbit ribbit = new Ribbit();
    Tortoise tortoise = new Tortoise();

    LetOneStop letOneStop1 = new LetOneStop(tortoise);
    // 让兔子的回调方法里面存在乌龟对象的值，可以把乌龟stop
    ribbit.calltoback = letOneStop1;
    LetOneStop letOneStop2 = new LetOneStop(ribbit);
    // 让乌龟的回调方法里面存在兔子对象的值，可以把兔子stop
    tortoise.calltoback = letOneStop2;

    ribbit.start();
    tortoise.start();
  }
}
