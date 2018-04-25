<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>         
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
회원가입
<form action="/joinProc" method="post">
	<input type="text" name="mem_id" placeholder="ID" >
	<input type="password" name="mem_pwd"placeholder="password" >
	<input type="test" name="mem_name"placeholder="name" >
	<input type="text" name="mem_phone" placeholder="phone">
	<input type="text" name="mem_email" placeholder="email">
	<button type="submit">회원가입</button>
</form>


</body>
</html>