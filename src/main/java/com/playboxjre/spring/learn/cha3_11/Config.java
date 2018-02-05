package com.playboxjre.spring.learn.cha3_11;

import com.playboxjre.spring.learn.annotations.PostConstructImp;
import com.playboxjre.spring.learn.bean.Bird;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * com.playboxjre.spring.learn.cha3_11
 * Administrator
 * 2018\1\23 0023 15:30
 * EMAIL : playboxjre@gmail.com
 */
@Configuration
@ComponentScan(basePackages = "com.playboxjre.spring.learn.cha3_11")
public class Config {
    Logger log = LoggerFactory.getLogger(Config.class);

    @Scope()
    @Bean
    public Bird createBird(){
        return  new Bird();
    }

    @Bean
    public PostConstructImp postConstructImp(){
        return new PostConstructImp();
    }
}
