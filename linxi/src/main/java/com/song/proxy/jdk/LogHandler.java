package com.song.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  JDK代理方式
 * @author songfeng
 * @date 2020/12/16
 */
public class LogHandler implements InvocationHandler {

  //动态代理只能代理接口（不支持抽象类）

  private Object bbb;

  public Object bind(Object name) {
    this.bbb = name;
    return Proxy.newProxyInstance(name.getClass().getClassLoader()   //获取类加载器
        , name.getClass().getInterfaces()   //获取接口类列表
        , this);  //获取接口类实现对象
  }


  /**
   * @param proxy  代理类
   * @param method 方法
   * @param args   参数
   * @return
   * @throws Throwable
   */
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Object invoke = method.invoke(bbb, args);
    return invoke;
  }
}
