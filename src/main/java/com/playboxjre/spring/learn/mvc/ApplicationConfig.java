package com.playboxjre.spring.learn.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * com.playboxjre.spring.learn.mvc
 * Administrator
 * 2018\2\3 0003 13:32
 * EMAIL : playboxjre@gmail.com
 */
@Configuration
@EnableWebMvc
public class ApplicationConfig implements WebMvcConfigurer{
    Logger log = LoggerFactory.getLogger(ApplicationConfig.class);

    /**
     * 开启对静态资源的访问支持
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
