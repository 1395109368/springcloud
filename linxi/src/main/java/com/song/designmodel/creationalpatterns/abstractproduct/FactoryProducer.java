package com.song.designmodel.creationalpatterns.abstractproduct;

/**
 * @author songfeng
 * @date 2020/12/11
 */
public class FactoryProducer {

  public static AbstractFactory getFactory(String factory) {

    if ("color".equals(factory)) {
      return new ColorFactory();
    }
    if ("shape".equals(factory)) {
      return new ShapeFactory();
    }
    return null;
  }

  public static void main(String[] args) {
    AbstractFactory color = FactoryProducer.getFactory("color");
    Color red = color.getColor("green");
    red.color();
  }
}
