package com.song.designmodel.creationalpatterns.prototype;

/**
 * @author songfeng
 * @date 2020/12/11
 */
public abstract  class Shape implements Cloneable{

  private String id;

  protected String type;

  abstract void draw();
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  /**
   * 克隆方法
   * @return
   * @throws CloneNotSupportedException
   */
  @Override
  public Object clone(){
    Object clone = null;
    try {
      clone = super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return clone;
  }
}
