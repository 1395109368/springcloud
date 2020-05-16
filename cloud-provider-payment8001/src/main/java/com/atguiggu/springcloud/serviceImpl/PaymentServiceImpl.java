package com.atguiggu.springcloud.serviceImpl;

import com.atguiggu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguiggu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.atguiggu.springcloud.dao.PaymentDao;

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

    @Override
   public  int create(Payment payment){

       return paymentDao.insert(payment);

   }
    @Override
  public Payment  getPaymentById(String id){

    return paymentDao.selectById(id);
  }


}
