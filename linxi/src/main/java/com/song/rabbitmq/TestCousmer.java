package com.song.rabbitmq;

import com.song.exception.SelfRunTimeException;

/**
 * @Auther: sf
 * @Date: 2020/7/27
 * @version: 1.0
 */
public class TestCousmer {


  public void selfMessageException() {

    if (1 != 1) {

      throw new SelfRunTimeException("这是");
    }
  }
}
