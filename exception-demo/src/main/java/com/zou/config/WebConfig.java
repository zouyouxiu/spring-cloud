package com.zou.config;

import com.zou.interceptor.Test2Interceptor;
import com.zou.interceptor.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName WebConfig
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2020/1/8 11:49
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> list2 = new ArrayList<>();
        list2.add("/**");
        registry.addInterceptor(new Test2Interceptor()).addPathPatterns(list2);
        List<String> list = new ArrayList<>();
        list.add("/**");
        registry.addInterceptor(new TestInterceptor()).addPathPatterns(list);

    }
}
