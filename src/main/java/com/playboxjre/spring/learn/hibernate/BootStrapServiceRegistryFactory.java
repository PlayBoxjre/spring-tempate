package com.playboxjre.spring.learn.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.beanvalidation.BeanValidationIntegrator;
import org.hibernate.integrator.spi.Integrator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * com.playboxjre.spring.learn.hibernate
 * Administrator
 * 2018\1\31 0031 17:39
 * EMAIL : playboxjre@gmail.com
 */
public class BootStrapServiceRegistryFactory {
    Logger log = LoggerFactory.getLogger(BootStrapServiceRegistryFactory.class);
    public enum BootStrapMethod{
        NATIVE_BOOTSTRAP,NATIVE_STANDARD,JPA
    }

    /**
     * 构建sessiongFactory
     * @return
     */
    public SessionFactory createSessionFactoryWithStandardRegistry(){
        StandardServiceRegistryBuilder standardServiceRegistryBuilder = new
                StandardServiceRegistryBuilder();
        standardServiceRegistryBuilder.configure();
        MetadataSources metadataSources =
                new MetadataSources(standardServiceRegistryBuilder
                        .build());
        Metadata metadata = metadataSources.buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        return sessionFactory;
    }



    public  BootstrapServiceRegistry createBootstrapServiceRegistry() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        Integrator integrator = new BeanValidationIntegrator();
        BootstrapServiceRegistryBuilder bootstrapServiceRegistryBuilder =
                new BootstrapServiceRegistryBuilder();
        bootstrapServiceRegistryBuilder.applyClassLoader(classLoader);
        bootstrapServiceRegistryBuilder.applyIntegrator(integrator);
        return bootstrapServiceRegistryBuilder.build();
    }
}
