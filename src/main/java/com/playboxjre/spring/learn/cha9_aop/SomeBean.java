package com.playboxjre.spring.learn.cha9_aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * com.playboxjre.spring.learn.cha9_aop
 * Administrator
 * 2018\1\26 0026 17:02
 * EMAIL : playboxjre@gmail.com
 */
//@Component
//@Scope("prototype")
public class SomeBean {
    Logger log = LoggerFactory.getLogger(SomeBean.class);

    public void oneDay(){
        log.info("wake up ");
        wakeUp();
        eatLouth();
        play();
        eatMiddle();
        play();
        eatDinner();
        tvShow();
        sleep();
    }

    public  void wakeUp() {
        log.info("起床");
    }

    protected void eatLouth() {
        log.info("吃早餐");
    }

    private void play() {
        log.info("玩游戏");
    }

    void eatMiddle() {
        log.info("吃午餐");
    }

    public void eatDinner() {
        log.info("吃晚餐");
    }

    public void tvShow() {
        log.info("看电视");
    }

    public void sleep() {
        log.info("睡觉");
    }


    /**
     *
     * @param book
     * @return
     */
    public String read(String book){
        log.info("读 {}",book);
        return String.format("%s is good ",book);
    }



    public void study(String lesson) throws InAbsenceLessonException {
        if(lesson == null){
            throw new InAbsenceLessonException("不能旷课");
        }else {
            log.info("学习课程：{}",lesson);
        }
    }
}
