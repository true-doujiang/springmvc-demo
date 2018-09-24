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


  <a href="springmvc/testPathVariable/1">Test PathVariable</a>
  <br><br>

  <br>
-----------------------REST---------------------------------------------------
  <br>

  <a href="springmvc/testRest/1">Test Rest Get</a>
  <br><br>


  <form action="springmvc/testRest/2" method="POST">
      <input type="submit" value="Test Rest POST"/>
  </form>
  <br><br>


  <!-- 以下测试REST风格     分别发出GET POST DELETE PUT 请求
  如何发送 PUT 请求和 DELETE 请求呢 ?
   * 1. 需要配置 HiddenHttpMethodFilter
   * 2. 需要发送 POST 请求
   * 3. 需要在发送 POST 请求时携带一个 name="_method" 的隐藏域, 值为 DELETE 或 PUT
   -->
	<form action="springmvc/testRest/3" method="POST">
		<input type="hidden" name="_method" value="PUT"/>
		<input type="submit" value="Test Rest PUT"/>
	</form>
	<br><br>
	
	<form action="springmvc/testRest/4" method="POST">
		<input type="hidden" name="_method" value="DELETE"/>
		<input type="submit" value="Test Rest DELETE"/>
	</form>
	<br><br>



	
  </body>
</html>
