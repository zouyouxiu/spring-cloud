package com.zou.controller;

import com.zou.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @ClassName ThreadController
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2020/2/20 23:03
 */
@RestController
public class ThreadController {
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    ThreadService threadService;
    @RequestMapping("/test")
    public Object testThread() throws ExecutionException, InterruptedException {
        long l = System.currentTimeMillis();
        String a = threadService.test();
        long l1 = System.currentTimeMillis();
        System.out.println("非线程"+(l1-l));
        return "a";
    }
    @RequestMapping("/test2")
    public Object testThread2() throws ExecutionException, InterruptedException {
        long l = System.currentTimeMillis();
        Future future = threadService.test1();
        long l1 = System.currentTimeMillis();
        System.out.println("线程"+(l1-l));
        return future.get();
    }
   /* @Async("threadPoolTaskExecutor")
    @RequestMapping("/test2")
    public Future<String> test(){
        int poolSize = threadPoolTaskExecutor.getPoolSize();
        System.out.println(poolSize);
        int activeCount = threadPoolTaskExecutor.getActiveCount();
        System.out.println(activeCount);
        String name = Thread.currentThread().getName();
        System.out.println(name);
        return new AsyncResult( "a");
    }*/
}
