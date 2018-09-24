package com.atguigu.springmvc.views;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

/**
 * 自定义一个视图
 */
@Component//("CustomVeiwResolver")  //交给IOC容器
public class HelloView implements View{  //继承AbstractExcelView可以渲染excel视图,但是要导入poi的jar包

	@Override
	public String getContentType() {
		return "text/html"; //返回内容类型
	}

	@Override //渲染视图
	public void render(Map<String, ?> model,
                       HttpServletRequest request,
                       HttpServletResponse response) throws Exception {
		
		System.out.println("自定义视图解析器!");
		response.getWriter().print("hello view, time: " + new Date());
	}

}
