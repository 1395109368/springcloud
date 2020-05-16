package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/4/19
 * @Description: com.atguigu.springcloud.controller
 * @version: 1.0
 */
public class OrderZKController {
    public  static final  String INVOKE_URL="http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public  String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
        return  result;
    }

    @GetMapping("/consumer/payment/zipkin")
    public  String paymentzipkin(){
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/zipkin/",String.class);
        return  result;
    }

}
