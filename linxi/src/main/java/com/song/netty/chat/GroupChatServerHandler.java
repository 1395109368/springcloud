package com.song.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author songfeng
 * @date 2020/12/09
 */
public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {

  private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  //标识连接建立，一但连接，第一个被执行
  //将当前通道channel加入到channelGroup
  //channelActive()方法执行之后会执行这个方法
  @Override
  public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

    Channel channel = ctx.channel();
    /**
     * 该方法会将channelGroup中所有的channel遍历，并发送消息
     * 不需要自己遍历
     */
    channelGroup.writeAndFlush("客户端" + channel.remoteAddress() + sdf.format(new Date()) + "加入聊天");
    channelGroup.add(channel);
  }

  /**
   * 客户端断开连接
   *
   * @param ctx
   * @throws Exception
   */
  @Override
  public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
    Channel channel = ctx.channel();
    channelGroup.writeAndFlush("客户端" + channel.remoteAddress() + sdf.format(new Date()) + "离开了");
    System.out.println("连接的客户数量" + channelGroup.size());

    //   channelGroup.remove(channel);
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    //这个方法表示客户端一旦连接成功，在服务端就会触发这个事件

    System.out.println(ctx.channel().remoteAddress()+"上线了");
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    //客户端断开连接
   System.out.println(ctx.channel().remoteAddress()+"离开了");
  }

  //读取数据
  @Override
  protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
    //读取相应的数据，并发送给其他的客户端
    channelGroup.forEach(
        ch -> {
         if(ctx.channel()!=ch){
            //代表不是自己的通道
           ch.writeAndFlush("客户"+ctx.channel().remoteAddress() + "发送了消息" + msg);
         }else {
        //   ch.writeAndFlush("自己"+ctx.channel().remoteAddress() + "发送了消息" + msg);
         }
        }
    );
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    ctx.close();
  }

}
