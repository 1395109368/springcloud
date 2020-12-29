package com.song.netty.mandairn;

import java.nio.IntBuffer;

/**
 * 练习netty
 *
 * @author songfeng
 * @date 2020/10/29
 */
public class NioLianxi {

  private IntBuffer intBuffer;

  public static void main(String[] args) {


    String groupType = "[{\"groupType\":\"司法安全隐患人员\"},{\"groupType\":\"重点信访人员\"},{\"groupType\":\"重点舆情人员\"},{\"groupType\":\"重点失信人员\"},{\"groupType\":\"其他\"}]";


    //默认方五个值//分配
    IntBuffer intBuffer = IntBuffer.allocate(5);
    for (int i = 0; i < intBuffer.capacity(); i++) {
      intBuffer.put(i * 7);
    }
    // 必须加下面这行读写转换
    intBuffer.flip();
    while (intBuffer.hasRemaining()) {

      System.out.println(intBuffer.get());
    }

    System.out.println();

  }




}