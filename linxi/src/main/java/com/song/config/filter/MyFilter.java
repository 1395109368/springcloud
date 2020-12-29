package com.song.config.filter;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.springframework.core.annotation.Order;

/**
 * 过滤器
 *
 * @author songfeng
 * @date 2020/12/15
 */
@Order(1)
@WebFilter(filterName = "myFilter1", urlPatterns = {"/*"})
public class MyFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    //获取请求的参数，进行过滤



  }


  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("初始化");
  }

  @Override
  public void destroy() {
    System.out.println("销毁");
  }


}
