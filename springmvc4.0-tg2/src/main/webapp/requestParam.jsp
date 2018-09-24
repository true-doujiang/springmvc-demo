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


  //======以下====只记住 @RequestParam(映射请求参数)===========================//<br>
  <a href="springmvc/testRequestParam?username=atguigu&age=11">Test RequestParam</a>
  <br>
  -----------------------------------------------------------------------------------------------------
  <br>

  <a href="springmvc/testRequestHeader">Test RequestHeader</a>
  <br>
  -----------------------------------------------------------------------------------------------------
  <br>

  <a href="springmvc/testCookieValue">Test CookieValue</a>

  <br>
  -----------------------------------------------------------------------------------------------------
  <br>

  <a href="springmvc/testPojo">Test testPojo GET/POST方式</a>

  <form action="springmvc/testPojo"     method="get">
      username: <input type="text"      name="username"/>           <br>
      password: <input type="password"  name="password"/>           <br>
      email:    <input type="text"      name="email"/>              <br>
      age:      <input type="text"      name="age"/>                <br>
      city:     <input type="text"      name="address.city"/>       <br>
      province: <input type="text"      name="address.province"/>   <br>
      <input type="submit"    value="Test testPojo GET/POST方式"/>
  </form>
  <br><br>





  </body>
</html>
