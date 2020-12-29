package com.song.designmodel.creationalpatterns.buildmodule;



/**
 * 七喜
 * @author songfeng
 * @date 2020/12/11
 */
public class SevenUp implements CoCo {

  @Override
  public void name() {
    System.out.println("这是七喜饮料哦");
  }

  @Override
  public Integer price() {
    System.out.println("这是七喜饮料 3 元钱");
    return 3;
  }
}
