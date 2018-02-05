package simple;

import com.playboxjre.spring.learn.cha9_aop.AdvanceInterface;
import com.playboxjre.spring.learn.cha9_aop.AopConfig;
import com.playboxjre.spring.learn.cha9_aop.SomeBean;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * simple
 * Administrator
 * 2018\1\26 0026 17:08
 * EMAIL : playboxjre@gmail.com
 */
public class Cha9AopTest {
    Logger log = LoggerFactory.getLogger(Cha9AopTest.class);


    @Test
    public void testAopAllMethodBefore(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AopConfig.class);
        SomeBean bean = context.getBean(SomeBean.class);
        log.info("start ---");
       bean.oneDay();
        bean.eatDinner();
        bean.sleep();
        bean.tvShow();
        bean.wakeUp();
        bean.read("hong");
    }

    @Test
    public void testAopAllMethodXml(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring/cha9_aop/application-aop.xml");
        SomeBean bean = context.getBean(SomeBean.class);
        log.info("start ---");

        bean.wakeUp();

        bean.read("红楼梦");

        AdvanceInterface advanceImp = context.getBean("advanceImp", AdvanceInterface.class);
        advanceImp.chat();

    }
}
