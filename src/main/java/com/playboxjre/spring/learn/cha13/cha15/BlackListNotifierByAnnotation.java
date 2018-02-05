package com.playboxjre.spring.learn.cha13.cha15;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

/**
 * com.playboxjre.spring.learn.cha13.cha15
 * Administrator
 * 2018\1\25 0025 17:02
 * EMAIL : playboxjre@gmail.com
 */
public class BlackListNotifierByAnnotation {
    Logger log = LoggerFactory.getLogger(BlackListNotifierByAnnotation.class);
    @EventListener
    @Async
    public void onBlackEvent(BlackListEvent event){
        try {
            Thread.sleep(1000);
            log.info("Thread id {} 这是黑名单地址：{}",Thread.currentThread().getId(),event.getAddress());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @EventListener({ContextStartedEvent.class, ContextRefreshedEvent.class})
    public void handleContextStart() {
        log.info("context start or refresh event");

    }
}
