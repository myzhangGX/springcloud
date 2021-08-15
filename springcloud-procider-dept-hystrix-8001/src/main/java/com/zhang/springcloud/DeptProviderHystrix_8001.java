package com.zhang.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

//springboot启动类
@SpringBootApplication
@EnableEurekaClient//服务启动后这个注册到Eureka中
@EnableDiscoveryClient //服务发现
@EnableCircuitBreaker  //开启对熔断的支持
public class DeptProviderHystrix_8001 {
  public static void main(String[] args) {
    SpringApplication.run(DeptProviderHystrix_8001.class, args);
  }


  @Bean
  public ServletRegistrationBean hystrixMetricsStreamServlet() {
    ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
    //访问该页面就是监控页面
    registrationBean.addUrlMappings("/actuator/hystrix.stream");

    return registrationBean;
  }
}
