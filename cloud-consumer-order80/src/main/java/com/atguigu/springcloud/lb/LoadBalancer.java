package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/4/28
 * @Description: com.atguigu.lb
 * @version: 1.0
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> srviceInstance);
}
