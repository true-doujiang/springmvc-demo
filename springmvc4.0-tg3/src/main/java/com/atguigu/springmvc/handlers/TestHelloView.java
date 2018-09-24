package com.atguigu.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/springmvc")
@Controller
public class TestHelloView {

    private static final String SUCCESS = "success";

    @RequestMapping("/helloView")
    public String testView(){
        System.out.println("testView");
        return "helloView";	//helloView视图的名字  会从spring容器中找helloView视图
    }

}
