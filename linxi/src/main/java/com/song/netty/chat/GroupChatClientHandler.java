package com.song.netty.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author songfeng
 * @date 2020/12/09
 */
public class GroupChatClientHandler extends SimpleChannelInboundHandler<String> {


  /**
   * 读写数据
   *
   * @param ctx
   * @param msg
   * @throws Exception
   */
  @Override
  protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
    System.out.println(msg.trim());
  }

  /**
   *  channelRead0() 方法之后执行 读取消息之后的操作
   * @param ctx
   * @throws Exception
   */
  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    System.out.println("读取消息之后执行该方法   channelReadComplete()");

  }

  /**
   *  注册事件
   * @param ctx
   * @throws Exception
   */
//  @Override
//  public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
//    super.channelRegistered(ctx);
//  }
}
