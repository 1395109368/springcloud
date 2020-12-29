package com.song.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;

/**
 * 处理业务逻辑
 *
 * @author songfeng
 * @date 2020/12/09
 */
@Slf4j
public class MyServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {

  private int count;

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    ctx.close();
  }


  @Override
  protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
    //接收到数据，并处理
    log.info("服务器接收到数据，并处理");
    log.info("服务器接收到的消息包总量" + (++count));
    //回复消息
    String responseContent = UUID.randomUUID().toString();

    byte[] bytes = responseContent.getBytes("utf-8");
    MessageProtocol messageProtocol = new MessageProtocol();
    messageProtocol.setContent(bytes);
    messageProtocol.setLen(bytes.length);
    ctx.writeAndFlush(messageProtocol);
  }
}
