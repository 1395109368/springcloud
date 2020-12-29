package com.song.netty.LongConnection;

import com.song.netty.group.NettyServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * 使用netty框架 快速入门
 *
 * @author songfeng
 * @date 2020/12/08
 */
public class LongConnectionNettyServer {

  public static void main(String[] args) {

    EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    try {
      ServerBootstrap bootstrap = new ServerBootstrap();
      bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
          //设置线程队列得到连接个数
          .option(ChannelOption.SO_BACKLOG, 128)
          //设置链接状态,一直保持链接活动状态
          .childOption(ChannelOption.SO_KEEPALIVE, true)
          .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
              //自己创建监听器

              ChannelPipeline pipeline = ch.pipeline();
         //     pipeline.addLast(new HttpServer);

              pipeline.addLast(new ChunkedWriteHandler());
              ch.pipeline().addLast(new NettyServerHandler());
            }
          });

      System.out.println("......启动服务器，绑定端口");
      ChannelFuture future = bootstrap.bind(6668).sync();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }
  }
}
