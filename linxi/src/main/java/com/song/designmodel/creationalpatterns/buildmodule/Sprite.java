package com.song.designmodel.creationalpatterns.buildmodule;


/**
 *  雪碧
 * @author songfeng
 * @date 2020/12/11
 */
public class Sprite implements CoCo {

  @Override
  public void name() {
    System.out.println("这是一杯雪碧饮料");
  }

  @Override
  public Integer price() {
    System.out.println("雪碧饮料 5 元钱");
    return 5;
  }
}
