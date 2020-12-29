package com.song.designmodel.creationalpatterns.abstractproduct;

/**
 *
 * 这是一个总的工厂
 */
public abstract class AbstractFactory {
   abstract Color getColor(String color);
   abstract Shape getShape(String shape);
}
