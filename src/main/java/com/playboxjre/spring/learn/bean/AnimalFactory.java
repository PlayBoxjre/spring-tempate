package com.playboxjre.spring.learn.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnimalFactory {
    public static Eatable createInstance(){
        Logger logger = LoggerFactory.getLogger(Eatable.class);
            return new Eatable() {
                @Override
                public void eat(String something) {
                    logger.info("吃 {}",something);
                }
            };
    }

    public Dog createDog(){
        return new Dog();
    }

    public Bird createBird(){
        return new Bird();
    }

}
