package com.playboxjre.spring.learn.cha5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * com.playboxjre.spring.learn.cha5
 * Administrator
 * 2018\1\26 0026 14:48
 * EMAIL : playboxjre@gmail.com
 */
public class PersonValidator implements Validator {
    Logger log = LoggerFactory.getLogger(PersonValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"name","name.empty","null0-0");
        Person person = (Person) target;
        if(person.getAge() < 0){
            errors.rejectValue("age","negativeValue");
        }else if(person.getAge() > 110){
            errors.rejectValue("age","too.darn.old  ");
        }
    }
}
