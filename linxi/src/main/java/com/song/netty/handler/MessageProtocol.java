package com.song.netty.handler;

import lombok.Data;

/**
 * 消息体
 *
 * @author songfeng
 * @date 2020/12/09
 */
@Data
public class MessageProtocol {

  private int len;
  private byte[] content;


}
