<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>index</title>
</head>
<body>

    <a href="springmvc/testRedirect">Test Redirect</a>
    <br><br>

    <a href="springmvc/aaa">Test aaa</a>
    <br><br>


    <a href="springmvc/testViewAndViewResolver">Test ViewAndViewResolver</a>
    <br><br>

    -----------------------------------------------------------
    <br><br>
    <a href="springmvc/helloView">Test helloView</a>
    <br><br>


    <a href="springmvc/excelView">Test excelView</a>
    <br><br>

    <a href="springmvc/pdfView">Test pdfView</a>
    <br><br>
    -----------------------------------------------------------
    <br><br>


    <a href="admin">Test admin</a>
    <br><br>

</body>
</html>
