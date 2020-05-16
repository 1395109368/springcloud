package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/4/29
 * @Description: com.atguigu.springcloud.service
 * @version: 1.0
 */
@Service
public class PaymentService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    public  String paymentInfo_ok(String id){
        return  "线程池"+Thread.currentThread().getName()+"PaymentOk ,id   "+id  ;
    }


    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",
    commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")})
    public  String paymentInfo_Timeout(String id){

        try {
            Thread.sleep(3000);
            return  "线程池"+Thread.currentThread().getName()+"PaymentOk ,id   "+id  ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  "线程池"+Thread.currentThread().getName()+"PaymentOk ,id   "+id  ;
    }


    public  String paymentInfo_TimeOutHandler(String id){
        return  "线程池"+Thread.currentThread().getName()+"PaymentOk  超时兜底方法,id   "+id  ;
    }
    //服务熔断

@HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
        @HystrixProperty(name="circuitBreaker.enabled",value = "true"),  //是否开启断路器
        @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
        @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
        @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳匝
})
    public String paymentCircuitBreaker(@PathVariable String id){
    if(Integer.parseInt(id)>5){
        throw new RuntimeException("id  不能小于5");
    }
    String serialNumber = IdUtil.simpleUUID();
    return   Thread.currentThread().getName()+"流水号"+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable String id){
        return "id  不能小与5 请稍后再试";
    }

}
