package com.atguigu.springmvc.crud.handlers;


import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 测试自定义类型转换器
 */
@Controller
public class EmployeeConvertHandler {



    @Autowired
    private EmployeeDao employeeDao;

    /**
     * 测试自定义的类型转换器       74页
     */
    @RequestMapping(value="/testConversionServiceConverer")
    public String testConverter(@RequestParam("employee") Employee employee){
        System.out.println("save: " + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }




    //ModelAttributeMethodProcessor  打断点的类
    /**BindingResult extends Errors  都是借口
     * ServletWebRequest
     * 34. 尚硅谷_佟刚_SpringMVC_数据绑定流程分析    好好看看
     *
     * ConversionService是 Spring 类型转换体系的核心接口
     */
    //org.springframework.core.convert.ConversionService



}
