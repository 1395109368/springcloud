package com.atguiggu.springcloud.service;

import com.atguigu.springcloud.entities.Cc;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/4/7
 * @Description: com.atguiggu.springcloud.service
 * @version: 1.0
 */
public interface PaymentService {

  int create(Cc cc);

  Cc getPaymentById(String id);

}
