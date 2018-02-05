package com.playboxjre.spring.learn.cha3_12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * com.playboxjre.spring.learn.cha3_12
 * Administrator
 * 2018\1\25 0025 10:30
 * EMAIL : playboxjre@gmail.com
 */
public class SettingsShow {
    Logger log = LoggerFactory.getLogger(SettingsShow.class);
    private Settings settings;

    public SettingsShow() {
    }

    public SettingsShow(Settings settings) {
        this.settings = settings;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    @Override
    public String toString() {
        return "SettingsShow{" +
                "settings=" + settings +
                '}';
    }

    public void showSettings(){
        log.info(settings.toString());
    }
}
