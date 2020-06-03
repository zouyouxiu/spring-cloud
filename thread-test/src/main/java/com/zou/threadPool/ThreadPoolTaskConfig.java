package com.zou.threadPool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.ThreadFactory;

/**
 * @ClassName ThreadPoolTaskConfig
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2020/2/20 16:43
 */


@Configuration
@EnableAsync
public class ThreadPoolTaskConfig {


    /**
     * 核心线程数（默认线程数）:线程池创建时候初始化的线程数
     */
    private static final int corePoolSize = 10;
    /**
     * 最大线程数 :线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
     */
    private static final int maxPoolSize = 100;
    /**
     * 允许线程空闲时间（单位：默认为秒）:当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
     */
    private static final int keepAliveTime = 30;
    /**
     * 缓冲队列大小:用来缓冲执行任务的队列
     */
    private static final int queueCapacity = 200;
    /**
     * 线程池名前缀:设置好了之后可以方便我们定位处理任务所在的线程池
     */
    private static final String threadNamePrefix = "taskExecutor";

    @Bean // bean的名称，默认为首字母小写的方法名
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadFactory threadFactory=new ThreadFactoryBuilder().setNameFormat("thread-test-%d").build();
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadFactory(threadFactory);
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveTime);
        executor.setThreadNamePrefix(threadNamePrefix);
        //线程池关闭的时候等待所有任务都完成后，再继续销毁其他的 Bean
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 线程池对拒绝任务的处理策略：这里采用了CallerRunsPolicy策略，当线程池没有处理能力的时候，该策略会直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
        //executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化
        executor.initialize();
        return executor;
    }
}