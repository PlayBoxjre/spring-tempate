package com.playboxjre.spring.learn.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bird implements Eatable {
    Logger logger = LoggerFactory.getLogger(Bird.class);
    @Override
    public void eat(String something) {
        logger.info("鸟 吃 {}",something);
    }
}
