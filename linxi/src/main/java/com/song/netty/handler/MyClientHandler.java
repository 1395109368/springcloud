package com.song.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.nio.charset.Charset;
import lombok.extern.slf4j.Slf4j;

/**
 * @author songfeng
 * @date 2020/12/09
 */
@Slf4j
public class MyClientHandler extends SimpleChannelInboundHandler<MessageProtocol> {

  private int count;

  /**
   * 标识通道连接就会执行这个方法
   *
   * @param ctx
   * @throws Exception
   */
  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {

    //代表发送五次请求
    for (int i = 0; i < 5; i++) {
      String msg = "天气好冷";
      byte[] content = msg.getBytes(Charset.forName("utf-8"));
      int length = content.length;
      //创建协议包对象
      MessageProtocol messageProtocol = new MessageProtocol();
      messageProtocol.setLen(length);
      messageProtocol.setContent(content);
      ctx.writeAndFlush(messageProtocol);
    }
  }

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
    log.info("客户端接收消息如下");
    log.info("" + new String(msg.getContent(), Charset.forName("utf-8")));
    log.info("接收消息总量" + (++this.count));
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    log.info("一场消息"+cause.getMessage());
    ctx.close();
  }
}
