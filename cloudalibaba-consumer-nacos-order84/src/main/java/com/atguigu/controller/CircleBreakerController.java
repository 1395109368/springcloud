package com.atguigu.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/5/4
 * @Description: com.atguigu.controller
 * @version: 1.0
 */
@RestController
public class CircleBreakerController {

    public static final String url = "Http://nacos-payment-provider";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentSQL/{id}")
    public String payment(@PathVariable("id") String id) {

       return paymentService.payment(id);
    }



    @GetMapping("consumer/fallback/{id}")
   // @SentinelResource(value = "fallback", fallback = "handlerFallback")
   // @SentinelResource(value = "fallback", blockHandler = "blockHandler")
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler")
    public String fallback(@PathVariable String id) {

        String result = restTemplate.getForObject(url + "//paymentSQL/" + id, String.class, id);
        if (id.equals("5")) {
            throw new IllegalArgumentException("非法参数异常");

        }
        if (Integer
                .parseInt(id) > 10) {
            throw new IllegalArgumentException("为空");

        }
        return result;
    }

    public String handlerFallback() {
        return "444程序出错调用兜底方法";
    }
    public String blockHandler() {
        return "445程序出错调用兜底方法";
    }
}
