package com.atguigu.springcloud.serviceImpl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Cc;
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

  @Override
  public int create(Cc cc) {

    return paymentDao.insert(cc);

  }

  @Override
  public Cc getPaymentById(String id) {

    return paymentDao.selectById(id);
  }


}
