package com.song.proxy.cglib;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author songfeng
 * @date 2020/12/16
 */
public class CglibFactory implements MethodInterceptor {


  private Object bbb;

  public Object bind(Object name) {
    this.bbb = name;
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(name.getClass());
    enhancer.setCallback(this);
    return enhancer.create();
  }


  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {
    Object invoke = methodProxy.invokeSuper(o, objects);
    return invoke;
  }
}
