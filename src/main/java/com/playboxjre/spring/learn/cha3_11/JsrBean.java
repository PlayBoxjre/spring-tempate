package com.playboxjre.spring.learn.cha3_11;

import com.playboxjre.spring.learn.bean.Bird;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

/**
 * com.playboxjre.spring.learn.cha3_11
 * Administrator
 * 2018\1\23 0023 15:26
 * EMAIL : playboxjre@gmail.com
 */
@Named("jsr")
public class JsrBean {
    Logger log = LoggerFactory.getLogger(JsrBean.class);

    private Provider<Bird> birdProvider;

    @Inject
    public void setBird(Provider<Bird> bird){
        this.birdProvider = bird;
    }

    public void show() {
        birdProvider.get().toString();
    }
}
