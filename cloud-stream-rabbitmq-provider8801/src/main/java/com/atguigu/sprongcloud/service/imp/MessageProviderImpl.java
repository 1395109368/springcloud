package com.atguigu.sprongcloud.service.imp;

import com.atguigu.sprongcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/5/3
 * @Description: com.atguigu.sprongcloud.service.imp
 * @version: 1.0
 */
@EnableBinding(Source.class) //定义消息推送的管道
public class MessageProviderImpl implements  IMessageProvider {

    @Resource
    private MessageChannel output;  //消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
System.out.println("流水号"+serial);


        return null;
    }
}
