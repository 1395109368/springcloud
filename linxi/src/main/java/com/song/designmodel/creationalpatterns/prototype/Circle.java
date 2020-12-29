package com.song.designmodel.creationalpatterns.prototype;


/**
 * @author songfeng
 * @date 2020/12/11
 */
public class Circle extends Shape {

  public Circle(){
    type = "Circle";
  }

  @Override
  public void draw() {
    System.out.println("Inside Circle::draw() method.");
  }

}
