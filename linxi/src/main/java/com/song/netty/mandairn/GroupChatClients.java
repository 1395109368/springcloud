package com.song.netty.mandairn;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 客户端
 * @author songfeng
 * @date 2020/12/01
 */
public class GroupChatClients {

  private Selector selector;
  private SocketChannel socketChannel;
  private String userName;

 public GroupChatClients(){
   try {
     selector = Selector.open();
     socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",6666));
     socketChannel.configureBlocking(false);
     socketChannel.register(selector, SelectionKey.OP_READ);
     userName=socketChannel.getLocalAddress().toString().substring(1);
     System.out.println(userName + " 已经 OK");
   } catch (IOException e) {
     e.printStackTrace();
   }
 }

 //发送消息
 public void sendInfo(String info){
   try {
     info  = userName + " 说" + info;
     socketChannel.write(ByteBuffer.wrap(info.getBytes()));
   } catch (IOException e) {
     e.printStackTrace();
   }
 }

public void readInfo(){
  try {
    int select = selector.select();
    if(select>0){
      Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
      while (iterator.hasNext()){
        SelectionKey key = iterator.next();
        if(key.isReadable()){
          SocketChannel channel =(SocketChannel) key.channel();
          ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
          channel.read(byteBuffer);
          String msg = new String(byteBuffer.array());
          System.out.println(msg.trim());
        }
        iterator.remove();

      }
    }

  } catch (IOException e) {
    e.printStackTrace();
  }

}

  public static void main(String[] args) {

    GroupChatClients groupChatClients = new GroupChatClients();
    new Thread(){
      @Override
      public  void run(){
            while(true){
              groupChatClients.readInfo();
              try {
                Thread.sleep(3000);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
      }
    }.start();

    Scanner sc = new Scanner(System.in);
    while(sc.hasNextLine()){
      groupChatClients.sendInfo(sc.nextLine());
    }
  }
}
