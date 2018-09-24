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

  <a href="springmvc/testModelAndView">Test ModelAndView</a>
  <br><br>


  -----------------------------------------------------------------------------------------------------
  <br><br>
  <a href="springmvc/testMap">Test Map</a>
  <br><br>



  //==========处理模型数据  可以配合@SessionAttributes注解使用   ==============<br>

  <a href="springmvc/testSessionAttributes">Test SessionAttributes</a>
  <br><br>
	
  </body>
</html>
