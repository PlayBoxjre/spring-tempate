package com.playboxjre.spring.learn.mvc.controllers.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * com.playboxjre.spring.learn.mvc.controllers.advice
 * Administrator
 * 2018\2\6 0006 20:14
 * EMAIL : playboxjre@gmail.com
 */
@ControllerAdvice(annotations = Controller.class)
public class CommonControllerAdvicer extends ResponseEntityExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<String> handlerException(Exception e){
        HttpHeaders httpHeaders = new HttpHeaders();
        return  new ResponseEntity<>(e.getMessage(),httpHeaders, HttpStatus.BAD_REQUEST);
    }

}
