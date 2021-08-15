package com.zhang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


//开启eureka
@EnableEurekaServer //服务端的启动类，可以接受别人注册
@SpringBootApplication
public class EurekaServer_7001 {
  public static void main(String[] args) {
    SpringApplication.run(EurekaServer_7001.class, args);
  }
}