package com.playboxjre.spring.learn.annotations;

import com.playboxjre.spring.learn.bean.Bird;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * com.playboxjre.spring.learn.annotations
 * Administrator
 * 2018\1\22 0022 10:43
 * EMAIL : playboxjre@gmail.com
 */
public class QualifierImp {
    Logger log = LoggerFactory.getLogger(QualifierImp.class);

    @Autowired
    @CustomQualifier("bird")
    private Bird birds;

    public Bird getBirds(){
        return birds;
    }

    public void setBirds(Bird birds) {
        this.birds = birds;
    }
}
