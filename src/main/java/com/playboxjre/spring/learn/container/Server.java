package com.playboxjre.spring.learn.container;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Server {
    Logger logger = LoggerFactory.getLogger(Server.class);
    private Function01 function01;
    private Function02 function02;

    public Function01 getFunction01() {
        return function01;
    }

    public void setFunction01(Function01 function01) {
        this.function01 = function01;
    }

    public Function02 getFunction02() {
        return function02;
    }

    public void setFunction02(Function02 function02) {
        this.function02 = function02;
    }

    public void useFunction01(){
        logger.info(function01.toString());
    }
    public void useFunction02(){
        logger.info(function02.toString());
    }

    @Override
    public String toString() {
        return "Server{" +
                "function01=" + function01 +
                ", function02=" + function02 +
                '}';
    }
}
