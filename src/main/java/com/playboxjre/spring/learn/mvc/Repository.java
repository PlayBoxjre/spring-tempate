package com.playboxjre.spring.learn.mvc;

/**
 * com.playboxjre.spring.learn.mvc
 * Administrator
 * 2018\2\4 0004 16:15
 * EMAIL : playboxjre@gmail.com
 */
public interface Repository<T> {

    public T get(String key);

    public void add(String key,T value);

    public T remove(String key);

    public T update(String key,T value);

}


