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
  
	
	<!-- 以下测试REST风格     分别发出GET POST DELETE PUT 请求
	如何发送 PUT 请求和 DELETE 请求呢 ? 
	 * 1. 需要配置 HiddenHttpMethodFilter 
	 * 2. 需要发送 POST 请求
	 * 3. 需要在发送 POST 请求时携带一个 name="_method" 的隐藏域, 值为 DELETE 或 PUT
	 -->
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT"/>
		<input type="submit" value="TestRest PUT"/>
	</form>
	<br><br>
	
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
		<input type="submit" value="TestRest DELETE"/>
	</form>
	<br><br>
	
	<form action="springmvc/testRest" method="post">
		<input type="submit" value="TestRest POST"/>
	</form>
	<br><br>
	
	<a href="springmvc/testRest/1">Test Rest Get</a>
	<br><br>

	<a href="springmvc/testPathVariable/1">Test PathVariable</a>
	<br><br>

	
  </body>
</html>
