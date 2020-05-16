package com.atguigu.springcloud.entities;

import lombok.Data;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/4/6
 * @Description: com.atguiggu.springcloud.entities
 * @version: 1.0
 */


@Data
public class CommonResult<Object> {

    private Integer code;
    private String message;
    private  Object  data;

   public  CommonResult(Integer code, String message, Object date){
       this.code=code;
       this.message=message;
       this.data = date;
   }
}
