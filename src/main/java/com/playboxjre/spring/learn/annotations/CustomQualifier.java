package com.playboxjre.spring.learn.annotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * com.playboxjre.spring.learn.annotations
 * Administrator
 * 2018\1\22 0022 18:49
 * EMAIL : playboxjre@gmail.com
 */
@Documented
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface CustomQualifier {
    Logger log = LoggerFactory.getLogger(CustomQualifier.class);
    String value();
}
