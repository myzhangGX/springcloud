package com.zhang.springcloud.service;

import com.zhang.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
//fallbackFactory =  DeptClientServiceFallBackFactory.class调用这个方法类
@FeignClient(value = "SPRINGCLOUD-PROCIDER-DEPT", fallbackFactory = DeptClientServiceFallBackFactory.class)
//fallbackFactory指定降级配置类
public interface DrptClientService {

  @GetMapping("/dept/get/{id}")
  public Dept queryById(@PathVariable("id") Long id);

  @GetMapping("/dept/list")
  public List<Dept> queryAll();

  @PostMapping("/dept/add")
  public boolean addDept(Dept dept);
}
