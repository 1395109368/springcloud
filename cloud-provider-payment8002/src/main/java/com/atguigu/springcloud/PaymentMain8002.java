package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/4/6
 * @Description: com.atguiggu.springcloud
 * @version: 1.0
 */

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMain8002 {

  public static void main(String[] args) {

    SpringApplication.run(PaymentMain8002.class, args);


  }


}
