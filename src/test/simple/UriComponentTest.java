package simple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;

/**
 * simple
 * Administrator
 * 2018\2\10 0010 19:46
 * EMAIL : playboxjre@gmail.com
 */
public class UriComponentTest {
    Logger log = LoggerFactory.getLogger(UriComponentTest.class);

    @Test
    public void test2(){
        UriComponents build = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(3306)
                .path("/show/{name}")
                .pathSegment("segment")
                .queryParam("type","json")
                .fragment("id=10")
                .build();
        String string = build.expand("x kong").encode().toUriString().toString();
        log.info(string);
    }



    @Test
    public void test() throws MalformedURLException {
        URI uri = UriComponentsBuilder.fromUriString(
                "http://localhost:8080/show/{name}"
        ).build().expand("kong").encode().toUri();
        String string = uri.toASCIIString();
        log.info(string);
        Resource resource = new UrlResource(uri);

        try {
            InputStream inputStream = resource.getInputStream();
            ByteArrayOutputStream sb = new ByteArrayOutputStream();
            int len = 0;
            byte[] buff = new byte[1025 * 8 - 2 ];
            while ((len = inputStream.read(buff)) != -1){
                sb.write(buff,0,len);
            }
            log.info(new String(sb.toByteArray(),"utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
