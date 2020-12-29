package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Cc;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/4/7
 * @Description: com.atguiggu.springcloud.service
 * @version: 1.0
 */
public interface PaymentService {

    public  int create(Cc cc);

    public Cc getPaymentById(String id);

}
