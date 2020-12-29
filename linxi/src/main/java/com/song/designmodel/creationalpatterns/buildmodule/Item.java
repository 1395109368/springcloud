package com.song.designmodel.creationalpatterns.buildmodule;

/**
 * @author songfeng
 * @date 2020/12/11
 */
public interface Item {

  String name();

  /**
   * 包装
   * @return
   */
  CoCo coco();

  Integer price();
}
