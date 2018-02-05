package com.playboxjre.spring.learn.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * com.playboxjre.spring.learn.jdbc
 * Administrator
 * 2018\1\30 0030 15:22
 * EMAIL : playboxjre@gmail.com
 */
@Configuration
@PropertySource("db_config.properties")
public class DBConfig {
    Logger log = LoggerFactory.getLogger(DBConfig.class);


    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean()
    public DataSource dataSource(@Value("${db_url}") String url,
                                 @Value("${db_user}") String user,
                                 @Value("${db_password}") String password,
                                 @Value("${db_driver}")String  driver){

        log.info("url = {}",url);
        log.info("user {} password {}",user,password);
        log.info("Driver class {}",driver);
        DriverManagerDataSource  dataSource = new DriverManagerDataSource(url,user,password);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }

    @Bean()
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
     return new JdbcTemplate(dataSource);
    }




}
