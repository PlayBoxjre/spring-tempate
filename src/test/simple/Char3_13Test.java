package simple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;
import java.util.Properties;

/**
 * simple
 * Administrator
 * 2018\1\25 0025 16:12
 * EMAIL : playboxjre@gmail.com
 */
public class Char3_13Test {
    Logger log = LoggerFactory.getLogger(Char3_13Test.class);

    @Test
    public void testXMlConfigMessageSource(){
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/char3/application-cha13.xml");
        String message = ctx.getMessage("title", null, "Default", null);
        String time = ctx.getMessage("time",new Object[]{3},"Defalult", Locale.CHINA);
        String timeEN = ctx.getMessage("time",new Object[]{3},"Defalult", Locale.UK);
        log.info("message {}",message);
        log.info("time {}",time);
        log.info("timeEn {}",timeEN);
    }


    @Test
    public void testClasspath(){
        String classpath = System.getenv("classpath");
        log.info(classpath);
       /* Map<String, String> getenv = System.getenv();
        getenv.forEach((k,v)->{
            log.info("{} = {}",k,v);
        });*/
        Properties properties = System.getProperties();
        properties.forEach((k,v)->{
            log.info("{} = {}",k,v);
        });
    }
}
