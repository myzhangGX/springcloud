package com.zhang.springcloud.controller;

import com.zhang.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@RestController
public class DeptConsumerController {
//  理解：消费者不应该存在service层
//  RestTemplote。。。。提供该我们直接调用就可以了， 注册dapspring中
// url 实体 Map class《T> restponseType

//  通过Ribbon 我们的地址。应该是一个变量，通过服务名来访问
//  private static final String REST_URL_PREFIX = "http://localhost:8001";

  private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROCIDER-DEPT";


  @Autowired
  private RestTemplate restTemplate;// 提供多种便捷远程访问http服务的,简单的Restful服务模板

  @RequestMapping("/consumer/dept/add")
  public boolean add(Dept dept) {
    return Boolean.TRUE.equals(restTemplate.postForObject(REST_URL_PREFIX + "/dept/add/", dept, boolean.class));
  }


  @RequestMapping("/consumer/dept/get/{id}")
  public Dept get(@PathVariable("id") long id) {
    return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
  }


  @RequestMapping("/consumer/dept/list")
  public List<Dept> list() {

    return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list/", List.class);
  }

}
