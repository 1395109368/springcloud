package com.song.designmodel.creationalpatterns.buildmodule;

/**
 * 饮料的接口
 *
 * @author songfeng
 * @date 2020/12/11
 */
public interface CoCo {

  /**
   * 名字
   */
  void name();

  /**
   * 价格
   * @return
   */
  Integer price();
}
