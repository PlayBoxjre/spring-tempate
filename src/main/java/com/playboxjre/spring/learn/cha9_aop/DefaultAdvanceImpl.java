package com.playboxjre.spring.learn.cha9_aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * com.playboxjre.spring.learn.cha9_aop
 * Administrator
 * 2018\1\26 0026 17:42
 * EMAIL : playboxjre@gmail.com
 */
public class DefaultAdvanceImpl implements AdvanceInterface{
    Logger log = LoggerFactory.getLogger(DefaultAdvanceImpl.class);


    @Override
    public void chat() {
        log.info("聊天");
    }
}
