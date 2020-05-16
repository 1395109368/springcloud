package com.atguiggu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/4/7
 * @Description: com.atguiggu.springcloud.service
 * @version: 1.0
 */
public interface PaymentService {

    public  int create(Payment payment);

    public Payment  getPaymentById(String id);

}
