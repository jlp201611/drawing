<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<!-- 사이드 메뉴 -->
	<jsp:include page="/include/sidebar.jsp"/>
	
    <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-5">
						<h2>User <b>Management</b></h2>
					</div>
                </div>
            </div>
   			<form action="/memberDeleteAdmin" method="post">
	            <table class="table table-striped table-hover">
	            	<colgroup>
	            		<col width="20%">
	            		<col width="auto">
	            	</colgroup>
	                <tbody>
	                	<c:if test="${result eq null }">
	                	 <tr ><td colspan="7">회원 정보가 없습니다.</td></tr>
	                	</c:if>
	                	<c:if test="${not empty result}">
	                         <tr><th>아이디</th><td>${result.mem_id}<input type="hidden" name="mem_id" value="${result.mem_id}"/></td> </tr>
	                         <tr><th>이름</th><td>${result.mem_name}</td> </tr>                        
	                         <tr><th>전화번호</th><td>${result.mem_phone}</td> </tr>
							 <tr><th>이메일</th><td>${result.mem_email}</td> </tr>
							 <tr><th>가입일</th><td>${result.reg_date}</td> </tr>
							 <tr><th>최근접속일</th><td>${result.access_date}</td> </tr>
	                    </c:if>
	                </tbody>
	            </table>
			<!-- 삭제 모달 팝업 -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">×</span><span class="sr-only">Close</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">비밀번호를 입력해주세요</h4>
							</div>
							<div class="modal-body">
								<input type="password" name="mem_pwd" class="form-control" placeholder="비밀번호" />
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
								<button type="submit" class="btn btn-primary" >확인</button>
							</div>
						</div>
					</div>
				</div>            
	        </form>              
			<div class="clearfix">
				<a href="/memberList">목록</a>
				<a href="/memberEdit">수정</a>
				<a href="/memberDelete" data-toggle="modal"  data-target="#myModal" >삭제</a>
            </div>
        </div>
    </div>  

	<jsp:include page="/include/close-function.jsp"/>
</body>
</html>                                		                            