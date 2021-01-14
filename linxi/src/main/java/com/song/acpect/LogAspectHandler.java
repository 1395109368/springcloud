package com.song.acpect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 *
 * @author songfeng
 * @date 2020/12/15
 */
@Aspect
@Component
@Slf4j
public class LogAspectHandler {

  @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
  public void pointCut() {

  }


  /**
   * 第一个* 号表示返回值类型 第二个* 号表示所有类 第三个* 号表示所有方法
   */
  @Pointcut("execution(* org.springframework.web.bind.annotation..*.*(..))")
  public void pointCut1() {

  }

  /**
   * @param joinPoint 连接点
   * @param ex        异常，必须和方法中的参数名字保持一致
   */
  @AfterThrowing(pointcut = "pointCut()", throwing = "ex")
  public void afterThrows(JoinPoint joinPoint, Throwable ex) {

    Signature signature = joinPoint.getSignature();
    String name = signature.getName();
    System.out.println("发生异常方法的名qq字" + name + "异常 + " + ex);

  }
}
