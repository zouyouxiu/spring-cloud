package com.zou.serivce.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName UserBeanConfig
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2019/12/18 19:00
 */
@Configuration
public class UserBeanConfig {
    @Bean
    public Animal animal() {
        return new Cat();
    }

}
