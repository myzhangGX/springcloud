package com.zhang.springcloud.controller;


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

  //  获取一些配置的信息，得到具体的微服务
  @Autowired
  private DiscoveryClient client;

  //如果要成功就改成get方法
  @PostMapping("/dept/add")
  public boolean addDept(Dept dept) {
    return deptService.addDept(dept);
  }

  @GetMapping("/dept/get/{id}")
  public Dept get(@PathVariable("id") long id) {
    return deptService.queryById(id);
  }

  //  不能是post的请求
  @GetMapping("/dept/list")
  public List<Dept> list() {

    return deptService.queryAll();
  }

  //  注册进来的微服务。。。 获取一些信息
  @GetMapping("/dtpt/discovery")
  public Object discovery() {
//    获取微服务列表的  清单
    List<String> services = client.getServices();
    System.out.println("discovery=>services" + services);

//    得到一个具体的微服务信息,通过具体的微服务id applicaiainName
    List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROCIDER-DEPT");

    for (ServiceInstance instance : instances) {
      System.out.println(
              instance.getHost() + "\t" +
                      instance.getPort() + "\t" +
                      instance.getUri() + "\t" +
                      instance.getServiceId()

      );
    }

    return this.client;
  }
}
