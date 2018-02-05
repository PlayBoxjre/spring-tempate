package com.playboxjre.spring.learn.cha13.cha15;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

/**
 * com.playboxjre.spring.learn.cha13.cha15
 * Administrator
 * 2018\1\25 0025 16:43
 * EMAIL : playboxjre@gmail.com
 */
public class BlackListEvent extends ApplicationEvent {
    Logger log = LoggerFactory.getLogger(BlackListEvent.class);

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    private final String address;



    private final String test;

    public String getTest() {
        return test;
    }

    public BlackListEvent(Object source, String address, String test) {
        super(source);
        this.address = address;
        this.test = test;
    }


    public String getAddress(){
        return this.address;
    }
}
