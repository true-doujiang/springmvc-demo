<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>首页</title>
    <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        $(function(){

        });
    </script>
</head>
<body>


<br><br>

<a href="emps">列表展示所有员工</a>
<br><br>

<hr/>
<a href="testJson" id="testJson">Test Json</a>
<br><br>

<hr/>
<form action="testHttpMessageConverter" method="POST" enctype="multipart/form-data">
    File: <input type="file" name="file"/><br>
    Desc: <input type="text" name="desc"/><br>
    <input type="submit" value="testHttpMessageConverter"/>
</form>

<hr/>
<br><br>
<h3>下载效果</h3>
<a href="testResponseEntity?param=abcA">Test ResponseEntity</a>

<br><br>
<hr/>
<!-- 文件上传功能 -->
<h3>文件上传功能</h3>
<form action="testFileUpload" method="POST" enctype="multipart/form-data">
    File: <input type="file" name="file"/><br>
    Desc: <input type="text" name="desc"/><br>
    <input type="submit" value="上传"/>
</form>



</body>
</html>
