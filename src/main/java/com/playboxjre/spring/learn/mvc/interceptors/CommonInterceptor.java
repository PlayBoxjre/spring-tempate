package com.playboxjre.spring.learn.mvc.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * com.playboxjre.spring.learn.mvc.interceptors
 * Administrator
 * 2018\2\9 0009 17:07
 * EMAIL : playboxjre@gmail.com
 */
public class CommonInterceptor implements HandlerInterceptor {
    Logger log = LoggerFactory.getLogger(CommonInterceptor.class);
    private ThreadLocal<Long> local = new ThreadLocal<Long>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        local.set(System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws IOException {
        long currentTimeMillis = System.currentTimeMillis();
        long speedTime = currentTimeMillis - local.get();

        NumberFormat instance = DecimalFormat.getInstance();
        instance.setMaximumFractionDigits(2);
        String format = instance.format(speedTime*1.0/1000/60);
        log.info("[{}] reuquest duel time : {}",request.getRequestURL().toString(),format);

    }
}
