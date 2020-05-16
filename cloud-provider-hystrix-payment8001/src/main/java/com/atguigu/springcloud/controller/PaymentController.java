package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/4/29
 * @Description: com.atguigu.springcloud.controller
 * @version: 1.0
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String pay(@PathVariable String id) {
        String result = paymentService.paymentInfo_ok(id);
        return result;
    }


    @GetMapping("/payment/hystrix/timeout/{id}")
    public String payk(@PathVariable String id) {
        String result = paymentService.paymentInfo_Timeout(id);
        return result;
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable String id) {
        String result = paymentService.paymentCircuitBreaker(id);
        return result;
    }

}
