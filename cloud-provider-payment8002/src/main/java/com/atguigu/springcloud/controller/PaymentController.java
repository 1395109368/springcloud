package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Cc;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/4/7
 * @Description: com.atguiggu.springcloud.controller
 * @version: 1.0
 */
@Controller
@Slf4j
public class PaymentController<RestController> {

   @Resource
   PaymentService paymentService;

    @Value("${server.port}")
    private  String serverPort;
    //通过服务发现来发现该服务的信息
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    @ResponseBody
   public CommonResult create(Cc cc){

      int result =  paymentService.create(cc);
      System.out.println("插入成功"+result);

      if (result>0){
          return new CommonResult(200,"插入数据成功"+"serverPort"+serverPort,result);

      }else {
          return new CommonResult(444,"插入数据失败"+"serverPort"+serverPort,null);
      }

   }

    @GetMapping("payment/get/{id}")
    @ResponseBody
    public CommonResult getPaymentById(@PathVariable String  id){
        System.out.println("进来查询");
        Cc cc =  paymentService.getPaymentById(id);

        if (cc !=null){
            return new CommonResult(200,"查询数据成功"+"serverPort"+serverPort, cc);

        }else {
            return new CommonResult(444,"查询数据失败"+"serverPort"+serverPort,"null");
        }

    }
    @GetMapping(value = "/payment/lb")
    @ResponseBody
    public String getPaymentLB() {
        return serverPort;

    }

    @GetMapping(value = "/payment/discovery")
    @ResponseBody
    public Object discovery(){

        for (String element : discoveryClient.getServices()) {
            System.out.println("elment"+element);
        };

        for (ServiceInstance instance : discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE")) {

            System.out.println(instance.getServiceId()+"/t"+instance.getHost()+instance.getPort()+"/t"+instance.getUri());
        }
        return  this.discoveryClient;
    }
}
