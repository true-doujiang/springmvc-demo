package com.atguigu.springmvc.exception;

import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {


    //HandlerExceptionResolver
    //ExceptionHandlerExceptionResolver
    //ResponseStatusExceptionResolver
    //DefaultHandlerExceptionResolver
    //SimpleMappingExceptionResolver

    //抛出异常的方法
    @RequestMapping("/testExceptionHandlerExceptionResolver")
    public String testExceptionHandlerExceptionResolver(@RequestParam("i") int i){
        System.out.println("result: " + (10 / i));
        return "success";
    }

    /**
     * 1. 在 @ExceptionHandler 注解的方法的入参中可以加入 Exception 类型的参数, 该参数即对应发生的异常对象
     * 2. @ExceptionHandler 方法的入参中不能传入 Map. 若希望把异常信息传导页面上, 需要使用 ModelAndView 作为返回值
     * 3. @ExceptionHandler 方法标记的异常有优先级的问题.
     * 4. @ControllerAdvice(标记全局异常处理类) 如果在当前 Handler中找不到 @ExceptionHandler 方法来处理当前方法出现的异常,
     *    则将去 @ControllerAdvice 标记的类中查找 @ExceptionHandler 标记的方法来处理异常.
     */
    //发生ArithmeticException异常被我映射到
	@ExceptionHandler({ArithmeticException.class})
	public ModelAndView handleArithmeticException1(Exception ex){
		System.out.println("出异常了: " + ex);
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception", ex);
		return mv;
	}

    //发生RuntimeException异常被我映射到
	@ExceptionHandler({RuntimeException.class})
	public ModelAndView handleArithmeticException2(Exception ex){
		System.out.println("[出异常了]: " + ex);
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception", ex);
		return mv;
	}



    //***********************************************************************//
    /** 第三个异常处理类DefaultHandlerExceptionResolver 作用:对一些特殊的异常进行处理，
     *  比如 NoSuchRequestHandlingMethodException、HttpReques
     */
    //这个方法只接受post请求，你发个get请求过来我就会抛NoSuchRequestHandlingMethodException异常
	@RequestMapping(value="/testDefaultHandlerExceptionResolver",method=RequestMethod.POST)
	public String testDefaultHandlerExceptionResolver(){
		System.out.println("testDefaultHandlerExceptionResolver...");
		return "success";
	}


    //***************************************************************//
    //第二个异常处理类ResponseStatusExceptionResolver的作用解析@ResponseStatus注解
    //@ResponseStatus(reason="测试",value=HttpStatus.NOT_FOUND)
    @RequestMapping("/testResponseStatusExceptionResolver")
    public String testResponseStatusExceptionResolver(@RequestParam("i") int i){
        if(i == 13){
            //抛出自定义的异常测试@ResponseStatus 注解
            throw new UserNameNotMatchPasswordException();
        }
        System.out.println("testResponseStatusExceptionResolver...");
        return "success";
    }


    //***********************************************************************//
    /**SimpleMappingExceptionResolver
     * 如果希望对所有异常进行统一处理，可以使用 SimpleMappingExceptionResolver，它将异常类名映射为
     * 视图名，即发生异常时使用对应的视图报告异常
     */
    @RequestMapping("/testSimpleMappingExceptionResolver")
    public String testSimpleMappingExceptionResolver(@RequestParam("i") int i){
        String [] vals = new String[10];
        System.out.println(vals[i]);
        return "success";
    }



}
