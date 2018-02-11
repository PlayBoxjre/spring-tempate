package com.playboxjre.spring.learn.mvc;

import com.playboxjre.spring.learn.mvc.interceptors.MyInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 全局配置
 * com.playboxjre.spring.learn.mvc
 * Administrator
 * 2018\2\3 0003 13:32
 * EMAIL : playboxjre@gmail.com
 */
@Configuration
@ComponentScan("com.playboxjre.spring.learn.mvc.config")
@EnableWebMvc
@EnableAsync
public class RootConfig implements WebMvcConfigurer {
    Logger logger = LoggerFactory.getLogger(RootConfig.class);



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        MyInterceptor myInterceptor = new MyInterceptor();
        registry.addInterceptor(myInterceptor);
    }

    @Bean
    @Qualifier("messageQueue")
    public BlockingQueue<DeferredResult> blockingQueue() {
        BlockingQueue blockingQueue = new LinkedBlockingQueue<>();
        return blockingQueue;
    }

    @Bean(destroyMethod = "interrupted")
    public Thread printThread(@Qualifier("messageQueue") BlockingQueue blockingQueue) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("Print Thread starting ....");
                int count = 0;
                while (Thread.currentThread().isAlive() && !Thread.currentThread().isInterrupted()) {
                    Object take = null;
                    try {
                        take = blockingQueue.take();
                        if (take == null)
                            continue;
                        logger.info("Print Thread Run {}....",count++);
                        if (take instanceof DeferredResult) {
                            executeDeffred(take, count);
                        } else if (take instanceof ResponseBodyEmitter) {
                            executeResponseBodyEmitter(take, count);
                        }
                    } catch (InterruptedException e) {
                        continue;
                    }


                }

                throw new IllegalStateException("Print thread is interrupted");
            }

            private void executeResponseBodyEmitter(Object take, int i) {
                ResponseBodyEmitter take1 = (ResponseBodyEmitter) take;
                try {
                    for (int j = 0; j < 10; j++) {
                        logger.info(String.format("emitter send 'hello world - %d \n'", i+j));
                        take1.send(String.format("emitter send 'hello world - %d \n'", i+j));
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    take1.complete();
                    logger.info("emitter Completed");
                } catch (IOException e) {
                    logger.info("IOException message :{}",e.getMessage());
                    take1.completeWithError(e);
                }

            }

            private void executeDeffred(Object take, int count) {
                DeferredResult take1 = (DeferredResult) take;
                take1.setResult(String.format("this is message %d \n", count));
            }
        });

        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setDaemon(true);
        thread.setName("print thread");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
            }
        });
        thread.start();
        return thread;
    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 配置异步请求支持
     * <mvc:annotation-driven ><async-support>true</async-support></mvc:annotation-driven>
     *
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setDefaultTimeout(30 * 1000);
        configurer.setTaskExecutor(mvcTaskExecutor());
    }

    @Bean
    public ThreadPoolTaskExecutor mvcTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setQueueCapacity(100);
        executor.setMaxPoolSize(25);
        return executor;
    }
}
