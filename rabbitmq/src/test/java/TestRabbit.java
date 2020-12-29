import com.rabbitmq.entity.User;
import com.rabbitmq.main;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Auther: sf
 * @Date: 2020/7/27
 * @version: 1.0
 */
@SpringBootTest(classes = main.class)
@RunWith(SpringRunner.class)
@Slf4j
public class TestRabbit {

    @Resource
    RabbitTemplate rabbitTemplate;


    @Test
    public void testRabbit1() {

        rabbitTemplate.convertAndSend("beool", " 你是谁啊，我是你得恋人，你这么不认识我了");
    }

    @Test
    public void work() {
        for (int i = 0; i < 10; i++) {
            log.info("你是谁啊，我是你得恋人，你这么不认识我了" + i);
            rabbitTemplate.convertAndSend("kao", " 你是谁啊，我是你得恋人，你这么不认识我了" + i);
        }
    }

    @Test
    public void guangbo(){
        User user  = new User();
        user.setName("你是");
        user.setAge("46");

        log.info("操作之前");
        rabbitTemplate.convertAndSend("logs","",user);

        log.info("操作成功");
    }


}
