package com.zhang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//服务启动后这个注册到Eureka中
@EnableEurekaClient
//springboot启动类
@SpringBootApplication
@EnableDiscoveryClient //服务发现
public class DeptProvider_8004 {
  public static void main(String[] args) {
    SpringApplication.run(DeptProvider_8004.class, args);
  }

}
