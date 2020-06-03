package com.zou.hystrix.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName FeignClientFallback
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2020/1/19 17:32
 */
@Component
public class FeignClientFallback implements FallbackFactory<DiscoverService> {
    @Override
    public DiscoverService create(Throwable throwable) {
        return new DiscoverService() {
            @Override
            public String test() {
                return "请求超时";
            }
        };
    }
}
