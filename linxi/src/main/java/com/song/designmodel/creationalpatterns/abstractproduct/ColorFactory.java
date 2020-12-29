package com.song.designmodel.creationalpatterns.abstractproduct;

/**
 * @author songfeng
 * @date 2020/12/11
 */
public class ColorFactory extends AbstractFactory {

  @Override
  Color getColor(String color) {

    if("red".equals(color)){
      return new RedColor();
    }

    if("green".equals(color)){
      return new GreenColor();
    }

    return null;
  }

  @Override
  Shape getShape(String shape) {
    return null;
  }
}

