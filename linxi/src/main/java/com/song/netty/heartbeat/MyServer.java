package com.song.netty.heartbeat;

import com.song.netty.chat.GroupChatServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import java.util.concurrent.TimeUnit;

/**
 *  心跳检测包
 * @author songfeng
 * @date 2020/12/09
 */
public class MyServer {
  private int port;

  public MyServer(int port) {
    this.port = port;
  }
  public void run() throws Exception{

    //创建俩个线程组
    EventLoopGroup bossGrooup = new NioEventLoopGroup(1);
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    try {
      ServerBootstrap b = new ServerBootstrap();
      b.group(bossGrooup,workerGroup)
          .channel(NioServerSocketChannel.class)
          // option 选择
          .option(ChannelOption.SO_BACKLOG,128)
          .childOption(ChannelOption.SO_KEEPALIVE,true)
          .handler(new LoggingHandler(LogLevel.INFO))
          .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {

              //都是根据通道去增加配置

              ChannelPipeline pipeline = ch.pipeline();
              //加入解码器
              pipeline.addLast("decoder",new StringDecoder());
              //加入编码器
              pipeline.addLast("encoder",new StringEncoder());

              pipeline.addLast(new IdleStateHandler(13,5,2, TimeUnit.SECONDS));
              //加入自己的业务处理的handler  心跳检测
              pipeline.addLast(new MyServerHandler());

              pipeline.addLast(new GroupChatServerHandler());
            }
          });

      System.out.println("netty 服务器启动");
      ChannelFuture channelFuture = b.bind(port).sync();
      channelFuture.channel().closeFuture().sync();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
      bossGrooup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }

  }



  public static void main(String[] args) {

    try {
      new MyServer(7000).run();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
