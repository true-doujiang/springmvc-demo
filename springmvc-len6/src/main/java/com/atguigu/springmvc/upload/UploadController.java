package com.atguigu.springmvc.upload;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class UploadController {



    //********************文件上传功能***************************//
    /**spring.xml 配置MultipartResolver(接口)
     * MultipartResolver接口：有2个实现类可用,但是需要struts2上传jar包的支持.
     */
    @RequestMapping("/testFileUpload")
    public String testFileUpload(@RequestParam("desc") String desc,
                                 @RequestParam("file") MultipartFile file,
                                 HttpSession session) throws IOException {

        System.out.println("desc: " + desc);
        System.out.println("文件名:" + file.getOriginalFilename());
        System.out.println("文件大小:" + file.getSize());
        System.out.println("InputStream:" + file.getInputStream());

        ServletContext servletContext = session.getServletContext();
        String path = servletContext.getRealPath("/WEB-INF/upload/"+file.getOriginalFilename());
        path = "E:\\upload\\" + file.getOriginalFilename();
        byte[] buffer = new byte[(int) file.getSize()];
        file.getInputStream().read(buffer);
        OutputStream out = new FileOutputStream(new File(path));
        out.write(buffer);
        out.close();

        System.out.println("over");
        return "success";
    }


}
