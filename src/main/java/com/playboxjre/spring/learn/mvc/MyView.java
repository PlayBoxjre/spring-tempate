package com.playboxjre.spring.learn.mvc;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Map;

/**
 * com.playboxjre.spring.learn.mvc
 * Administrator
 * 2018\2\10 0010 17:07
 * EMAIL : playboxjre@gmail.com
 */
public class MyView extends AbstractView {
    Logger log = LoggerFactory.getLogger(MyView.class);

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter writer = response.getWriter();
        JSONObject jsonObject = new JSONObject(model);
        jsonObject.put("createtime", Calendar.getInstance().toString());
        String string = jsonObject.toString();
        writer.print(string);
        writer.flush();
    }
}
