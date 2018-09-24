<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Jsp2.0一下版本默认不开启EL 所以需要在页面上添加 -->
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>
</head>
<body>
	
	<h4>Model Page</h4>
	
	
	time: ${requestScope.time }
	<br><br>
	names: ${requestScope.names }
	<br><br>
	
	request user: ${requestScope.user }
	<br><br>
	session user: ${sessionScope.user }
	<br><br>
	request school: ${requestScope.school }
	<br><br>
	session school: ${sessionScope.school }
	<br><br>
	
	
	abc user: ${requestScope.abc }
	<br><br>
	testModelAttribute user: ${requestScope.user }
	<br><br>
	

</body>
</html>