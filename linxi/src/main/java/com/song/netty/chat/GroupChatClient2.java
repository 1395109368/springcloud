package com.song.netty.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import java.util.Scanner;

/**
 * @author songfeng
 * @date 2020/12/09
 */
public class GroupChatClient2 {

  private String host;
  private int port;

  public GroupChatClient2(String host, int port) {
    this.host = host;
    this.port = port;
  }

  public void  run() throws Exception{
    EventLoopGroup group = new NioEventLoopGroup();
    try {
      Bootstrap bootstrap = new Bootstrap().group(group)
          .channel(NioSocketChannel.class)
          .handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
              ChannelPipeline pipeline = ch.pipeline();
              pipeline.addLast("decoder",new StringDecoder());
              //加入编码器
              pipeline.addLast("encoder",new StringEncoder());

              //加入自己的业务处理的handler
              pipeline.addLast(new GroupChatClientHandler());
            }
          });

      ChannelFuture channelFuture = bootstrap.connect(host,port).sync();
      //得到通道
      Channel channel = channelFuture.channel();
      System.out.println("-------------"+channel.remoteAddress()+"--------------");
      Scanner scanner = new Scanner(System.in);
      while(scanner.hasNextLine()){

         String msg =  scanner.nextLine();
        channel.writeAndFlush(msg);
      }
    } finally {
      group.shutdownGracefully();
    }
  }

  public static void main(String[] args) {

    try {
      new GroupChatClient2("127.0.0.1",7000).run();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
