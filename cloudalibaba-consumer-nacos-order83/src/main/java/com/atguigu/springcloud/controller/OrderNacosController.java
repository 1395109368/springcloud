package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/5/3
 * @Description: com.atguigu.springcloud.controller
 * @version: 1.0
 */
@RestController
public class OrderNacosController {

  @Value("${server.port}")
  private String serverPort;

  @Value("${service-url.nacos-users-service}")
  private String url;

  @Resource
  RestTemplate restTemplate;

  @GetMapping("/consumer/payment/nacos/{id}")
  public String paymentInfo(@PathVariable("id") String id) {

    return restTemplate.getForObject(url + "/payment/nacos/" + id, String.class);
  }


}
