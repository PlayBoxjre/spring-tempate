package com.playboxjre.spring.learn.cha9_aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * com.playboxjre.spring.learn.cha9_aop
 * Administrator
 * 2018\1\26 0026 19:53
 * EMAIL : playboxjre@gmail.com
 */
public class InAbsenceLessonException extends Throwable {
    Logger log = LoggerFactory.getLogger(InAbsenceLessonException.class);

    public InAbsenceLessonException(String message){
        super(message);
    }
}
