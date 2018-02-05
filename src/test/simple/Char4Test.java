package simple;

import org.aspectj.apache.bcel.util.ClassPath;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.UrlResource;
import org.springframework.util.StringUtils;
import sun.misc.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * simple
 * Administrator
 * 2018\1\26 0026 10:36
 * EMAIL : playboxjre@gmail.com
 */
public class Char4Test {
    Logger log = LoggerFactory.getLogger(Char4Test.class);

    @Test
    public void testStringUtils(){
        String s = StringUtils.cleanPath("http://www.konv.com:808/hello/world?h=1&y=109");
        log.info(s);
    }


    @Test
    public void testResource(){
        try {
            UrlResource urlResource = new UrlResource("http://www.konvigne.com");
            boolean open = urlResource.isOpen();
            boolean readable = urlResource.isReadable();
            boolean exists = urlResource.exists();
            String description = urlResource.getDescription();
            log.info("open:{}\n" +
                    "readable:{}\n" +
                    "exist:{}\n" +
                    "desr",open,readable,exists,description);
            InputStream inputStream = urlResource.getInputStream();
            if (inputStream==null)
                log.info("input is null ");
            else{
                int available = inputStream.available();
                log.info("availabe {}",available);
                URI uri = urlResource.getURI();
                URL url = urlResource.getURL();
                String string = uri.toASCIIString();
                log.info("toASCIIString {}",string);
                byte[] bytes = IOUtils.readFully(inputStream, 8454, true);
                log.info("content = {}",new String(bytes));

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClassPath(){
        ClassPath systemClassPath = ClassPath.getSystemClassPath();
        try {
            String path = systemClassPath.getPath("/");
            log.info(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
