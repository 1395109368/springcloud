package com.alibaba.myhander;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/5/4
 * @Description: com.alibaba.myhander
 * @version: 1.0
 */
public class CustomerBlokHandler {

    public  static CommonResult handlerException(BlockException exception){

        return  new CommonResult(444,"按客户自定义-------1","");

    }

    public  static CommonResult handlerException2(BlockException exception){

        return  new CommonResult(444,"按客户自定义-------2","");

    }
}
