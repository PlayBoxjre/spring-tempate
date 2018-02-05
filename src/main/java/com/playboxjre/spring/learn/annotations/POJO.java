package com.playboxjre.spring.learn.annotations;

import java.lang.annotation.*;

/**
 * com.playboxjre.spring.learn.annotations
 * Administrator
 * 2018\2\4 0004 16:41
 * EMAIL : playboxjre@gmail.com
 */
@Target({ElementType.ANNOTATION_TYPE,ElementType.FIELD,ElementType.PACKAGE,ElementType.PARAMETER,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface POJO {
    String value() default "";
    String author() default "";
    String description() default "";

}
