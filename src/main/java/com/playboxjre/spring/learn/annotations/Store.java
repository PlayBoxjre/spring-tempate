package com.playboxjre.spring.learn.annotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * com.playboxjre.spring.learn.annotations
 * Administrator
 * 2018\1\22 0022 19:03
 * EMAIL : playboxjre@gmail.com
 */
public interface Store<T> {
    Logger log = LoggerFactory.getLogger(Store.class);
    T get();
    void remove();
    void set(T t);
}
