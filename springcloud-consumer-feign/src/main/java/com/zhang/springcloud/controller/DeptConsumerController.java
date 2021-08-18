package com.zhang.springcloud.controller;

import com.zhang.springcloud.pojo.Dept;
import com.zhang.springcloud.service.DrptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {


  @Qualifier("com.zhang.springcloud.service.DrptClientService")
  @Autowired
  private DrptClientService service = null;

  @RequestMapping("/consumer/dept/add")
  public boolean add(Dept dept) {
    return this.service.addDept(dept);
  }


  @RequestMapping("/consumer/dept/get/{id}")
  public Dept get(@PathVariable("id") long id) {
    return this.service.queryById(id);
  }


  @RequestMapping("/consumer/dept/list")
  public List<Dept> list() {
    return this.service.queryAll();
  }

}
