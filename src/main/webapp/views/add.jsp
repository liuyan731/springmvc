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
        <title>Add</title>  
    </head>  
    
  	<h2>Add</h2>  
  	<h3 style="color: red;">${addFailed }</h3>
	<form method="post" action="<%=path%>/student.do?method=add">  
		id:<input type="text" name="id" id="id">
		name:<input type="text" name="name" id="name">
		age:<input type="text" name="age" id="age">
		passwd:<input type="text" name="passwd" id="passwd">  
		<input type="submit" value="submit">  
	</form>  
	
</html>