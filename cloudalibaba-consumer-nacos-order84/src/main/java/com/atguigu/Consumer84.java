package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/5/4
 * @Description: com.atguigu
 * @version: 1.0
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Consumer84 {

    public static void main(String[] args) {
        SpringApplication.run(Consumer84.class,args);
    }
}
