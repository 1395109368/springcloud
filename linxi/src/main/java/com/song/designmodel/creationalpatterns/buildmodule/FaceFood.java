package com.song.designmodel.creationalpatterns.buildmodule;



/**
 * 面条
 * @author songfeng
 * @date 2020/12/11
 */
public class FaceFood implements Food {

  @Override
  public void name() {
    System.out.println("这是面条");
  }

  @Override
  public Integer price() {
    System.out.println("面条的价格是15元钱哦");
    return 15;
  }
}
