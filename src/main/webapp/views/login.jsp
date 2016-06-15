<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ page isELIgnored="false" %>
<!-- 使用set标签设置contextPath，也可以直接使用String path = request.getContextPath();通过path来取 -->
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>Login</title>  
    </head>  
    <center>
    	<h1>welcome</h1>
	  	<h2>login1</h2>  
	  	<h3>
	  		<font color="red">${message1}</font>
	  	</h3>
		<form method="post" action="${path}/student.do?method=login1">  
			name:<input type="text" name="name" id="name">
			passwd:<input type="text" name="passwd" id="passwd">  
			<input type="submit" value="submit">  
		</form>  
		<br>
		<h1>-----------------------------------------------------</h1>
		<h2>login2</h2>  
	  	<h3>
	  		<font color="red">${message2}</font>
	  	</h3>
		<form method="post" action="${path}/student.do?method=login2">  
			name:<input type="text" name="name" id="name">
			passwd:<input type="text" name="passwd" id="passwd">  
			<input type="submit" value="submit">  
		</form>  
		
		<h1>-----------------------------------------------------</h1>
		<h2>login3</h2>  
	  	<h3>
	  		<font color="red">${message3}</font>
	  	</h3>
		<form method="post" action="${path}/student.do?method=login3">  
			id:<input type="text" name="id" id="id">
			name:<input type="text" name="name" id="name">
			age:<input type="text" name="age" id="age">
			passwd:<input type="text" name="passwd" id="passwd">  
			<input type="submit" value="submit">  
		</form>  
	</center>
</html>