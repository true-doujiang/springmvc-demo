package com.atguigu.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping(value = "/springmvc")
@Controller
public class TestRedirectForward {


    @RequestMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("testRedirect");
        return "redirect:/index.jsp";  //forward:/index.jsp   forward:/success
    }


    @RequestMapping("/aaa")
    public String aaa(){
        System.out.println("aaa");
        return "redirect:/springmvc/bbb";  //forward:/springmvc/bbb
    }

    @RequestMapping("/bbb")
    public String bbb(){
        System.out.println("bbb");
        return "redirect:/springmvc/ccc";
    }

    @RequestMapping("/ccc")
    public String ccc(){
        System.out.println("ccc");
        return "forward:/index.jsp";
    }

}
