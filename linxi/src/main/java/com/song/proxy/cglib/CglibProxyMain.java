package com.song.proxy.cglib;

import com.song.proxy.service.HelloService;
import com.song.proxy.service.impl.HelloServiceImpl;

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
