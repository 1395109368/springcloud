package com.rabbitmq.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: sf
 * @Date: 2020/7/27
 * @version: 1.0
 */
@Data
public class User implements Serializable {
    private String name;
    private String password;
    private String  age;


}
