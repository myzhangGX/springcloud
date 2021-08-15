package com.zhang.springcloud.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration//相当于Contrller
public class ConfitBen {//@Configuration === spring applicationContect.xml

  //添加负载均衡实现RestTemplate
  //IRule
  // AvailabilityFilteringRule ：会先过滤掉，。奔溃的访问故障服务轮询

  /**
   * IRule:
   * RoundRobinRule 轮询策略
   * RandomRule 随机策略
   * AvailabilityFilteringRule ： 会先过滤掉，跳闸，访问故障的服务~，对剩下的进行轮询~
   * RetryRule ： 会先按照轮询获取服务~，如果服务获取失败，则会在指定的时间内进行，重试
   */

  @Bean
  @LoadBalanced  //，Ribbon
  public RestTemplate getConfiguration() {

    return new RestTemplate();
  }


}
