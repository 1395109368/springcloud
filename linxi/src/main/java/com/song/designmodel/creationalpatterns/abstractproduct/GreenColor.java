package com.song.designmodel.creationalpatterns.abstractproduct;

/**
 * @author songfeng
 * @date 2020/12/11
 */
public class GreenColor implements Color {

  @Override
  public void color() {
    System.out.println("这是绿色");
  }
}
