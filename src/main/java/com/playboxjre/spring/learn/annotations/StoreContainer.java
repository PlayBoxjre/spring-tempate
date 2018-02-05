package com.playboxjre.spring.learn.annotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * com.playboxjre.spring.learn.annotations
 * Administrator
 * 2018\1\22 0022 19:08
 * EMAIL : playboxjre@gmail.com
 */
@Component
public class StoreContainer {
    Logger log = LoggerFactory.getLogger(StoreContainer.class);

    @Resource
    private Store<String> stringStore;

    public Store<String> getStringStore(){
        return stringStore;
    }

}
