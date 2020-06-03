package com.zou.hystrix.feign;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName DiscoverService
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2020/1/14 15:38
 */
@FeignClient(name = "service-discover",fallbackFactory = FeignClientFallback.class)
public interface DiscoverService {
    @GetMapping("/test")
    String test();
}
