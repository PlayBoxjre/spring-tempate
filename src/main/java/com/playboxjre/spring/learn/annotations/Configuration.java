package com.playboxjre.spring.learn.annotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * com.playboxjre.spring.learn.annotations
 * Administrator
 * 2018\1\22 0022 19:01
 * EMAIL : playboxjre@gmail.com
 */
@org.springframework.context.annotation.Configuration
@ComponentScan("com.playboxjre.spring.learn")
public class Configuration {
    Logger log = LoggerFactory.getLogger(Configuration.class);


    @Bean
    public IntStore intStore(){
        return new IntStore();
    }
    @Bean
    public StringStore stringStore(){
        return new StringStore();
    }


}
