<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOGIN</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
<script src="<%=request.getContextPath()%>js/bootstrap.min.js"></script>
</head>
<body>	
로그인
	<form action="/loginProc" method="post">
		<input type="text" placeholder="ID" name = "mem_id">
		<input type="password" placeholder="password" name="mem_pwd">
		<button type="submit">로그인</button>
		<a href="/join">회원가입</a>
		
	</form>
	
</body>
</html>