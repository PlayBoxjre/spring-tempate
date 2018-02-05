package com.playboxjre.spring.learn.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * com.playboxjre.spring.learn.hibernate
 * Administrator
 * 2018\1\31 0031 17:20
 * EMAIL : playboxjre@gmail.com
 * Hibernate 的 引导和启动配置过程
 */
public class HibernateBootStrapConfiguration {
    Logger log = LoggerFactory.getLogger(HibernateBootStrapConfiguration.class);

    /**
     * 原生引导 native
     * (Hibernate SessionFactory的引导过程)
     *  1.构建ServiceRegistry(持有hibernate引导与运行时所需的服务)
     *      2种 ：
     *          1. org.hibernate.boot.registry.BootstrapServiceRegistry
     *              BootstrapServiceRegistryBuilder创建
     *          2. org.hibernate.boot.registry.StandardServiceRegistry
     *
     *@see org.hibernate.boot.registry.BootstrapServiceRegistry
     *@see org.hibernate.boot.registry.BootstrapServiceRegistryBuilder
     *@see  org.hibernate.boot.registry.StandardServiceRegistry
     *
     * @version 5.0-hibernate
     */
    public void nativeBootStrap(){
        // 创建BootstrapServiceRegistry
     //   BootstrapServiceRegistry bootstrapServiceRegistry = createBootstrapServiceRegistry();

    }



    /**
     * JPA引导
     */
    public void jpaBootStrap(){

    }
}
