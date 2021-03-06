package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/4/26
 * @Description: com.atguigu.springcloud.controller
 * @version: 1.0
 */

@RestController
@Slf4j
public class OrderConsulController {
    public  static final  String INVOKE_URL="http://consul-provider-payment";
  //测试一下
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public  String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
        return  result;
    }


}
