package simple;

import com.playboxjre.spring.learn.cha3_12.Config12;
import com.playboxjre.spring.learn.cha3_12.DatabaseInfo;
import com.playboxjre.spring.learn.cha3_12.SettingsShow;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MutablePropertySources;

import java.util.Map;

/**
 * simple
 * Administrator
 * 2018\1\25 0025 10:32
 * EMAIL : playboxjre@gmail.com
 */

public class Char12Ttest {
    Logger log = LoggerFactory.getLogger(Char12Ttest.class);

    @Test
    public void testProfiles(){
        // no @profile annotation
        // expected single matching bean but found 2: devSettings,proSettings
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Config12.class);
//        context.getEnvironment().setActiveProfiles("dev");
        context.getEnvironment().setDefaultProfiles("dev");
        context.refresh();
        context.registerShutdownHook();
        SettingsShow bean = context.getBean(SettingsShow.class);
        bean.showSettings();


        DatabaseInfo bean1 = context.getBean(DatabaseInfo.class);
        log.info(bean1.toString());
        boolean b = context.getEnvironment().containsProperty("spring.profiles.active");
        assert b == true;
        log.info("spring.profiles.active = {}",context.getEnvironment().getProperty("spring.profiles.active"));

        Map<String, Object> systemEnvironment = context.getEnvironment().getSystemEnvironment();
        Map<String, Object> systemProperties = context.getEnvironment().getSystemProperties();

        MutablePropertySources propertySources = context.getEnvironment().getPropertySources();
    }
}
