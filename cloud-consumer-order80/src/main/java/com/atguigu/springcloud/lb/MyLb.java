package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/4/28
 * @Description: com.atguigu.lb
 * @version: 1.0
 */
@Component
public class MyLb implements LoadBalancer {

  private AtomicInteger atomicInteger = new AtomicInteger(0);

  public final int getAndIncrement() {
    int current;
    int next;
    do {
      current = this.atomicInteger.get();
      next = current >= 247483647 ? 0 : current + 1;

    } while (!this.atomicInteger.compareAndSet(current, next));
    System.out.println("******第几次访问" + next);

    return next;

  }


  @Override
  public ServiceInstance instances(List<ServiceInstance> serviceInstance) {
    int index = getAndIncrement() % serviceInstance.size();

    return serviceInstance.get(index);
  }
}
