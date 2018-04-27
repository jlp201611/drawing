<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

<!-- 사이드 메뉴 -->
<jsp:include page="/include/sidebar.jsp" />


<!-- Home Content -->
<div id="content" class="site-content">
	<div id="blog-wrapper">
		<div class="blog-holder center-relative">


			<article id="post-1" class="blog-item-holder featured-post">
				<div class="entry-content relative">
					<div class="content-1170 center-relative">
						<div class="cat-links">
							<ul>
								<li><a href="/logout">로그아웃</a></li>
							</ul>
						</div>
						<div class="entry-date published">${loginInfo.mem_id}님환영합니다</div>
						<h2 class="entry-title">
							<a class="montserrat" >Slow and steady wins the race</a>
						</h2>

						<div class="clear"></div>
					</div>
				</div>
			</article>


			<article id="post-2" class="blog-item-holder">
				<div class="entry-content relative">
					<div class="content-1170 center-relative">
						<div id="write_include"></div>
						<h2 class="entry-title" >
							<a id="write" data-toggle="modal" data-target="#myModal" >Today Write <span class="read-more">
							</span></a>
							<jsp:include page="/include/photoForm.jsp"/>
						</h2>
						<div class="clear"></div>
					</div>
				</div>
			</article>


			<article id="post-3" class="blog-item-holder">
				<div class="entry-content relative">
					<div class="content-1170 center-relative">
						<h2 class="entry-title">
							<a href="/photoList">It’s all about experience</a>
						</h2>
						<div class="cat-links">
							<ul>
								<li><a href="#">3 St</a></li>
							</ul>
						</div>
						<div class="entry-date published">0000.00.00 ~ 0000.00.00</div>
						<div class="clear"></div>
					</div>
				</div>
			</article>



			<article id="post-4" class="blog-item-holder">
				<div class="entry-content relative">
					<div class="content-1170 center-relative">
						<h2 class="entry-title">
							<a href="/photoList">This is not my code</a>
						</h2>
						<div class="cat-links">
							<ul>
								<li><a href="#">2 St</a></li>
							</ul>
						</div>
						<div class="entry-date published">0000.00.00 ~ 0000.00.00</div>
						<div class="clear"></div>
					</div>
				</div>
			</article>



			<article id="post-5" class="blog-item-holder">
				<div class="entry-content relative">
					<div class="content-1170 center-relative">
						<h2 class="entry-title">
							<a href="/photoList">Support human activity</a>
						</h2>
						<div class="cat-links">
							<ul>
								<li><a href="#">1 st</a></li>
							</ul>
						</div>
						<div class="entry-date published">0000.00.00 ~ 0000.00.00</div>
						<div class="clear"></div>
					</div>
				</div>
			</article>

		</div>
		<div class="clear"></div>
		<div class="block load-more-holder">LOAD MORE ENTRIES</div>
	</div>

	<div class="featured-image-holder">
		<div class="featured-post-image" style="background-image: url(demo-images/featured-image.jpg)"></div>
	</div>
	<div class="clear"></div>
</div>


	<jsp:include page="/include/close-function.jsp"/>

</body>

</html>
