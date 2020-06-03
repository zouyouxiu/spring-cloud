package com.zou.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.zou.hystrix.feign.DiscoverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HystrixController
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2020/1/14 14:53
 */
@RestController
public class HystrixController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixController.class);

    @Autowired
    private DiscoverService discoverService;

    @GetMapping("/test")
    /*@HystrixCommand(fallbackMethod = "testFallback",
    commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS,value = "3000")
    })*/
    public Object test() {
        return discoverService.test();
    }

    public Object testFallback(Integer id){
        return "请求超时";
    }
}
