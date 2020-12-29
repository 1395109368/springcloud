package com.atguiggu.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/4/7
 * @Description: com.atguiggu.springcloud.controller
 * @version: 1.0
 */
@RestController
@Slf4j
public class PaymentController {

//    @Autowired
//    PaymentService paymentService;

//    @Value("${server.port}")
//    private String serverPort;
//
//    @Resource
//    private DiscoveryClient discoveryClient;  //通过服务发现来发现该服务的信息
//
//    @PostMapping(value = "/payment/create")
//    @ResponseBody
//    public CommonResult create(@RequestBody Payment payment) {
//        int result = paymentService.create(payment);
//        System.out.println("插入成功" + result);
//
//        if (result > 0) {
//            return new CommonResult(200, "插入数据成功" + "serverPort" + serverPort, result);
//
//        } else {
//            return new CommonResult(444, "插入数据失败" + "serverPort" + serverPort, null);
//        }
//
//    }
//
//    @GetMapping(value = "/payment/get/{id}")
//    @ResponseBody
//    public CommonResult<Payment> getPaymentById(@PathVariable String id) {
//        System.out.println("进来查询");
//        Payment payment = paymentService.getPaymentById(id);
//
//        if (payment != null) {
//            return new CommonResult(200, "查询数据成功" + "serverPort" + serverPort, payment);
//
//        } else {
//            return new CommonResult(444, "查询数据失败", "null");
//        }
//
//    }
//
//
//    @GetMapping(value = "/payment/discovery")
//    @ResponseBody
//    public Object discovery() {
//
//        for (String element : discoveryClient.getServices()) {
//            System.out.println("elment" + element);
//        }
//        ;
//
//        for (ServiceInstance instance : discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE")) {
//
//            System.out.println(instance.getServiceId() + "/t" + instance.getHost() + instance.getPort() + "/t" + instance.getUri());
//
//
//        }
//        return this.discoveryClient;
//    }
//
//    @GetMapping(value = "/payment/lb")
//    @ResponseBody
//    public String getPaymentLB() {
//        return serverPort;
//
//    }
//
//    @GetMapping(value = "/payment/zipkin")
//    @ResponseBody
//    public String getPaymentzipkin() {
//        return "链路跟踪"+serverPort;
//
//    }
//
//    @GetMapping(value = "/payment/feign/timout")
//    @ResponseBody
//  public  String paymentFeignTimeout(){
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//          return serverPort;
//    }
//


}
