package com.zou.serivce.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName RegisterService
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2019/12/17 10:15
 */
@FeignClient("service-register")
public interface RegisterService {
    @GetMapping("/test")
    String test();
}
