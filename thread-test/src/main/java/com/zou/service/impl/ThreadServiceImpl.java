package com.zou.service.impl;

import com.zou.service.ThreadService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @ClassName ThreadServiceImpl
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2020/2/20 23:13
 */
@Service
public class ThreadServiceImpl implements ThreadService {
    @Override
    public String test() {
        for (int i = 0; i < 1000; i++) {
            for (int i1 = 0; i1 < 1000; i1++) {
                for (int i2 = 0; i2 < 1000; i2++) {
                    int o = 99999*i*99999*885941*554915947*15941594*2222222;
                }
            }
        }
        return "a";
    }
    @Override
    @Async
    public Future test1() {
        for (int i = 0; i < 1000; i++) {
            for (int i1 = 0; i1 < 1000; i1++) {
                for (int i2 = 0; i2 < 1000; i2++) {
                    int o = 99999*i*99999*885941*554915947*15941594*2222222;
                }
            }
        }
        System.out.println("执行完了");
        return new AsyncResult("a");
    }
}
