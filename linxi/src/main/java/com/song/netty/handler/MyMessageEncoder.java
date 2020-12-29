package com.song.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.extern.slf4j.Slf4j;

/**
 * 编码
 *
 * @author songfeng
 * @date 2020/12/09
 */
@Slf4j
public class MyMessageEncoder extends MessageToByteEncoder<MessageProtocol> {

  @Override
  protected void encode(ChannelHandlerContext ctx, MessageProtocol msg, ByteBuf out)
      throws Exception {

    log.info("MyMessageEncoder 方法被调用");
    out.writeInt(msg.getLen());
    out.writeBytes(msg.getContent());
  }
}
