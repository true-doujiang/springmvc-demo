<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>index</title>
  </head>
  <body>

  <a href="springmvc/testRequestMapping">Test RequestMapping GET请求</a>
  <br>

  <form action="springmvc/testRequestMapping">
      <input type="submit" value="Test RequestMapping  POST请求">
  </form>
  <br>

  <br>
  -----------------------------------------------------------------------------------------------------
  <br>

  <a href="springmvc/testMethod">Test Method GET请求</a>
  <br>

  <form action="springmvc/testMethod" method="POST">
      <input type="submit" value="Test Method POST请求"/>
  </form>
  <br>

  <br>
  -----------------------------------------------------------------------------------------------------
  <br>

  <a href="springmvc/testParamsAndHeaders?username=atguigu&age=10">Test ParamsAndHeaders</a>
  <br><br>

  <br>
  -----------------------------------------------------------------------------------------------------
  <br>


  <a href="springmvc/testAntPath/mnxyz/abc">Test AntPath</a>
  <br><br>

  <br>
  -----------------------------------------------------------------------------------------------------
  <br>







  <a href="springmvc/testRedirect">Test Redirect</a>
  <br>
  -----------------------------------------------------------------------------------------------------
  <br>


	<a href="springmvc/testView">Test View</a>
	<br><br>

  <br>
  -----------------------------------------------------------------------------------------------------
  <br>

	<a href="springmvc/testViewAndViewResolver">Test ViewAndViewResolver</a>
	<br><br>

  <br>
  -----------------------------------------------------------------------------------------------------
  <br>

	<!--  
		模拟修改操作
		1. 原始数据为: 1, Tom, 123456,tom@atguigu.com,12
		2. 密码不能被修改.
		3. 表单回显, 模拟操作直接在表单填写对应的属性值
	-->
	<form action="springmvc/testModelAttribute" method="Post">
				 <input type="hidden" name="id" value="1"/>
				 <!-- 密码是敏感字段不可以放在修改表单里 -->
		username:<input type="text" name="username" value="Tom"/> <br>
		email: 	 <input type="text" name="email" value="tom@atguigu.com"/> <br>
		age: 	 <input type="text" name="age" value="12"/> <br>
				 <input type="submit" value="Submit"/>
	</form>
	<br><br>

  <br>
  -----------------------------------------------------------------------------------------------------
  <br>






	
	
	

	
  </body>
</html>
