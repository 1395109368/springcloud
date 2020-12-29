package com.song.designmodel.creationalpatterns.prototype;


/**
 * @author songfeng
 * @date 2020/12/11
 */
public class Square extends Shape {

  public Square(){
    type = "Square";
  }

  @Override
  public void draw() {
    System.out.println("Inside Square::draw() method.");
  }

}
