<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<!-- 사이드 메뉴 html 및 스타일 시트-->
	<jsp:include page="/include/sidebar.jsp"/>
<!-- Home Content -->
<div id="content" class="site-content">	
    <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-5">
						<h2>User <b>Management</b></h2>
					</div>
					<div class="col-sm-7">
						<div class="search-holder">
	                    		<form action="/memberList" method="post"  class="form-lnline" >
                    				<button class="btn pull-right" type="submit" class="btn">검색</button>
	                    			<label class="pull-right">
		                        		<input name="searchWord"  type="search" class="search-field" placeholder="ID here to search..." value="" title="Search for:">
	                    			</label>

	                    		</form>
                    		
                		</div>
               		</div>
                </div>
            </div>           
            <table class="table table-striped table-hover">
            	<colgroup>
            		<col width="60px">
            		<col width="">
            		<col width="">
            		<col width="20%">
            		<col width="20%">
            		<col width="100px">
				</colgroup>            		
                <thead>
                    <tr>
                        <th>#</th>
                        <th>아이디</th>						
                        <th>이름</th>						
                        <th>가입일</th>
						<th>최근접속일</th>
						<th>삭제</th>
                    </tr>
                </thead>
                <tbody>
                	<c:if test="${result eq null }">
                	 <tr><td>회원 정보가 없습니다.</td></tr>
                	</c:if>
                	<c:if test="${not empty result}">
                	<c:forEach var="result" items="${result}" varStatus="st">
                    <tr>
                        <td>${st.count}</td>
                        <td class="mem_id"><a href="/memberView?mem_id=${result.mem_id}"><span class="glyphicon glyphicon-user" aria-hidden="true"> </span>${result.mem_id}</a></td>
                        <td>${result.mem_name}</td>                        
						<td>${result.reg_date}</td>
						<td>${result.access_date}</td>
						<td><a class="delete" title="Delete" data-toggle="modal" data-target="#myModal" ><i class="material-icons">&#xE5C9;</i></a>
						</td>
                    </tr>
                    </c:forEach>
                    </c:if>
                </tbody>
            </table>
        <script type="text/javascript">
        	$(function(){
        		$("tr").on("click", function(){
        			var mem_id = $(this).find(".mem_id>a").html().replace('<span class="glyphicon glyphicon-user" aria-hidden="true"> </span>',"");
        			 $("input[name=mem_id]").val(mem_id);
        			
        		})        		
        		
        	})
        </script>
		<!-- 삭제 모달 팝업 -->
		<form action="/memberDeleteAdmin" method="post">
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
						<input type="hidden" name="mem_id"/>
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
                <div class="hint-text">Total : <b>${search.totalRowCount} </b> Page : <b>${search.totalPageCount}</b></div>

                <ul class="pagination">
                    <c:if test="${search.startPage > 1}">
					<li class="page-item"><a href="/memberList?currentPage=${search.startPage -1 }" aria-label="Previous" class="page-link"><span aria-hidden="true">&laquo;</span></a></li>						
					</c:if>  
					<c:forEach var="i" begin="${search.startPage}" end="${search.endPage }" varStatus="st">
						<c:if test="${i eq search.currentPage}">
							<li class="page-item active"><a data-page="${i}">${i}</a></li>
						</c:if>
						<c:if test="${i ne search.currentPage}">
							<li class="page-item"><a data-page="${i}">${i}</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${search.endPage < search.totalPageCount}">
					<li class="page-item"><a href="/memberList?currentPage=${search.endPage + 1 }" aria-label="Next" class="page-link"><span aria-hidden="true">&raquo;</span></a></li>						
					</c:if>
					<c:if test="${search.searchWord != ''}">
						<li><a href="/memberList" class="btn btn-default">리셋</a></li>
					</c:if>	                    
                </ul>
                <form action="/memberList" name="frm_search"  method="post">
                	<input type="hidden" name="currentPage" value="${search.currentPage}" />
                	<input type="hidden" name="searchWord" value="${search.searchWord}" />
                	<input type="hidden" name="listSize" value="${search.listSize}" />
                </form>
               
				<script type="text/javascript">
						$(".pagination li a").on("click",function(){
							var frm = document.forms.frm_search;
							frm.currentPage.value =$(this).data("page"); 
							frm.submit();
					});
				</script>
            </div>
        </div>
    </div>
    <!-- 사이드메뉴 스크립트 및 로딩클로즈 --> 
    <jsp:include page="/include/close-function.jsp"/>  
  	</div>
</body>                     		                            
</html>