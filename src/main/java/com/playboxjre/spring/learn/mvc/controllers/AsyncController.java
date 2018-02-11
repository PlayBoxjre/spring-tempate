package com.playboxjre.spring.learn.mvc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/**
 * com.playboxjre.spring.learn.mvc.controllers
 * Administrator
 * 2018\2\8 0008 19:43
 * EMAIL : playboxjre@gmail.com
 */
@Controller
@RequestMapping("/async")
public class AsyncController {
    Logger log = LoggerFactory.getLogger(AsyncController.class);

    @Autowired
    @Qualifier("messageQueue")
    BlockingQueue messageQueue;


    @GetMapping("add")
    public Callable<String> calcu(@RequestParam Integer firstValue,@RequestParam Integer secordValue,Model model){
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                final int sum = firstValue+secordValue ;
                model.addAttribute("sum",sum);
                Thread.sleep(10000);
                return "async";
            }
        };
        return callable;
    }

    @GetMapping("sub")
    @ResponseBody //返回值作为 响应体
    public Callable<String> calcuSub(@RequestParam Integer firstValue,@RequestParam Integer secordValue,Model model){
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                final int sum = firstValue+secordValue ;
                model.addAttribute("sub",sum);
                return "async";
            }
        };
        return callable;
    }


    @GetMapping("message")
    public @ResponseBody DeferredResult<String> calcuMul() throws InterruptedException {
        DeferredResult<String> stringDeferredResult  = new DeferredResult<>();
        messageQueue.put(stringDeferredResult);
        return stringDeferredResult;
    }


    @GetMapping("/events")
    public ResponseBodyEmitter emitterEvent() throws InterruptedException {
        ResponseBodyEmitter emitter = new ResponseBodyEmitter();
        messageQueue.put(emitter);
        return emitter;
    }



    @RequestMapping("/download/{source}")
    public StreamingResponseBody streamingResponseBody(
            @PathVariable(required = false) String source){
        return new StreamingResponseBody() {
            @Override
            public void writeTo(OutputStream outputStream) throws IOException {
                if (source == null || "defalut".equals(source)){
                    outputStream.write("no source found".getBytes());
                    outputStream.flush();
                }else {
                    outputStream.write(("source : "+ source).getBytes());
                    outputStream.flush();
                }
            }
        };
    }


    @ExceptionHandler(Exception.class)
    public String handler(Exception e,Model model){
        model.addAttribute("error",e.getClass().toGenericString());
        model.addAttribute("errorMsg",e.getMessage());
        return "error";
    }



}

