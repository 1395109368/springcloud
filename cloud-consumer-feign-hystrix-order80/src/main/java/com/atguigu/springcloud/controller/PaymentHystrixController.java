package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class PaymentHystrixController {

   @Resource
    PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String pay(@PathVariable String id) {
        String result = paymentHystrixService.pay(id);
        return result;
    }

   // @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")})
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand
    public String payk(@PathVariable String id) {
        String result = paymentHystrixService.payk(id);
        return result;
    }



    public  String paymentInfo_TimeOutHandler(String id){
        return  "我是消费者80  请求超时，展示兜底方法"+id  ;
    }



    public String payment_Global_FallbackMethod(){

        return "我是全局统一超时连接或调异常的处理方法";

    }


}
