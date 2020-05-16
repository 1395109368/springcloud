package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/5/1
 * @Description: com.atguigu.springcloud.service
 * @version: 1.0
 */
@Component
public class PaymentFallbackService implements  PaymentHystrixService {

    @Override
    public String pay(String id) {
        return "这是因为调用出错，走实现接口的实现类";
    }

    @Override
    public String payk(String id) {
        return "这是因为调用出错，走实现接口的实现类";
    }
}
