<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<!-- 사이드 메뉴 html 및 스타일 시트-->
	<jsp:include page="/include/sidebar.jsp"/>
    <div class="container">
    
    <form action="/photoInsert" method="post"  enctype="multipart/form-data">
    	<input type="text" name="pt_title">
    	<input type="text" name="pt_content">
		<input type="file"/>   
    </form>
    </div>
    <!-- 사이드메뉴 스크립트 및 로딩클로즈 --> 
    <jsp:include page="/include/close-function.jsp"/>   
</body>                     		                            
</html>    