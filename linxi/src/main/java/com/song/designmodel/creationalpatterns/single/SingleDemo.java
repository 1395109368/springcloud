package com.song.designmodel.creationalpatterns.single;

/**
 * 单例模式
 *
 * @author songfeng
 * @date 2020/12/11
 */
public class SingleDemo {

  //静态对象，内存中只有一份，保证对象的唯一性
  private static SingleDemo instance = new SingleDemo();

  //私有化 ，不能被实例化
  private SingleDemo() {
  }

  public static synchronized SingleDemo getStance() {
    return instance;
  }

  public static void main(String[] args) {
    SingleDemo stance1 = SingleDemo.getStance();
    SingleDemo stance2 = SingleDemo.getStance();
    System.out.println(stance1);
    System.out.println(stance2);
  }
}
