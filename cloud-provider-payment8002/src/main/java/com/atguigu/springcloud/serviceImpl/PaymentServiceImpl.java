package com.atguigu.springcloud.serviceImpl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/4/7
 * @Description: com.atguiggu.springcloud.serviceImpl
 * @version: 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;



   public  int create(Payment payment){

       return paymentDao.insert(payment);

   }

  public Payment  getPaymentById(String id){

    return paymentDao.selectById(id);
  }


}
