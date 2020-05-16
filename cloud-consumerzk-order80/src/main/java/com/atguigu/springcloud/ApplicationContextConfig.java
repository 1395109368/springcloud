package com.atguigu.springcloud;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/4/19
 * @Description: com.atguigu.springcloud
 * @version: 1.0
 */

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
    return new RestTemplate();
}

}
