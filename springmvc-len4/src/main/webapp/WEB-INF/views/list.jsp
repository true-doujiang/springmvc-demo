<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Jsp2.0一下版本默认不开启EL 所以需要在页面上添加 -->
<%@ page isELIgnored="false" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>员工列表</title>
    <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".delete").click(function () {
                var href = $(this).attr("href");
                $("form").attr("action", href).submit();
                return false;
            });
        });
    </script>
</head>
<body>

<!--
		静态资源引入不了问题:
		1. 原因:优雅的 REST风格的资源URL不希望带 .html或 .do等后缀。若将 DispatcherServlet 请求映射配置为 /, 
		         则 Spring MVC 将捕获 WEB 容器的所有请求, 包括静态资源的请求, SpringMVC 会将他们当成一个普通请求处理, 因找不到对应处理器将导致错误。
		2. 解决: 在 SpringMVC 的配置文件中配置 <mvc:default-servlet-handler />
	-->
<!-- springMVC没有struts2好的一点就是没有自己的"遍历标签"，只能用jstl
     springMVC有表单标签....
-->

<!-- 为了把get请求装成Delete请求-->
<form action="" method="POST">
    <input type="hidden" name="_method" value="DELETE"/>
</form>

<a href="emp">新增员工</a><br>

<hr/>

<c:if test="${empty(requestScope.employees)}"> <!-- empty加不加括号都可以 -->
    没有任何员工信息.
</c:if>
<c:if test="${!empty requestScope.employees }">
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>LastName</th>
            <th>Email</th>
            <th>Salary</th>
            <th>Gender</th>
            <th>Department</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${requestScope.employees }" var="emp">
            <tr>
                <td>${emp.id }</td>
                <td>${emp.lastName }</td>
                <td>${emp.email }</td>
                <td>${emp.salary }</td>
                <td>${emp.gender==0?'Female':'Male'}</td>
                <td>${emp.department.departmentName }</td>
                <td><a href="emp/${emp.id}">Edit</a></td>
                <td><a class="delete" href="emp/${emp.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


</body>
</html>