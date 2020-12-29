package com.song.designmodel.creationalpatterns.prototype;


/**
 * @author songfeng
 * @date 2020/12/11
 */
public class Rectangle extends Shape {

  public Rectangle(){
    type = "Rectangle";
  }

  @Override
  public void draw() {
    System.out.println("Inside Rectangle::draw() method.");
  }

}
