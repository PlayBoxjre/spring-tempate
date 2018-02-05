package com.playboxjre.spring.learn.cha9_aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * com.playboxjre.spring.learn.cha9_aop
 * Administrator
 * 2018\1\26 0026 17:55
 * EMAIL : playboxjre@gmail.com
 */
public class LogForXml {
    Logger log = LoggerFactory.getLogger(LogForXml.class);

    public void before(){
        log.info("before to log");
    }


    public void after(){
        log.info("after to log");
    }

    public void around(){
        log.info("around to log");
    }

    /**
     * aop 对执行带返回值的方法时，
     * （接入点执行 这里是SomeBean方法的String read(String book)方法
     * 将 read方法的返回值传入 afterReturning方法增强中
     * xml使用 returning="retValue"属性定义结果参数名，必须和切面方法参数相同
     * 所以
     *
     * @param retValue
     */
    public void acceptResultToLog(String retValue){
        log.info("accept Result To Log   {}",retValue);
    }


    public void printException(Exception ex){
        log.info("这是一个异常：类型:{} ,信息{}",ex.getClass().getName(),ex.getMessage());
    }



    public Object customLogPrint(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("round ... start");
        Object proceed = joinPoint.proceed();
        log.info("round ... end ");
        return proceed;
    }

}
