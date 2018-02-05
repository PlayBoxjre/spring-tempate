package com.playboxjre.spring.learn.cha9_aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * com.playboxjre.spring.learn.cha9_aop
 * Administrator
 * 2018\1\26 0026 17:09
 * EMAIL : playboxjre@gmail.com
 */
@Configuration
@ComponentScan("com.playboxjre.spring.learn.cha9_aop")
@EnableAspectJAutoProxy
public class AopConfig {
    Logger log = LoggerFactory.getLogger(AopConfig.class);

    @Bean
    public SomeBean createSomeBean(){
        return  new SomeBean();
    }
}
