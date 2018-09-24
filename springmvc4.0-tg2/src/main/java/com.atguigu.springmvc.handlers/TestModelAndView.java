package com.atguigu.springmvc.handlers;


import com.atguigu.springmvc.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@RequestMapping(value = "/springmvc")
@Controller
public class TestModelAndView {


    private static final String SUCCESS = "model";

    /**
     * 这俩个方法都是将模型数据放到了request域
     *
     * 请看TestSessionAttribute
     */

    /**
     * 目标方法的返回值可以是 ModelAndView 类型。
     * 其中可以包含 视图 和 模型信息
     * SpringMVC 会把 ModelAndView 的 model中数据放入到 request 域对象中. (需要导入源码debug)
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {

        String viewName = SUCCESS;//要返回的视图路径
        ModelAndView modelAndView = new ModelAndView(viewName);
        //modelAndView.setViewName(SUCCESS);   //设置视图

        //添加模型数据到 ModelAndView 中
        modelAndView.addObject("time", new Date());
        return modelAndView;
    }



    /**
     * 重要
     * 目标方法可以添加 Map 类型(实际上也可以是 Model[springMVC的] 类型或 ModelMap[springMVC的] 类型)的参数.
     * 实际上又把map放到 ModelAndView中了,ModelAndView的 model中数据放入到 request 域对象中.
     * <p>
     * Spring MVC 在调用方法前会创建一个隐含的模型对象作为模型数据的存储容器。
     * 如果方法的入参为 Map 或 Model 类型，Spring MVC 会将隐含模型的引用传递给这些入参。
     * 在方法体内，开发者可以通过这个入参对象访问到模型中的所有数据，也可以向模型中添加新的属性数据
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {

        System.out.println(map.getClass().getName());
        //org.springframework.validation.support.BindingAwareModelMap

        map.put("names", Arrays.asList("Tom", "Jerry", "Mike"));
        return SUCCESS;
    }



}
