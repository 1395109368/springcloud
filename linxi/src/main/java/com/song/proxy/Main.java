package com.song.proxy;

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
