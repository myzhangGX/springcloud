package com.zhang.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

//添加Eureka的启动
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.zhang.springcloud"})
@ComponentScan("com.zhang.springcloud")
public class DeptConsumer_8007 {
  public static void main(String[] args) {
    SpringApplication.run(DeptConsumer_8007.class, args);
  }
}
