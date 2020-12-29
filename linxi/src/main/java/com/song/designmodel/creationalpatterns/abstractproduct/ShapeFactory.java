package com.song.designmodel.creationalpatterns.abstractproduct;

/**
 * @author songfeng
 * @date 2020/12/11
 */
public class ShapeFactory extends AbstractFactory {

  @Override
  Color getColor(String color) {
    return null;
  }

  @Override
  Shape getShape(String shape) {

    if("circle".equals(shape)){
      return new CircleShape();
    }
    if("square".equals(shape)){
      return new SquareShape();
    }
    return null;
  }
}
