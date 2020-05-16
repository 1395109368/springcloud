package com.atguigu.service;

import org.springframework.stereotype.Component;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/5/4
 * @Description: com.atguigu.service
 * @version: 1.0
 */

@Component
public class PaymentFallbackService implements  PaymentService{
    @Override
    public String payment(String id) {
        return "open  调用出错";
    }
}
