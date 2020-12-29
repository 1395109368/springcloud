package com.song.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * 解码
 *
 * @author songfeng
 * @date 2020/12/09
 */
@Slf4j
public class MyMessageDecoder extends ReplayingDecoder<MessageProtocol> {

  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
    log.info("MyMessageDecoder 方法被调用");
    int length = in.readInt();
    byte[] content = new byte[length];
    in.readBytes(content, 0, length);
    MessageProtocol messageProtocol = new MessageProtocol();
    messageProtocol.setLen(in.readInt());
    messageProtocol.setContent(content);
    out.add(messageProtocol);
  }
}
