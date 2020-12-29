package com.song.netty.group;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 使用netty框架 快速入门
 *
 * @author songfeng
 * @date 2020/12/08
 */
public class NettyServer {

  public static void main(String[] args) {

    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    try {
      ServerBootstrap bootstrap = new ServerBootstrap();
      bootstrap.group(bossGroup, workerGroup)
          .channel(NioServerSocketChannel.class)
          //设置线程队列得到连接个数
          .option(ChannelOption.SO_BACKLOG, 128)
          //设置链接状态,一直保持链接活动状态
          .childOption(ChannelOption.SO_KEEPALIVE, true)

          .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
              //自己创建监听器
              ch.pipeline().addLast(new NettyServerHandler());
            }
          });

      System.out.println("......启动服务器，绑定端口");
      ChannelFuture future = bootstrap.bind(6669).sync();
      //如果不加下面这句话，main线程执行完之后就会执行finally代码块
      //执行完之后可以让线程处于wait状态，监听等待关闭事件，然后关闭
      future.channel().closeFuture().sync();
 //     future.addListener();
    } catch (InterruptedException e) {
      System.out.println("出现异常");
      e.printStackTrace();
    } finally {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }
  }
}
