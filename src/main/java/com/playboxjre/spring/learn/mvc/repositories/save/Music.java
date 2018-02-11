package com.playboxjre.spring.learn.mvc.repositories.save;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * com.playboxjre.spring.learn.mvc.repositories.save
 * Administrator
 * 2018\2\6 0006 15:53
 * EMAIL : playboxjre@gmail.com
 */
public class Music {
    Logger log = LoggerFactory.getLogger(Music.class);
    private Integer id;
    private String songName;
    private String url;
    private String songer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSonger() {
        return songer;
    }

    public void setSonger(String songer) {
        this.songer = songer;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", songName='" + songName + '\'' +
                ", url='" + url + '\'' +
                ", songer='" + songer + '\'' +
                '}';
    }


    // create by build json plugin
    public JSONObject toJson() {
        JSONObject jo = new JSONObject();
        jo.put("id", id);
        jo.put("songName", songName);
        jo.put("url", url);
        jo.put("songer", songer);
        return jo;
    }
}
