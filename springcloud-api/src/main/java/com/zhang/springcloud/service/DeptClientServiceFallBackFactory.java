package com.zhang.springcloud.service;

import com.zhang.springcloud.pojo.Dept;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DrptClientService> {
  @Override
  public DrptClientService create(Throwable cause) {
    return new DrptClientService() {
      @Override
      public Dept queryById(Long id) {
        return new Dept()
                .setDeptno(id)
                .setDname("id=>" + id + "没有对应的信息，客户端提供了降级的信息，这个服务现在已经被关闭")
                .setDb_source("没有数据~");
      }

      @Override
      public List<Dept> queryAll() {
        return null;
      }

      @Override
      public boolean addDept(Dept dept) {
        return false;
      }
    };
  }
}
