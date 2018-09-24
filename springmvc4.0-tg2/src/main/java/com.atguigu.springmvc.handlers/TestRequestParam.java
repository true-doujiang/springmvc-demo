package com.atguigu.springmvc.handlers;


import com.atguigu.springmvc.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * 测试 @RequestParam  @RequestHeader  @CookieValue
 */
@RequestMapping(value = "/springmvc")
@Controller
public class TestRequestParam {

    private static final String SUCCESS = "success";


    //======以下====只记住 @RequestParam(映射请求参数)===========================//
    /**1
     * @RequestParam 来映射请求参数.
     * value 值即请求参数的参数名 (key)
     * required 该参数是否必须.   默认为 true   false:不是必须的
     * defaultValue 请求参数的默认值
     */
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(
            @RequestParam(value = "username", required = false) String name,
            @RequestParam(value = "age", required = false, defaultValue = "10") int age) {
        System.out.println("testRequestParam  name = " + name + "   age = " + age);
        return SUCCESS;
    }

    /**2
     * 了解: 映射请求头信息 用法同 @RequestParam
     */
    @RequestMapping(value = "/testRequestHeader")
    public String testRequestHeader(
            @RequestHeader(value = "Accept-Language") String al,
            @RequestHeader(value = "Cookie") String cookie,
            @RequestHeader(value = "token", required = false) String token) {
        System.out.println("testRequestHeader Accept-Language = " + al);
        System.out.println("testRequestHeader Cookie = " + cookie); //testRequestHeader Cookie = JSESSIONID=122hkjkhkj; JSESSIONID=521F049B8866616841EA587B6FA72A7B
        System.out.println("testRequestHeader token = " + token);
        return SUCCESS;
    }

    /**3
     * 了解:
     *
     * @CookieValue: 映射一个 Cookie 值. 属性同 @RequestParam
     */
    @RequestMapping(value = "/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID", required = false) String jsessionId) {
        System.out.println("testCookieValue JSESSIONID = " + jsessionId);
        return SUCCESS;
    }



    /**
     * Spring MVC 会按请求参数名和 POJO 属性名进行自动匹配， 自动为该对象填充属性值。
     * 支持级联属性。
     * 如：dept.deptId、dept.address.tel 等
     * <p>
     * 这个为什么的接收POST请求？？？？？？？？
     * 原因   PS:@RequestMapping不加method属性默认GET和POST都可以映射
     */
    @RequestMapping("/testPojo")
    public String testPojo(User user) {
        System.out.println("testPojo: " + user);
        return SUCCESS;
    }


}
