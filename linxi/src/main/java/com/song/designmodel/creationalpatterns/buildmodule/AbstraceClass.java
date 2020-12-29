package com.song.designmodel.creationalpatterns.buildmodule;



/**
 * 抽象类
 * @author songfeng
 * @date 2020/12/11
 */
public abstract class AbstraceClass implements Item {

  /**
   * 这就是一个包装的实现类
   * @return
   */
  @Override
  public CoCo coco() {
    return new Sprite() ;
  }

  @Override
  public abstract Integer price();

}
