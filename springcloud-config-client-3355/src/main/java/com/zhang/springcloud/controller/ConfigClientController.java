package com.zhang.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang
 * @create 2021/8/17
 */
@RestController
public class ConfigClientController {

  @Value("${spring.application.name}")
  private String applicationName; //获取微服务名称

  @Value("${eureka.client.service-url.defaultZone}")
  private String eurekaServer; //获取Eureka服务

  @Value("${server.port}")
  private String port; //获取服务端的端口号


  @RequestMapping("/config")
  public String getConfig() {
    return "applicationName:" + applicationName +
            "eurekaServer:" + eurekaServer +
            "port:" + port;
  }
}
