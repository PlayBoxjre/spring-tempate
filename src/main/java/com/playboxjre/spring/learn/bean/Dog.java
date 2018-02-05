package com.playboxjre.spring.learn.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dog implements Eatable {
    Logger logger = LoggerFactory.getLogger(Dog.class);
    @Override
    public void eat(String something) {
        logger.info("狗 吃 {}",something);
    }
}
