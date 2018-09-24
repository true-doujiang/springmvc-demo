package com.atguigu.springmvc.handlers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 测试 @PathVariable
 */
@RequestMapping(value = "/springmvc")
@Controller
public class TestPathVariable {

    private static final String SUCCESS = "success";

    /**
     带占位符的 URL 是 Spring3.0 新增的功能，
     该功能在 SpringMVC 向 REST 目标挺进发展过程中具有里程碑的意义

     传入字符串 报http 400
     @PathVariable 可以来映射 URL 中的占位符到目标方法的参数中.
     */
    @RequestMapping(value = "/testPathVariable/{id}")
    public String testPathVariable(@PathVariable(value = "id") Integer id) {
        System.out.println("testPathVariable: " + id);
        return SUCCESS;
    }

    /**
     * Rest 风格的 URL.
     * 以 CRUD 为例:
     * 新增: /order   POST
     * 修改: /order/1 PUT 		    update?id=1
     * 获取: /order/1 GET 		    get?id=1
     * 删除: /order/1 DELETE 		delete?id=1
     *
     * 如何发送 PUT 请求和 DELETE 请求呢 ?
     * 1. 需要配置 HiddenHttpMethodFilter
     * 2. 需要发送 POST 请求
     * 3. 需要在发送 POST 请求时携带一个 name="_method" 的隐藏域, 值为 DELETE 或 PUT
     *
     * 在 SpringMVC 的目标方法中如何得到 id 呢? 使用 @PathVariable 注解
     */
    //GET
    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
    public String testRestGet(@PathVariable Integer id) {
        System.out.println(" testRest GET id = " + id);
        return SUCCESS;
    }

    //POST
    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.POST)
    public String testRestPost(@PathVariable Integer id) {
        System.out.println(" testRest POST id = " + id);
        return SUCCESS;
    }

    //PUT    在myeclipse是可以返回jsp页面的  idea里就是不行
    //所以这里只能先用@ResponseBody   返回字符串了
    @ResponseBody
    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
    public String testRestPut(@PathVariable Integer id) {
        System.out.println(" testRest PUT id = " + id);
        return SUCCESS;
    }

    //DELETE
    @ResponseBody
    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable Integer id) {
        System.out.println(" testRest DELETE id = " + id);
        return SUCCESS;
    }



}
