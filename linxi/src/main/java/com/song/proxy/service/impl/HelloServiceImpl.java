package com.song.proxy.service.impl;

import com.song.proxy.service.HelloService;

/**
 * @author songfeng
 * @date 2020/12/16
 */
public class HelloServiceImpl implements HelloService {

  @Override
  public String hello(String name) {
    return "这是内部实现类 ："+name;
  }
}
