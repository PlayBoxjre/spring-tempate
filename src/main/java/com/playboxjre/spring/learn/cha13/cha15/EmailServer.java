package com.playboxjre.spring.learn.cha13.cha15;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.List;

/**
 * com.playboxjre.spring.learn.cha13.cha15
 * Administrator
 * 2018\1\25 0025 16:45
 * EMAIL : playboxjre@gmail.com
 */
public class EmailServer implements ApplicationEventPublisherAware {
    Logger log = LoggerFactory.getLogger(EmailServer.class);

    private List<String> blackList;
    private ApplicationEventPublisher publisher;

    public void setBlackList(List<String> blackList) {
        this.blackList = blackList;
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void sendEmail(String address, String text) {
        if (blackList.contains(address)) {
            BlackListEvent event = new BlackListEvent(this, address, text);
            publisher.publishEvent(event);
            return;
        }
        // send email...
        log.info("正在发送邮件》》》》{};content : {}",address,text);
    }
}
