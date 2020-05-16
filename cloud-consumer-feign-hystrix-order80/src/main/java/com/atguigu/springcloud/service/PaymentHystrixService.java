package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/4/29
 * @Description: com.atguigu.springcloud.service
 * @version: 1.0
 */

@Component
@FeignClient(value="CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)  //接口出现异常，调用实现类
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String pay(@PathVariable(value="id") String id);



    @GetMapping("/payment/hystrix/timeout/{id}")
    public String payk(@PathVariable(value="id") String id) ;



}
