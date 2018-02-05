package com.playboxjre.spring.learn.annotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * com.playboxjre.spring.learn.annotations
 * Administrator
 * 2018\1\22 0022 19:29
 * EMAIL : playboxjre@gmail.com
 */
public class PostConstructImp {
    Logger log = LoggerFactory.getLogger(PostConstructImp.class);

    @PostConstruct
    public void postConstructMethod(){
        log.info("inintttttt.....");
    }

    @PreDestroy
    public void destoryConstructMethod(){
        log.info("destory...");
    }
}
