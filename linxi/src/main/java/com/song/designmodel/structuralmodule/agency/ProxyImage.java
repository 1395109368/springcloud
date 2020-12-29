package com.song.designmodel.structuralmodule.agency;

/**
 * @author songfeng
 * @date 2020/12/14
 */
public class ProxyImage implements Image {

  private RealImage realImage;

  private String fileName;

  public ProxyImage(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public void display() {
    if (realImage == null) {
      realImage = new RealImage(fileName);
    }
    realImage.display();
  }

}
