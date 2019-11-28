package com.zql.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

@Controller
public class UploadController {

    @PostMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file, HashMap<String,Object> map) {
        if (file.isEmpty()) {
            map.put("msg","请选择文件");
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("C:\\Users\\没有牙\\Desktop", file.getOriginalFilename());
            Files.write(path,bytes);
            map.put("msg","上传成功");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

}
