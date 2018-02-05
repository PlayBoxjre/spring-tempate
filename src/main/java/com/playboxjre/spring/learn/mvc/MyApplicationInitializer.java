package com.playboxjre.spring.learn.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * com.playboxjre.spring.learn.mvc
 * Administrator
 * 2018\2\3 0003 13:21
 * EMAIL : playboxjre@gmail.com
 */
public class MyApplicationInitializer
//        extends AbstractAnnotationConfigDispatcherServletInitializer
{
    Logger log = LoggerFactory.getLogger(MyApplicationInitializer.class);

    //@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    //@Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ApplicationConfig.class};
    }

    //@Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
