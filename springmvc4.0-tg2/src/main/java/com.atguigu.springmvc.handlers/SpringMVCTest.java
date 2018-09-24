package com.atguigu.springmvc.handlers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {

    private static final String SUCCESS = "success";


    /**
     * 1
     * 1.  @RequestMapping 除了修饰方法, 还可来修饰类
     * 1). 类定义处: 提供初步的请求映射信息。相对于 WEB 应用的根目录
     * 2). 方法处: 提供进一步的细分映射信息。 相对于类定义处的 URL。
     * 若类定义处未标注 @RequestMapping，则方法处标记的 URL相对于 WEB 应用的根目录
     * <p>
     * PS:@RequestMapping不加method属性默认GET和POST都可以映射
     */
    @RequestMapping("/testRequestMapping")
    public String testRequestMapping() {
        System.out.println("testRequestMapping");
        return SUCCESS;
    }

    /**
     * 2
     * 常用: 使用 @RequestMapping 的method 属性来指定请求方式
     */
    @RequestMapping(value = "/testMethod", method = RequestMethod.POST)
    public String testMethod() {
        System.out.println("testMethod");
        return SUCCESS;
    }

    /**3
     * 了解:
     * 可以使用@RequestMapping的params 和 headers 属性来更加精确的映射请求.
     *
     * 必须有username参数
     */
    @RequestMapping(value = "/testParamsAndHeaders",
                    params = {"username", "age != 10"},
                    headers = {"Accept-Language=zh-CN,zh;q=0.8"}
                    )
     public String testParamsAndHeaders() {
         System.out.println("testParamsAndHeaders");
         return SUCCESS;
     }

    /**4
      了解
      @RequestMapping 的ant风格路径
      Ant 风格资源地址支持 3 种匹配符： ? 匹配文件名中的一个字符   * 匹配文件名中的任意字符  ** 匹配多层路径
     */
    @RequestMapping(value = "testAntPath/*/abc")
    public String testAntPath() {
        System.out.println("testAntPath");
        return SUCCESS;
    }




}
