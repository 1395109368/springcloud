package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/4/13
 * @Description: com.atguigu.springcloud.controller
 * @version: 1.0
 */

@RestController
public class PaymentController {

    @Value("${server.port}")
    private  String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;  //通过服务发现来发现该服务的信息

    @RequestMapping(value="/payment/zk")
    public  String paymentzk(){

        return "serverPort"+serverPort;
    }


}
