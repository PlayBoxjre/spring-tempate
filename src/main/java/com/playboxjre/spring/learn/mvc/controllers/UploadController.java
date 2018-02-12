package com.playboxjre.spring.learn.mvc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;
import java.util.Objects;

/**
 * com.playboxjre.spring.learn.mvc.controllers
 * Administrator
 * 2018\2\12 0012 16:59
 * EMAIL : playboxjre@gmail.com
 *
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
    Logger log = LoggerFactory.getLogger(UploadController.class);

    @Value("${save.directory}")
    private String saveDirectory;

    @GetMapping()
    public String get(){
        return "upload";
    }

    @PostMapping
    public String post(HttpSession session,@RequestParam("name") String name,
                       @RequestParam("file") MultipartFile file, RedirectAttributes model) throws IOException {
        if (Objects.isNull(name))
            name = "new_file_"+new Date().toInstant().toString();
        if (Objects.isNull(file)) {
            model.addAttribute("fileName","上传失败，请检查");
            return "redirect:/upload/failed";
        }
        String realPath = session.getServletContext().getRealPath("/upload");
        String originalFilename = file.getOriginalFilename();
        String saveFile = String.format("%s\\%s", realPath,originalFilename);

        File file1 = new File(saveFile);
        if (!file1.exists()){
            file1.createNewFile();
            file1.setWritable(true);
        }

        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        FileChannel channel = fileOutputStream.getChannel();

        byte[] bytes = file.getBytes();
        int write = channel.write(ByteBuffer.wrap(bytes));
        log.info("wirte size {}",write);

        model.addFlashAttribute("fileName",  originalFilename);
        return "redirect:/upload/successful";
    }

    @GetMapping("/successful")
    public String success(){
        return "successful";
    }

    @GetMapping("failed")
    public String failed(){
        return "failed";
    }
}
