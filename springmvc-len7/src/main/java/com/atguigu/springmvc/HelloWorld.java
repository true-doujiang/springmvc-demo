package com.atguigu.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {

	/**
	 * 这里是可以注入进来的，因为spring的IOC不能依赖springMVC的IOC，反之是可以的
	 */
	@Autowired
	private UserService userService;
	
	public HelloWorld() {
		System.out.println("HelloWorld Constructor...");
	}
	
	
	@RequestMapping("/helloworld")
	public String hello(){
		System.out.println("success");
		System.out.println(userService);
		return "success";
	}
	
	//DispatcherServlet
	
	//HandlerMapping(接口)
	//RequestMappingHandlerMapping
	//BeanNameUrlHandlerMapping
	//DefaultAnnotationHandlerMapping  已废弃
	//SimpleUrlHandlerMapping    加<mvc:default-servlet-handler />注解才会装配  
	
	//HandlerMethod
	//HandlerExecutionChain
	
	//HandlerAdapter(接口)
	//HttpRequestHandlerAdapter
	//SimpleControllerHandlerAdapter
	//AnnotationMethodHandlerAdapter
	//RequestMappingHandlerAdapter
	
	
	//HandlerInterceptor(接口)
	
	//HandlerExceptionResolver(接口)
	//AnnotationMethodHandlerExceptionResolver  已废弃
	//ExceptionHandlerExceptionResolver
	//DefaultHandlerExceptionResolver
	//ResponseStatusExceptionResolver
	//SimpleMappingExceptionResolver
	
	//ViewResolver(接口)
	//InternalResourceViewResolver
	//BeanNameViewResolver
	
	//ModelAndView
	
	//View(接口)
	//InternalResourceView
	
	//Errors
	//BindingResult
	
	//XmlWebApplicationContext
	//PlatformTransactionManager
}
