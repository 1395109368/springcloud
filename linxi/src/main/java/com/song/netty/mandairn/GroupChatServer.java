package com.song.netty.mandairn;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author songfeng
 * @date 2020/11/30
 */
public class GroupChatServer {

  private Selector selector;
  private ServerSocketChannel listenChannel;

  public GroupChatServer() {

    try {
      selector = Selector.open();
      listenChannel = ServerSocketChannel.open();
      listenChannel.socket().bind(new InetSocketAddress((6666)));
      listenChannel.configureBlocking(false);
      //链接
      listenChannel.register(selector, SelectionKey.OP_ACCEPT);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void listen() {

    try {
      while (true) {
        if (selector.select(3000) == 0) {
          System.out.println("time out three second not connection");
        }
        Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
        while (iterator.hasNext()) {
          SelectionKey key = iterator.next();
          //判断这个通道的动作
          if (key.isAcceptable()) {
            SocketChannel sc = listenChannel.accept();
        //    sc.configureBlocking(false);
            sc.register(selector, SelectionKey.OP_READ);
            System.out.println(sc.getLocalAddress() + "上线");
          }

          if (key.isReadable()) {
            //通过这个key得到这个通道
            readDate(key);

          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }


  }


  public static void main(String[] args) {
    GroupChatServer groupChatServer = new GroupChatServer();

    groupChatServer.listen();

  }


  private void readDate(SelectionKey key) {
    //读取消息的一个动作
    SocketChannel channel = null;
    try {
      channel = (SocketChannel) key.channel();
      ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
      int count = channel.read(byteBuffer);
      if (count > 0) {
        String msg = new String(byteBuffer.array());
        System.out.println(" from 客户端" + msg);
        //向其他客户端发出消息
        sendInfoOtherClients(msg, channel);
      }

    } catch (Exception e) {
      try {
        System.out.println(channel.getLocalAddress() + "离线了");
        key.cancel();
        channel.close();
      } catch (IOException ioException) {
        ioException.printStackTrace();
      }
    }

  }

  private void sendInfoOtherClients(String msg, SocketChannel channel) {
    System.out.println("服务器转化消息zhong");
    //遍历所有的通道
    try {
      for (SelectionKey key : selector.keys()) {
        Channel targetChannel = key.channel();
        if (targetChannel instanceof SocketChannel && targetChannel != channel) {
          SocketChannel socketChannel = (SocketChannel) targetChannel;
          ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
          socketChannel.write(byteBuffer);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
