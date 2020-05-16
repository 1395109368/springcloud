package com.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.myhander.CustomerBlokHandler;
import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/5/4
 * @Description: com.alibaba.controller.controller
 * @version: 1.0
 */

@RestController
public class RateLimitController {


    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")    // 编码唯一
    public CommonResult testHotKey(@RequestParam(value = "p1", required = false) String p1,
                                   @RequestParam(value = "p2", required = false) String p2) {


        return  new CommonResult(200," 按资源名称限流","456");
    }

    public String handleException(String p1, String p2, BlockException exception) {

        return  "服务不可用";
    }



    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")    //
    public CommonResult testHotKey() {


        return  new CommonResult(200," 按url名称限流","456");
    }


    @GetMapping("/rateLimit/customerBlokHandler")
    @SentinelResource(value = "customerBlokHandler",blockHandlerClass =CustomerBlokHandler.class,blockHandler ="handlerException2")    //
    public CommonResult customerBlokHandler() {


        return  new CommonResult(200," 按客户自定义名称限流","456");
    }

}
