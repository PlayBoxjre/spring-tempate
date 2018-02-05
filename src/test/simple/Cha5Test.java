package simple;

import com.playboxjre.spring.learn.cha5.Person;
import com.playboxjre.spring.learn.cha5.PersonValidator;
import com.playboxjre.spring.learn.cha5.SpringValidatorLearn;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DirectFieldBindingResult;

import java.util.Map;

/**
 * simple
 * Administrator
 * 2018\1\26 0026 15:02
 * EMAIL : playboxjre@gmail.com
 */
public class Cha5Test {
    Logger log = LoggerFactory.getLogger(Cha5Test.class);

    @Test
    public void testPersonValidator(){
        AnnotationConfigApplicationContext ctx = new
                AnnotationConfigApplicationContext(
                SpringValidatorLearn.class
        );

        Person bean = ctx.getBean(Person.class);
        PersonValidator bean1 = ctx.getBean(PersonValidator.class);
        BindingResult bindingResult = new DirectFieldBindingResult(bean,"person");
        bean1.validate(bean,bindingResult);
        if(bindingResult.hasErrors()){
            String[] strings = bindingResult.resolveMessageCodes("name.empty");
            for (String s:strings){
                log.info(s);
            }
            Map<String, Object> model = bindingResult.getModel();
            model.forEach((k,v)->{

                log.error("k[{}] \n\tV[{}]",k,v);
            });
        }
        log.info(bean.toString());

        BeanWrapper beanWrapper = new BeanWrapperImpl(bean);
        Class<?> wrappedClass = beanWrapper.getWrappedClass();
        beanWrapper.setPropertyValue(new PropertyValue("name","haha"));
        log.info(bean.getName());
    }
}
