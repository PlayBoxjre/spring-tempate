package com.playboxjre.spring.learn.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;

/**
 * com.playboxjre.spring.learn.mvc
 * Administrator
 * 2018\2\6 0006 19:58
 * EMAIL : playboxjre@gmail.com
 */
public class MyDataBindingInitializer implements WebBindingInitializer {
    Logger log = LoggerFactory.getLogger(MyDataBindingInitializer.class);

    @Override
    public void initBinder(WebDataBinder binder) {
    }
}
