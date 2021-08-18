package com.zhang.springcloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhang.springcloud.pojo.Dept;
import com.zhang.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//提供Restful服务
@RestController
public class DeptController {
  @Autowired
  private DeptService deptService;

  @GetMapping("/dept/get/{id}")
  @HystrixCommand(fallbackMethod = "hystrixGet")   //下面的方法没用查出数据将会调用hystrixGet的方法
  public Dept get(@PathVariable("id") Long id) {
    Dept dept = deptService.queryById(id);
    if (dept == null) {
      //捕获异常
      throw new RuntimeException("id=>" + id + ",不存在该用户，或者信息无法找到");
    }

    return dept;
  }

  //  备选方案
  public Dept hystrixGet(@PathVariable("id") Long id) {
    Dept dept = deptService.queryById(id);

//链式编程方式
    return new Dept()
            .setDeptno(id)
            .setDname("id => " + id + "没有对应的信息，null@htstrix")
            .setDb_source("no this database in MySql");
  }

}
