package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Cc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.atguigu.springcloud.lb.LoadBalancer;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/4/8
 * @Description: com.atguigu.springcloud.controller
 * @version: 1.0
 */
@RestController
@Slf4j
public class OrderController {


    @Resource
    private DiscoveryClient discoveryClient;
    //public  static final String PAYMENT_URL="http://127.0.0.1:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    LoadBalancer loadBalancer;

    @GetMapping("/consumer/payment/create")
    public CommonResult create(Cc cc) {
        /*使用这个 restTemple  代替  发起请求  别忘了配置*/
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", cc, CommonResult.class);

    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Cc> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }


    @GetMapping("/consumer/payment/getFEntity/{id}")
    public CommonResult<Cc> getPayment2(@PathVariable("id") Long id) {

        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "payment/get/" + id, CommonResult.class);

        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();   //返回响应体内容
        } else {
            return new CommonResult(444, "出现错误", "出现错误");
        }

    }

    // 随机访问
    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (instances == null || instances.size() <= 0) {
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "paymnet/lb", String.class);

    }


}
