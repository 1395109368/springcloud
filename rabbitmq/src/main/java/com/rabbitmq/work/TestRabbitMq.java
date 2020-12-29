package com.rabbitmq.work;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: sf
 * @Date: 2020/7/27
 * @version: 1.0
 */
@Component

@Slf4j
public class TestRabbitMq {

    @RabbitListener(queuesToDeclare = @Queue(value = "beool"))
    public void receivel(String message){
       System.out.println("message = " + message);
      log.info("普通模式"+message);

   }




}
