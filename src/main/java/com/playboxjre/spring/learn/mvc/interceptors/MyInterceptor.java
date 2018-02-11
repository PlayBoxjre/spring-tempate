package com.playboxjre.spring.learn.mvc.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * com.playboxjre.spring.learn.mvc.interceptors
 * Administrator
 * 2018\2\9 0009 15:58
 * EMAIL : playboxjre@gmail.com
 */
public class MyInterceptor implements AsyncHandlerInterceptor {
    Logger log = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("my interceptor  .... ");
    }
}
