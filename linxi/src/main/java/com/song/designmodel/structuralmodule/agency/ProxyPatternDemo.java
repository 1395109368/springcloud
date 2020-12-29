package com.song.designmodel.structuralmodule.agency;

/**
 * @author songfeng
 * @date 2020/12/14
 */
public class ProxyPatternDemo {

  public static void main(String[] args) {
    Image image = new ProxyImage("test.png");

    //图像将从磁盘加载
    image.display();
    System.out.println("");

    //图像将无法从磁盘加载
    image.display();
  }
}
