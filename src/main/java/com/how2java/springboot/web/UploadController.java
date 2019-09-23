package com.how2java.springboot.web;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    @RequestMapping("/uploadPage")
    public String uploadPage() {
        return "uploadPage";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest req, @RequestParam("file") MultipartFile file,Model m) {
        try {
            String fileName = System.currentTimeMillis()+file.getOriginalFilename();
            System.out.println("req.getSession().getServletContext().getRealPath(\"\"):"+req.getSession().getServletContext().getRealPath(""));
            System.out.println("req.getServletContext().getRealPath(\"\"):"+req.getServletContext().getRealPath(""));
            System.out.println("file.getOriginalFilename():"+file.getOriginalFilename());

       //  第一种写法
            //           String destFileName=req.getServletContext().getRealPath("")+"uploaded"+File.separator+fileName;
         //   File destFile = new File(destFileName);
            //  第二种写法
            String filePath=req.getServletContext().getRealPath("uploaded");
            File destFile = new File(filePath,fileName);

            destFile.getParentFile().mkdirs();
            file.transferTo(destFile);

            m.addAttribute("fileName",fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }

        return "showImg";
    }

}