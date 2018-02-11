package com.playboxjre.spring.learn.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * com.playboxjre.spring.learn.mvc
 * Administrator
 * 2018\2\3 0003 13:32
 * EMAIL : playboxjre@gmail.com
 */
@Configuration
@ImportResource("classpath:spring/dispatcher-servlet.xml")
public class ApplicationConfig {
    Logger log = LoggerFactory.getLogger(ApplicationConfig.class);





}
