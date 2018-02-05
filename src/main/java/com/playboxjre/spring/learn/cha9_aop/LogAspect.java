package com.playboxjre.spring.learn.cha9_aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * com.playboxjre.spring.learn.cha9_aop
 * Administrator
 * 2018\1\26 0026 16:58
 * EMAIL : playboxjre@gmail.com
 */

@Aspect
@Component
public class LogAspect {
    Logger log = LoggerFactory.getLogger(LogAspect.class);
    @Pointcut("execution(* com.playboxjre.spring.learn.cha9_aop.SomeBean.*(..))")
    public void allMethod(){}

    @Pointcut("within(com.playboxjre.spring.learn.cha9_aop..*)")
    public void aop(){}

    @Before("allMethod()")
    public void before(){
        log.info("-- method before ...");
    }

    @After("aop()")
    public void after(){
        log.info("== method After ...");
    }


    @AfterReturning(pointcut = "allMethod()",returning ="retValue" )
    public void afterReturning(String retValue){
        log.info("after returning - {}",retValue);
    }
  /*  @DeclareParents(value = "com.playboxjre.spring.learn.cha9_aop.AdvanceInterface",defaultImpl = DefaultAdvanceImpl.class)
    public AdvanceInterface advanceInterface;

    public void advance(){

    }*/



  @AfterThrowing(
          pointcut = "allMethod()",
          throwing = "ex"
  )
  public void afterThrowing(Exception ex){
      log.info("{}",ex);
  }

  @Around("execution(public void com.playboxjre.spring.learn.cha9_aop.DefaultAdvanceImpl.*(..))")
    public Object customLogPrint(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("round ... start");
        Object proceed = joinPoint.proceed();
        log.info("round ... end ");
        return proceed;
    }

}
