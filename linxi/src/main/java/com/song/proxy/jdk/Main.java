package com.song.proxy.jdk;

import com.song.proxy.service.HelloService;
import com.song.proxy.service.impl.HelloServiceImpl;

/**
 * @author songfeng
 * @date 2020/12/16
 */
public class Main {

  public static void main(String[] args) {

    HelloService service = (HelloService) new LogHandler().bind(new HelloServiceImpl());
    System.out.println(service.hello("哈哈"));

  }
}
