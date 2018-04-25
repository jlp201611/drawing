<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

<!-- 사이드 메뉴 -->
<jsp:include page="/include/sidebar.jsp" />

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
							Slow and steady wins the race
						</h2>

						<div class="clear"></div>
					</div>
				</div>
			</article>


			<article id="post-2" class="blog-item-holder">
				<div class="entry-content relative">
					<div class="content-1170 center-relative">
						<h2 class="entry-title">
							<a href="single.html">Today Write <span class="read-more">
							</span></a>
						</h2>
						<div class="cat-links">
							<ul>
								<li><a href="#">Science</a></li>
							</ul>
						</div>
						<div class="entry-date published">February 12, 2016</div>
						<div class="clear"></div>
					</div>
				</div>
			</article>


			<article id="post-3" class="blog-item-holder">
				<div class="entry-content relative">
					<div class="content-1170 center-relative">
						<h2 class="entry-title">
							<a href="single.html">Everything is design</a>
						</h2>
						<div class="cat-links">
							<ul>
								<li><a href="#">Art</a></li>
							</ul>
						</div>
						<div class="entry-date published">February 12, 2016</div>
						<div class="clear"></div>
					</div>
				</div>
			</article>



			<article id="post-4" class="blog-item-holder">
				<div class="entry-content relative">
					<div class="content-1170 center-relative">
						<h2 class="entry-title">
							<a href="single.html">It’s all about experience</a>
						</h2>
						<div class="cat-links">
							<ul>
								<li><a href="#">Life</a></li>
							</ul>
						</div>
						<div class="entry-date published">February 12, 2016</div>
						<div class="clear"></div>
					</div>
				</div>
			</article>



			<article id="post-5" class="blog-item-holder">
				<div class="entry-content relative">
					<div class="content-1170 center-relative">
						<h2 class="entry-title">
							<a href="single.html">This is not my code</a>
						</h2>
						<div class="cat-links">
							<ul>
								<li><a href="#">Coding</a></li>
							</ul>
						</div>
						<div class="entry-date published">February 12, 2016</div>
						<div class="clear"></div>
					</div>
				</div>
			</article>



			<article id="post-6" class="blog-item-holder">
				<div class="entry-content relative">
					<div class="content-1170 center-relative">
						<h2 class="entry-title">
							<a href="single.html">Support human activity</a>
						</h2>
						<div class="cat-links">
							<ul>
								<li><a href="#">Advocacy</a></li>
							</ul>
						</div>
						<div class="entry-date published">February 12, 2016</div>
						<div class="clear"></div>
					</div>
				</div>
			</article>

		</div>
		<div class="clear"></div>
		<div class="block load-more-holder">LOAD MORE ENTRIES</div>
	</div>

	<div class="featured-image-holder">
		<div class="featured-post-image"
			style="background-image: url(demo-images/featured-image.jpg)"></div>

	</div>
	<div class="clear"></div>
</div>


	<jsp:include page="/include/close-function.jsp"/>
	
</body>

</html>
