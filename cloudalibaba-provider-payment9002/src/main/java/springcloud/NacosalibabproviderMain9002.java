package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/5/3
 * @Description: com.atguigu.springcloud
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosalibabproviderMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosalibabproviderMain9002.class,args);
    }


}
