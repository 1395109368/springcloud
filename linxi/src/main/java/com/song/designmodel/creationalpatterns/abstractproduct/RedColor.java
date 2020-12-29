package com.song.designmodel.creationalpatterns.abstractproduct;

/**
 * @author songfeng
 * @date 2020/12/11
 */
public class RedColor implements Color {

  @Override
  public void color() {
    System.out.println("这是红色");
  }
}
