package com.atguigu.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



/**
 * 自定义一个异常类让后用@ResponseStatus 修饰，当抛出这个异常时页面就会显示注解的属性
 */
@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="用户名和密码不匹配!")
public class UserNameNotMatchPasswordException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	
}
