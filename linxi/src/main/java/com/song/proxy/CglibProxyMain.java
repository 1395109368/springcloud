package com.song.proxy;

/**
 * cgb代理
 * @author songfeng
 * @date 2020/12/16
 */
public class CglibProxyMain {

  public static void main(String[] args) {

    HelloService service = (HelloService)new CglibFactory().bind(new HelloServiceImpl());
    System.out.println(service.hello("阿斯顿开会"));
  }
}
