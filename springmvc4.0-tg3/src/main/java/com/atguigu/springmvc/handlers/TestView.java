package com.atguigu.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/springmvc")
@Controller
public class TestView {

    private static final String SUCCESS = "success";


    /**视图解析器工作流程
     success.jsp
     若项目中使用了 JSTL，则 SpringMVC 会自动把视图由InternalResourceView 转为 JstlView
     若使用 JSTL 的 fmt 标签则需要在 SpringMVC 的配置文件中配置国际化资源文件
     加入jstl.jar、standard.jar后view的实现类就变成JstlView了
     */
    @RequestMapping("/testViewAndViewResolver")
    public String testViewAndViewResolver(){
        System.out.println("testViewAndViewResolver");
        //View
        //ViewResolver
        return SUCCESS;
    }

    /**  视图和视图解析器
     •请求处理方法执行完成后，最终返回一个 ModelAndView对象。 对于那些返回 String，View 或 ModeMap 等类型的
     处理方法，Spring MVC 也会在内部将它们装配成一个ModelAndView 对象，它包含了逻辑名和模型对象的视图
     •Spring MVC 借助视图解析器（ViewResolver）得到最 终的视图对象（View），最终的视图可以是 JSP ，也可能是
     Excel、JFreeChart 等各种表现形式的视图
     •对于最终究竟采取何种视图对象对模型数据进行渲染， 处理器并不关心，处理器工作重点聚焦在生产模型数据的工
     作上，从而实现 MVC 的充分解耦
     */

    /**视图
     •视图的作用是渲染模型数据，将模型里的数据以某种形式呈现给客 户。
     •为了实现视图模型和具体实现技术的解耦，Spring 在org.springframework.web.servlet 包中定义了一个高度抽象的 View接口
     •视图对象由视图解析器负责实例化。由于视图是无状态的，所以他们不会有线程安全的问题。
     */

    /**视图解析器
     •SpringMVC为逻辑视图名的解析提供了不同的策略，可以在 Spring WEB 上下文中配置一种或多种解析策略，
     并指定他们之间的先后顺序。每一种映射策略对应一个具体的视图解析器实现类。
     •视图解析器的作用比较单一：将逻辑视图解析为一个具体 的视图对象。
     •所有的视图解析器都必须实现 ViewResolver 接口
     */

}
