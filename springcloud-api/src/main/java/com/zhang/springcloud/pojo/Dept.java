package com.zhang.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true) //链式写法
public class Dept implements Serializable { //Dept 实体类 orw 类表关系映射
  private long deptno;//主键
  private String dname;

  //这个数据库存在那个数据库的字段， 微服务，一个服务对应一个数据库，同一个信息可能不在同一个数据库
  private String db_source;

  public Dept(String dname) {
    this.dname = dname;
  }

  /**
   * 链式写法就是。后面可以接着写
   * Dept dept =new Dept（）；
   *
   *dept.setDetksk()
   .sdsese   */

}
