<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>Add</title>  
    </head>  
    
  	<h2>Add</h2>  
	<form method="post" action="<%=request.getContextPath() %>/student.do?method=add">  
		name:<input type="text" name="name" id="name">
		passwd:<input type="text" name="passwd" id="passwd">  
		<input type="submit" value="submit">  
	</form>  
	
</html>