package com.playboxjre.spring.learn.mvc.repositories;

import com.playboxjre.spring.learn.mvc.Repository;
import com.playboxjre.spring.learn.mvc.repositories.save.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * com.playboxjre.spring.learn.mvc.repositories
 * Administrator
 * 2018\2\4 0004 16:19
 * EMAIL : playboxjre@gmail.com
 */
public class InternalSaver implements Repository<User> {
    Logger log = LoggerFactory.getLogger(InternalSaver.class);
    private Map<String, User> repo;

    public InternalSaver(Map<String, User> map) {
        this.repo = map;
    }

    public InternalSaver() {
        repo = new ConcurrentHashMap<>();
    }

    @Override
    public User get(String key) {
        return repo.get(key);
    }

    @Override
    public void add(String key, User value) {
        repo.put(key,value);
    }

    @Override
    public User remove(String key) {
        return repo.remove(key);
    }

    @Override
    public synchronized User update(String key, User value) {
        if (!repo.containsKey(key))
            repo.put(key,value);
        return repo.get(value);
    }
}
