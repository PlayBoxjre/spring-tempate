package com.playboxjre.spring.learn.annotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * com.playboxjre.spring.learn.annotations
 * Administrator
 * 2018\1\22 0022 19:05
 * EMAIL : playboxjre@gmail.com
 */
public class IntStore implements Store<Integer> {
    Logger log = LoggerFactory.getLogger(IntStore.class);
    private Integer in;
    @Override
    public Integer get() {
        return in;
    }

    @Override
    public void remove() {
        in = null;
    }

    @Override
    public void set(Integer integer) {
        this.in = integer;
    }
}
