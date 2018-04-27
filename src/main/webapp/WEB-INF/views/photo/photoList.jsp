<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<!-- 사이드 메뉴 html 및 스타일 시트-->
	<jsp:include page="/include/sidebar.jsp"/>
	<!-- Home Content -->
	<div id="content" class="site-content">		
    <div class="container">
  
        <!-- Scroll Content -->
        <div id="content" class="site-content">
            <div class="full-screen-scroll">
            
                <ul id="cbp-bislideshow" class="cbp-bislideshow scroll">
				<c:forEach var="rs" items="${result}" varStatus="st">

                    <li style="background-image: url('/fileFolder/photo/${rs.ATCH_ID}');">
						<article class="entry-holder">
							<h2 class="entry-title"><a href="single.html">${rs.PT_TITLE}</a></h2>
							<div class="info-holder">
								<div class="cat-links">
									<ul><li><a href="#">${rs.PT_REG_DATE}</a></li></ul>
								</div>
								<div class="entry-date published">${rs.PT_CONTENT}
								
								</div>
							</div>
						</article>
					</li>
            	</c:forEach>
            
                </ul>
            </div>
		</div>
    </div>
    <!-- 사이드메뉴 스크립트 및 로딩클로즈 --> 
    <jsp:include page="/include/close-function.jsp"/>  
    </div>
</body>                     		                            
</html>    