package com.atguigu.springmvc.handlers;

import com.atguigu.springmvc.entity.User;
import com.atguigu.springmvc.views.ExcelView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/springmvc")
@Controller
public class TestExcelView {


    @RequestMapping(value = "/excelView")
    public ModelAndView viewExcel() {
        Map<String, Object> model = new HashMap<>();
        model.put("userList", getStudents());
        return new ModelAndView(new ExcelView(), model);
    }

    private List<User> getStudents() {
        List<User> userList = new ArrayList<>();
        User user = new User("1", "Tome", "Tom@qq.com", "123456");
        userList.add(user);
        return userList;
    }
}
