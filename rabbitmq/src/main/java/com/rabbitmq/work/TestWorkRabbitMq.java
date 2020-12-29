package com.rabbitmq.work;

import com.rabbitmq.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: sf
 * @Date: 2020/7/27
 * @version: 1.0
 */

@Component
@Slf4j
public class TestWorkRabbitMq {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "logs",type = "fanout")  //绑定得交换机
            )
    })
   public void  work(User user){
      log.info("你在哪里呀"+user);
   }

}
