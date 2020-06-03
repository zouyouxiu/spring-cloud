package com.zou.serivce.util;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RibbonConfiguration
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2019/12/18 16:43
 */
/*@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule() {
        //负载均衡规则改为随机
        return new RandomRule();
    }
}*/
