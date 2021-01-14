package com.atguiggu.springcloud.serviceImpl;

import com.atguiggu.springcloud.dao.PaymentDao;
import com.atguiggu.springcloud.service.PaymentService;
import com.atguigu.springcloud.entities.Cc;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

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
  public Cc getPaymentById(String id) {
    return paymentDao.selectById(id);
  }

  @Override
  public int create(Cc cc) {
    return 0;
  }
}
