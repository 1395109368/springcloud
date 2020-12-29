package com.song.designmodel.creationalpatterns.buildmodule;



/**
 * 饼
 * @author songfeng
 * @date 2020/12/11
 */
public class CakeFood implements Food {

  @Override
  public void name() {
    System.out.println("这是饼");
  }

  @Override
  public Integer price() {
    System.out.println("饼的价钱是5元钱");
    return 5;
  }
}
