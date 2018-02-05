package com.playboxjre.spring.learn.cha3_12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * com.playboxjre.spring.learn.cha3_12
 * Administrator
 * 2018\1\25 0025 10:26
 * EMAIL : playboxjre@gmail.com
 */
@Configuration
@Import(ConfigSettings.class)
@PropertySource(encoding = "utf-8",value = {"spring/properties/database.properties"})
//@ImportResource(locations = {"spring/application-cha12.xml"})
public class Config12 {
    Logger log = LoggerFactory.getLogger(Config12.class);

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public SettingsShow createSettingsShow(Settings settings){
        return new SettingsShow(settings);
    }

    @Bean
    public DatabaseInfo databaseInfo(
           @Value("${db.url}") String url ,
           @Value("${db.username}") String username,
           @Value("${db.password}") String password,
           @Value("${db.port}")  Integer port
    ){
        return new DatabaseInfo(url,username,password,port);
    }
}
