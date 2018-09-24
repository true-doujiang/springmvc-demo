<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Jsp2.0一下版本默认不开启EL 所以需要在页面上添加 -->
<%@ page isELIgnored="false" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC  "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>添加员工</title>
</head>
<body>
	<br><br>
	<!--  
		1. WHY 使用 form 标签呢 ?
		可以更快速的开发出表单页面, 而且可以更方便的进行表单值的回显(****记住了)
		2.可以通过 modelAttribute 属性指定绑定的模型属性,(所以path就直接属性名就OK)
		若没有指定该属性，则默认从 request 域对象中读取 command 的表单 bean. 如果该属性值也不存在，则会发生错误。
	-->
	<!-- action要用绝对路径，否则跳来跳去有可能路径出错，实际开发都要绝对路径 -->														
	<form:form action="${pageContext.request.contextPath }/emp" method="POST" modelAttribute="employee">
		
		LastName: <form:input path="lastName"/> <form:errors path="lastName"/><br>
		Email:	  <form:input path="email"/> <form:errors path="email"/> <br>

		Gender:	  <form:radiobuttons path="gender" items="${genders }" delimiter=" " /><br>

		Department:<form:select path="department.id" items="${departments }"
                                itemLabel="departmentName" itemValue="id" /> <br>

        <%-- 新加这俩个属性测试数据类型格式化、参数校验jsr303 --%>
        Birth: 	  <form:input path="birth" /> <form:errors path="birth"/><br>
		Salary:   <form:input path="salary" /> <form:errors path="salary"/><br>
				  <input type="submit" value="Submit" />
	</form:form>


    <br><br><br>
    <hr/>
    <h3>测试自定义类型转换器</h3>
    <!-- lastname-email-gender-department-id 例如: GG-gg@atguigu.com-0-105 -->
    <form action="testConversionServiceConverer" method="GET">
        Employee: <input type="text" name="employee"/>
        <input type="submit" value="测试自定义转化器"/>
    </form>


</body>
</html>