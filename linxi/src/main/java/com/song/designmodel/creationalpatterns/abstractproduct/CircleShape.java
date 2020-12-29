package com.song.designmodel.creationalpatterns.abstractproduct;

/**
 * @author songfeng
 * @date 2020/12/11
 */
public class CircleShape implements Shape {

  @Override
  public void draw() {
    System.out.println("这是CircleShape类");
  }
}
