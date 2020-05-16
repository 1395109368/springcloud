package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/4/28
 * @Description: com.atguigu.springcloud
 * @version: 1.0
 */

@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain80 {
    public static void main(String[] args) {

        SpringApplication.run(OrderFeignMain80.class, args);

    }

}
