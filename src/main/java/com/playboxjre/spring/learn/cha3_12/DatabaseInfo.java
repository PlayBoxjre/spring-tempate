package com.playboxjre.spring.learn.cha3_12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * com.playboxjre.spring.learn.cha3_12
 * Administrator
 * 2018\1\25 0025 11:08
 * EMAIL : playboxjre@gmail.com
 */
public class DatabaseInfo {
    Logger log = LoggerFactory.getLogger(DatabaseInfo.class);
    private String url;
    private String username;
    private String password;
    private Integer port;

    public DatabaseInfo() {
    }

    public DatabaseInfo(String url, String username, String password, Integer port) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "DatabaseInfo{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", port=" + port +
                '}';
    }
}
