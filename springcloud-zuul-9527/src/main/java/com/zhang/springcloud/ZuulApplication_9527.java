package com.zhang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy  //开启路由
public class ZuulApplication_9527 {
  public static void main(String[] args) {
    SpringApplication.run(ZuulApplication_9527.class, args);
  }
}
