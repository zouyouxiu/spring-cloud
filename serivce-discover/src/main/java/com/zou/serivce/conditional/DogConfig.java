package com.zou.serivce.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName DogConfig
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2019/12/22 1:42
 */
@Configuration
public class DogConfig {
    @Bean
    @ConditionalOnMissingBean
    public Animal animal() {
        return new Dog();
    }
}
