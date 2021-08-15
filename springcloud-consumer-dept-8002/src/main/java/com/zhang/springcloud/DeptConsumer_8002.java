package com.zhang.springcloud;

import com.zhang.myrule.ZhangRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

//添加Eureka的启动
@EnableEurekaClient
@SpringBootApplication
//在微服务启动的时候就能加载我们自定义Ribbon类
@RibbonClient(name = "SPRINGCLOUD-PROCIDER-DEPT", configuration = ZhangRule.class)
public class DeptConsumer_8002 {
  public static void main(String[] args) {
    SpringApplication.run(DeptConsumer_8002.class, args);
  }
}
