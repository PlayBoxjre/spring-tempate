package com.playboxjre.spring.learn.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * com.playboxjre.spring.learn.hibernate
 * Administrator
 * 2018\2\1 0001 20:09
 * EMAIL : playboxjre@gmail.com
 */
public class UserService {
    Logger log = LoggerFactory.getLogger(UserService.class);



    @Transactional
    public List findAllUsers(){
        return this.dao.queryUsers();
    }


    @Transactional
    public Serializable addUser(User user){
        return this.dao.insertUser(user);
    }

    public UserDao getDao() {
        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    private UserDao dao;



}
