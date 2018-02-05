package com.playboxjre.spring.learn.annotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * com.playboxjre.spring.learn.annotations
 * Administrator
 * 2018\1\22 0022 19:04
 * EMAIL : playboxjre@gmail.com
 */
public class StringStore implements Store<String> {
    Logger log = LoggerFactory.getLogger(StringStore.class);
    private String store;
    @Override
    public String get() {
        return store;
    }

    @Override
    public void remove() {
        store = null;
    }

    @Override
    public void set(String s) {
        this.store = s;
    }
}
