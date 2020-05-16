package com.atguigu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/5/4
 * @Description: com.atguigu.controller
 * @version: 1.0
 */

@RestController
public class PaymenyController {
    @Value("${server.port}")
    private String port;

@GetMapping("/paymentSQL/{id}")
    public String payment(@PathVariable("id") String id) {

       System.out.println("进来"+port);



        return "111"+port;
    }


}
