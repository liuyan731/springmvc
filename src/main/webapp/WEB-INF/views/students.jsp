<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>Insert title here</title>  
    </head>  
    <h1>test</h1>  
    <body>  
       <h2>All students in System</h2>
 
	    <table border="1">
	        <tr>
	            <th>Id</th>
	            <th>Name</th>
	            <th>Age</th>
	        </tr>
	        <c:forEach items="${students}" var="student">
	            <tr>
	                <td>${student.id}</td>
	                <td>${student.name}</td>
	                <td>${student.age}</td>
	            </tr>
	        </c:forEach>
	    </table>
    </body>  
</html>