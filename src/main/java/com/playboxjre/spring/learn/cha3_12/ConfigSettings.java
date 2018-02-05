package com.playboxjre.spring.learn.cha3_12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * com.playboxjre.spring.learn.cha3_12
 * Administrator
 * 2018\1\25 0025 10:32
 * EMAIL : playboxjre@gmail.com
 */
public class ConfigSettings {
    Logger log = LoggerFactory.getLogger(ConfigSettings.class);


    @Bean
    @Profile("default")
    public Settings defaultSettings(){
        Settings settings = new Settings("default","default     Settings");
        return settings;
    }

    @Bean
    @Profile("dev")
    public Settings devSettings(){
        Settings settings = new Settings("dev","devSettings");
        return settings;
    }

    @Bean
    @Profile("product")
    public Settings proSettings(){
        Settings settings = new Settings("product","proSettings");
        return settings;
    }
}
