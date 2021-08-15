package com.zhang.myrule;

import com.netflix.loadbalancer.IRule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZhangRule {

  @Bean
  public IRule myRule() {
    return new ZhangRandomRule();//默认是轮询现在我们自定义为ZhangRandomRule
    // RandomRule();//使用随机策略
    //return new RoundRobinRule();//使用轮询策略
    //return new AvailabilityFilteringRule();//使用轮询策略
    //return new RetryRule();//使用轮询策略
  }

}
