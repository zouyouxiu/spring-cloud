package com.zou.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @ClassName TestConfiguration
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2020/1/2 17:07
 */

@Configuration
public class TestConfiguration {
    @Bean
    public A aa() {
        System.out.println(1);
        A a = new A();
        a.setName("aaa");
        return a;
    }

   /* @Bean(name = "c")
    @Primary
    public C c1() {
        System.out.println(2);
        return new B();
    }*/
}
