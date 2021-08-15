package com.zhang.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


//springboot启动类
@SpringBootApplication
//服务启动后这个注册到Eureka中
@EnableDiscoveryClient //服务发现
@EnableFeignClients
public class DeptProvider_8001 {
  public static void main(String[] args) {
    SpringApplication.run(DeptProvider_8001.class, args);
  }


}
