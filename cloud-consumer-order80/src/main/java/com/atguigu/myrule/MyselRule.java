package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/4/28
 * @Description: com.atguigu.myrule
 * @version: 1.0
 */
@Configuration
public class MyselRule {

@Bean
    public IRule myRule(){
    return  new RandomRule();   //定义为随机
}


}
