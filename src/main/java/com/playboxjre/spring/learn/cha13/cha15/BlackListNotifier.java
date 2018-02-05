package com.playboxjre.spring.learn.cha13.cha15;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

/**
 * com.playboxjre.spring.learn.cha13.cha15
 * Administrator
 * 2018\1\25 0025 16:49
 * EMAIL : playboxjre@gmail.com
 */
public class BlackListNotifier implements ApplicationListener<BlackListEvent> {
    Logger log = LoggerFactory.getLogger(BlackListNotifier.class);

    @Override
    public void onApplicationEvent(BlackListEvent event) {
        String address = event.getAddress();
        log.info("address [{}] is black list member",address);
    }
}
