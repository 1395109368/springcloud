package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/4/6
 * @Description: com.atguiggu.springcloud.entities
 * @version: 1.0
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<Object> implements Serializable {

  private Integer code;
  private String message;
  private Object data;


}
