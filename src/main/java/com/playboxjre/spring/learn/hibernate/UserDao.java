package com.playboxjre.spring.learn.hibernate;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * com.playboxjre.spring.learn.hibernate
 * Administrator
 * 2018\2\1 0001 19:43
 * EMAIL : playboxjre@gmail.com
 */
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    Logger log = LoggerFactory.getLogger(UserDao.class);
    public List  queryUsers(){
        List from_user = sessionFactory.getCurrentSession().createQuery("from User").list();
        return from_user;
    }

    public Serializable insertUser(User user) {
         sessionFactory.getCurrentSession().saveOrUpdate(user);
         //sessionFactory.getCurrentSession().saveOrUpdate(user);
         return 0l;
    }
}
