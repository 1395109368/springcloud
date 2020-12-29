package com.song.netty.group;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;

/**
 * @author songfeng
 * @date 2020/12/08
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
  //TODO  ChannelInboundHandlerAdapter是一个检测入站事件的类，检测IO流

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

    System.out.println("服务器读取线程" + Thread.currentThread().getName());

    Channel channel = ctx.channel();
    //读取通道
    ChannelPipeline pipeline = ctx.pipeline();

    ByteBuf buf = (ByteBuf) msg;
    System.out.println("客户端发送的消息" + buf.toString(CharsetUtil.UTF_8));
    System.out.println("客户端发送的地址" + channel.remoteAddress());

//    ctx.channel().eventLoop().execute(new Runnable() {
//      @Override
//      public void run() {
//        try {
//          Thread.sleep(5 * 1000);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//        ctx.writeAndFlush(Unpooled.copiedBuffer("hello 客户端", CharsetUtil.UTF_8));
//      }
//    });
//
//    ctx.channel().eventLoop().schedule(new Runnable() {
//      @Override
//      public void run() {
//        try {
//          Thread.sleep(5 * 1000);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//        ctx.writeAndFlush(Unpooled.copiedBuffer("hello 客户端", CharsetUtil.UTF_8));
//      }
//    }, 5, TimeUnit.SECONDS);


  }

  /**
   * 数据读取完毕
   *
   * @param ctx
   * @throws Exception
   */
  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    //发送数据  把数据写到缓冲区里面，并发送数据

    ctx.writeAndFlush(Unpooled.copiedBuffer("hello 客户端", CharsetUtil.UTF_8));
  }


  /**
   * 关闭通道数据
   *
   * @param ctx
   * @param cause
   * @throws Exception
   */
  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    ctx.close();
  }
}
