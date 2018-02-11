package com.playboxjre.spring.learn.mvc.controllers;

import com.playboxjre.spring.learn.mvc.repositories.save.Music;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * com.playboxjre.spring.learn.mvc.controllers
 * Administrator
 * 2018\2\6 0006 15:51
 * EMAIL : playboxjre@gmail.com
 */
@RestController(value = "/music")
@SessionAttributes("music")
public class MusicResource {
    Logger log = LoggerFactory.getLogger(MusicResource.class);

    private Map<String,Music> musicMap = new ConcurrentHashMap(){
        {
            Music music = new Music();
            music.setId(1);
            music.setSonger("b1");
            music.setSongName("seve");
            music.setUrl("http://localhost:8080/music/song/seve.mp3");
            put("1",music);
        }
    };

    @ModelAttribute
    public Music findMusic(@RequestParam("id") String song){
        log.info("find music id {} ",song);
        return musicMap.get(song);
    }

    @ModelAttribute
    public String  modelA(){
        log.info("2=---- this is model 1");
        return "modelA()";
    }

    @RequestMapping("song")
    public String getMusic(@ModelAttribute Music music) throws FileNotFoundException {

        return music.toJson().toString();
    }



    @GetMapping("entity")
    public ResponseEntity<Object> handle(HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException {
        final StringBuffer buffer = new StringBuffer();



        buffer.append("<html><head><meta charset='utf-8'/><title>Request Headers</title></head>");
        buffer.append("<body><table>");

        HttpHeaders headers = requestEntity.getHeaders();
        headers.toSingleValueMap().forEach((k,v)->{
            String string = String.format("<tr><td>%s</td><td>%s</td></tr>",k,v);
            buffer.append(string);
        });
        byte[] body = requestEntity.getBody();
        if (body != null) {
            String bodyStr = new String(body, "utf-8");
            buffer.append(String.format("<tr><td>%s</td><td>%s</td></tr>", "请求数据", bodyStr));
        }
        buffer.append("</table></body></html>");
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("Content-Type","text/html;charset=utf-8");
        responseHeader.setAccessControlAllowOrigin("*");
        return new ResponseEntity<>(buffer.toString(),responseHeader, HttpStatus.CREATED);
    }
}
