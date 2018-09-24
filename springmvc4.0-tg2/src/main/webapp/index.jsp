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

	
  </body>
</html>
