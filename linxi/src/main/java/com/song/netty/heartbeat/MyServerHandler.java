package com.song.netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author songfeng
 * @date 2020/12/09
 */
@Slf4j
public class MyServerHandler extends ChannelInboundHandlerAdapter {

  /**
   *  用户自定义事件
   * @param ctx
   * @param evt
   * @throws Exception
   */
  @Override
  public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

    if(evt instanceof IdleStateEvent){
      IdleStateEvent event = (IdleStateEvent)evt;
      String eventType = null;
      switch (event.state()){
        case READER_IDLE:
          eventType="读空闲";
          break;
        case WRITER_IDLE:
          eventType="写空闲";
          break;
        case ALL_IDLE:
          eventType="读写空闲";
          break;
      }
    log.info("超时时间"+ctx.channel().remoteAddress());
      log.info("服务器做相应处理");
      //如果发生空闲 ，我们关闭通道
     // ctx.channel().close();
    }
  }
}
