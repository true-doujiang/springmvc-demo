package com.atguigu.springmvc.handlers;


import com.atguigu.springmvc.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

//把数据放入session域
@SessionAttributes(value={"user"},types={String.class}) //testSessionAttributes()方法用到的
@RequestMapping(value = "/springmvc")
@Controller
public class TestSessionAttribute {


    private static final String SUCCESS = "model";


    //========= 处理模型数据  可以配合@SessionAttributes注解使用===============

    /**
     * @SessionAttributes 除了可以通过value属性名指定需要放到会话中的数据(实际上使用的是 value 属性值),
     * 还可以通过types属性指定哪些类型的数据需要放到会话中(实际上使用的是 types 属性值)
     * <p>
     * 注意: @SessionAttributes 注解只能放在类的上面. 而不能修饰放方法.
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String, Object> map) {

        User user = new User("Tom", "123456", "tom@atguigu.com", 15);
        map.put("user", user);
        map.put("school", "atguigu");

        return SUCCESS;
    }


}
