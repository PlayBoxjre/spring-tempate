package simple;

import com.playboxjre.spring.learn.cha3_11.Config;
import com.playboxjre.spring.learn.cha3_11.JsrBean;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * simple
 * Administrator
 * 2018\1\23 0023 15:32
 * EMAIL : playboxjre@gmail.com
 */
public class JsrTest {
    Logger log = LoggerFactory.getLogger(JsrTest.class);

    @Test
    public void testJsrInjectProvider(){
        AnnotationConfigApplicationContext ctx=
                new AnnotationConfigApplicationContext();
        ctx.register(Config.class);
        ctx.refresh();
        ctx.registerShutdownHook();

        JsrBean bean = ctx.getBean(JsrBean.class);
        assert bean != null;
        bean.show();

    }

}
