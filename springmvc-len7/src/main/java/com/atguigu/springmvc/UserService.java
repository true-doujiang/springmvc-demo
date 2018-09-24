package com.atguigu.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	/**
	 * 这里是注入不进来的，因为spring的IOC不能依赖springMVC的IOC，反之是可以的
	 */
	//@Autowired
	//private HelloWorld helloWorld;
	
	public UserService() {
		System.out.println("UserService Constructor...");
	}
	
}
