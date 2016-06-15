<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>Insert title here</title>  
    </head>  
    <body>  
       <h2>All students in System</h2>
 		<h3 style="color: orange;">当前用户：${currentUser.name}</h3>
	    <table border="1">
	        <tr>
	            <th>Id</th>
	            <th>Name</th>
	            <th>Age</th>
	            <th>Passwd</th>
	        </tr>
	        <c:forEach items="${students}" var="student">
	            <tr>
	                <td>${student.id}</td>
	                <td>${student.name}</td>
	                <td>${student.age}</td>
	                <td>${student.passwd}</td>
	            </tr>
	        </c:forEach>
	    </table>
	    <h3 style="color: orange;">当前用户：${currentUser.name}</h3>
	    <h3 style="color: blue;"><a href="<%=path%>/views/add.jsp">新增用户</a></h3>
    </body>  
</html>