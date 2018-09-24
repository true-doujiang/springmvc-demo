<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Jsp2.0一下版本默认不开启EL 所以需要在页面上添加 -->
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>全局错误页面</title>
</head>
<body>

<h4>Error Page</h4>

requestScope.exception: ${requestScope.exception }<br/>



requestScope.ex: ${requestScope.ex }

</body>
</html>