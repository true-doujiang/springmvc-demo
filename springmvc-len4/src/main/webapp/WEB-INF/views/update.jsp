<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Jsp2.0一下版本默认不开启EL 所以需要在页面上添加 -->
<%@ page isELIgnored="false" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC
	"-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>修改员工</title>
</head>
<body>


	<!-- action要用绝对路径，否则跳来跳去有可能路径出错，实际开发都要绝对路径 -->
	<form:form action="${pageContext.request.contextPath }/emp" method="POST" modelAttribute="employee">
			<form:hidden path="id"/>

				<input type="hidden" name="_method" value="PUT"/>

		<%-- LastName: <form:input path="lastName"/><br> 不显示修改使用@ModelAttribute查找--%>
		Email:	    <form:input path="email"/><br>
		Gender:	    <form:radiobuttons path="gender" items="${genders }" delimiter=" " /><br>
		Department: <form:select path="department.id" items="${departments }" itemLabel="departmentName" itemValue="id">
					</form:select> <br>
					<input type="submit" value="Submit"/>
	</form:form>

</body>
</html>