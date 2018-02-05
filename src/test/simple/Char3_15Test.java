package simple;

import com.playboxjre.spring.learn.cha13.cha15.EmailServer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * simple
 * Administrator
 * 2018\1\25 0025 16:55
 * EMAIL : playboxjre@gmail.com
 */
public class Char3_15Test {
    Logger log = LoggerFactory.getLogger(Char3_15Test.class);

    @Test
    public void testApplicationEvent(){
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/char3/application-cha15.xml");
        EmailServer emailService = ctx.getBean("emailServer", EmailServer.class);
        emailService.sendEmail("x@gmail.com","hello");
        emailService.sendEmail("x@gmail.com","hello");
        emailService.sendEmail("b@gmail.com","hell ");

    }

}
