package com.atguigu.springmvc.handlers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;


@RequestMapping(value = "/springmvc")
@Controller
public class TestServletApi {


    private static final String SUCCESS = "success";


    //================== Serlvet 原生的 API========================

    /**
     * 可以使用 Serlvet 原生的 API 作为目标方法的参数
     * 跟踪源码可以看到:AnnotationMethodHandlerAdapterSServlet...
     * <p>
     * 具体支持以下类型:
     * HttpServletRequest  HttpServletResponse  HttpSession
     * <p>
     * java.security.Principal
     * Locale
     * InputStream
     * OutputStream
     * Reader
     * Writer
     */
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request,
                               HttpServletResponse response,
                               Writer out) throws IOException {

        System.out.println("testServletAPI, " + request + ", " + response);

        System.out.println(request.getCharacterEncoding());
        System.out.println(request.getMethod());

        Cookie cookie = new Cookie("mycookie", "springMVC");
        Cookie cookie1 = new Cookie("mycookie1", "springMVC1");
        response.addCookie(cookie);
        response.addCookie(cookie1);

        out.write("hello springmvc");

        //用了getOutputStream 则该方法的入参就不能有Writer了
        //OutputStream outputStream = response.getOutputStream();
        //outputStream.write("中国".getBytes("UTF-8"));
//		return SUCCESS;
    }


}
