<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <head>
        <title>LeeMin-Gyeong</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="Template by Colorlib" />
        <meta name="keywords" content="HTML, CSS, JavaScript, PHP" />
        <meta name="author" content="Colorlib" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		
		<!-- 부트스트랩  -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
		<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
		<script src="<%=request.getContextPath()%>js/bootstrap.min.js"></script>	
		<!-- 메인템플릿 관련 -->
        <link rel="shortcut icon" href="images/favicon.png" />
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">    
        <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700%7CLibre+Baskerville:400,400italic,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css"  href='css/clear.css' />
        <link rel="stylesheet" type="text/css"  href='css/common.css' />
        <link rel="stylesheet" type="text/css"  href='css/font-awesome.min.css' />
        <link rel="stylesheet" type="text/css"  href='css/carouFredSel.css' />
        <link rel="stylesheet" type="text/css"  href='css/sm-clean.css' />
        <link rel="stylesheet" type="text/css"  href='css/style.css' />
		
		<!-- include summernote css/js -->
		<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css" rel="stylesheet">
		<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>	

        <!--[if lt IE 9]>
                <script src="js/html5.js"></script>
        <![endif]-->
        

 		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
	<!-- 	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/font-awesome.min.css">		 -->


		
		<!-- 회원관련 페이지 외부 스타일 시트-->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style/memberList.css">

		<!-- 회원관련 페이지 -->
		<script type="text/javascript">
			$(document).ready(function(){
				$('[data-toggle="tooltip"]').tooltip();
			});
		</script>        
 		<style type="text/css">
			.logout { color: #D8588C; font-size: 14px; }
			
			a:focus,  a:hover {
			    color: #23527c;
			    text-decoration: none;
			}
			h2 {
			    font-weight: bold;
			}
			#toggle {
		   		height: 100px;
		    }
		    .note-editable {
		    	font-size: 22px;
		    }

			#post-2 {
				margin-bottom: 30px
			}	    		
		</style>       
        
        
    </head>


    <body class="home blog">

        <!-- Preloader Gif -->
        <table class="doc-loader">
            <tbody>
                <tr>
                    <td>
                        <img src="images/ajax-document-loader.gif" alt="Loading...">
                    </td>
                </tr>
            </tbody>
        </table>

        <!-- Left Sidebar -->
        <div id="sidebar" class="sidebar">
            <div class="menu-left-part">
                <div class="site-info-holder">
                    <h1 class="site-title">${loginInfo.mem_id}님</h1>
                    <a class="logout" href="/logout">로그아웃</a>
                    <p class="site-description">
                        Suppablog is simple and yet cool wordpress theme to lorem ipsum dolor sit.
                    </p>
                </div>
                <nav id="header-main-menu">
                    <ul class="main-menu sm sm-clean">
                        <li><a href="/" class="current">Home</a></li>
                        <li><a href="#">Total</a></li>
                        <li><a href="#">자유게시판</a></li>
                       <!--  <li><a href="#">행아웃</a></li> -->
                        <c:if test="${loginInfo.mem_id eq 'admin'}">
                        <li><a href="/memberList">회원관리</a></li>
                        </c:if>
                        
                    </ul>
                </nav>
                <footer>
                    <div class="footer-info">
                        © 2018 SUPPABLOG HTML TEMPLATE. <br> CRAFTED WITH <i class="fa fa-heart"></i> BY <a href="https://colorlib.com">COLORLIB</a>.
                    </div>
                </footer>
            </div>
            <div class="menu-right-part">
                <div class="logo-holder">
                    <a href="/">
                        <img src="images/logo.png" alt="Suppablog WP">
                    </a>
                </div>
                <div class="toggle-holder">
                    <div id="toggle">
                        <div class="menu-line"></div>
                    </div>
                </div>

                <div class="fixed scroll-top"><i class="fa fa-caret-square-o-up" aria-hidden="true"></i></div>
            </div>
            <div class="clear"></div>
        </div>
      