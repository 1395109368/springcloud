package com.song.ParentChilder;

import lombok.Data;

/**
 * @author songfeng
 * @date 2020/12/22
 */
@Data
public class Parent {

  private String parentName;
  private String parentAge;

  Parent(){
    System.out.println("调用父类得构造方法");
  }
}
