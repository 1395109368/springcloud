package com.song.netty.mandairn;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;

/**
 * NiO客户端
 *
 * @author songfeng
 * @date 2020/11/27
 */
public class NIOClient {

  public static void main(String[] args) throws Exception {
    // 1. 获取通道
    SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
    // 2. 切换非阻塞模式
    sChannel.configureBlocking(false);
    // 3. 分配指定大小的缓冲区
    ByteBuffer buf = ByteBuffer.allocate(1024);
    // 4. 发送数据给服务端
      // 5. 关闭通道
      try {
        Thread.sleep(2000);
        String str = "hello";
        buf.clear();
        buf.put((new Date().toString() + "\n" + str).getBytes());
        buf.flip();
        sChannel.write(buf);
        sChannel.shutdownOutput();
      }catch (Exception e){
        System.out.println("进入到异常中");
        sChannel.close();
      }
  }
}
