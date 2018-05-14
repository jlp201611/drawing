<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>         
  
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>Login V10</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="login/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="login/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login/css/util.css">
	<link rel="stylesheet" type="text/css" href="login/css/main.css">
<!--===============================================================================================-->


</head>
<body>

	<div id="list"></div>
	<div id="callBackDiv">	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-50 p-b-90">
				<form  action="/joinProc" method="post" class="login100-form validate-form flex-sb flex-w" id="frmBoard">
				
					<span class="login100-form-title p-b-51">
						
					</span>

					<div class="wrap-input100 validate-input m-b-16" data-validate = "Username is required">
						<input class="input100" type="text" name="mem_id" id="mem_id" placeholder="UserID">
						<span class="focus-input100"></span>
					</div>
					
					
					<div class="wrap-input100 validate-input m-b-16" data-validate = "Password is required">
						<input class="input100" type="password" name="mem_pwd" placeholder="Password">
						<span class="focus-input100"></span>
					</div>
					
					
					<div class="wrap-input100 validate-input m-b-16" data-validate = "Username is required">
						<input class="input100" type="text" name="mem_name" placeholder="Username">
						<span class="focus-input100"></span>
					</div>
					
					
					<div class="wrap-input100 validate-input m-b-16" data-validate = "Username is required">
						<input class="input100" type="text" name="mem_phone" placeholder="Userphone">
						<span class="focus-input100"></span>
					</div>
					
					
					<div class="wrap-input100 validate-input m-b-16" data-validate = "Username is required">
						<input class="input100" type="text" name="mem_email" placeholder="Useremail">
						<span class="focus-input100"></span>
<!-- 					</div>
					<div class="wrap-input100 validate-input m-b-16" data-validate = "Username is required">
						<input type="text"   class="input100"  style="width:500px;" id="roadFullAddr"  name="roadFullAddr"  onClick="goPopup();"  />
						<span class="focus-input100"></span> -->
					</div>

					<div class="container-login100-form-btn m-t-17">
						<button class="login100-form-btn" type="submit">
							Join
						</button>
					</div>
					<span class="login100-form-title p-b-51" style="text-align:right">
						<a href="/login" class="txt1" >
							Cancle
						</a>
					</span>	
				</form>
			</div>
		</div>
	</div>
</div>	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="login/vendor/jquery/jquery-3.3.1.js"></script>
<!--===============================================================================================-->
	<script src="login/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="login/vendor/bootstrap/js/popper.js"></script>
	<script src="login/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="login/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="login/vendor/daterangepicker/moment.min.js"></script>
	<script src="login/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="login/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="login/js/main.js"></script>
<script type="text/javascript">
	 $(function(){

		
			//서브밋 버튼
			$("#frmBoard").submit(function(e){
				e.preventDefault(); // 서브밋일 경우는 2번 클릭..?? 내가 써놓은 건디 먼말인지 몰겠다ㅋㅋㅋ서브밋의 원래 기능 삭제하는 
				//var params = $(this).serialize(); //일반 get또는post방식
				//var params = new FormData(this); //multipart(파일업로드 형식을때는 formData를 써줘야 한다) this -> ok / $(this) -> x
				var params = {
						  "mem_id": $("input[name=mem_id]").val()
						, "mem_pwd":$("input[name=mem_pwd]").val()
						, "mem_name":$("input[name=mem_name]").val()
						, "mem_phone":$("input[name=mem_phone]").val()
						, "mem_email":$("input[name=mem_email]").val()
				}
				
				console.log("params :" ,params);
				$.ajax({
				  	url: 'joinProc',
				    type: 'POST',
				    processData: false,
				    contentType: "application/json;charset=UTF-8",
				    data:JSON.stringify(params),
				    dataType: 'json',
				    success: function (data) {
				    	console.log("data : ", data)
				        if (data.checkID){//로그인 실패
				           alert(data.message);
				           location.href="/login"; 
				        }else{ //로그인성공
				           
				           alert(data.message);
				        }
		  		 },
		  		error:function(request,status,error){
		  		    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		  		   }


			});
		});	
			

		//아이디 체크
			$("#mem_id").focusout(function(e){
				var mem_id = $("#mem_id").val();
				var params = new FormData(this);
				console.log("000"+params.mem_id)
				console.log("포커스 아웃"+mem_id)
				console.log("제이슨 : "+JSON.stringify(mem_id))
				
				var data = {"mem_id":$("#mem_id").val()};
				console.log("제이슨11 : "+JSON.stringify(data))
				
				//var params = new FormData(this); //multipart(파일업로드 형식을때는 formData를 써줘야 한다) this -> ok / $(this) -> x
				$.ajax({
				  	url: 'checkId',
				    type: 'POST',
				    processData: false,
				    contentType:"application/json;charset=UTF-8",
				    data:JSON.stringify(data),
				    dataType: 'json',
				    success: function (data) {
				    	//console.log("data : ", data)
				        if (data.checkID){//로그인성공
				           alert(data.message);
				           //location.href="/login"; 
				        }else{ //로그인 실패
				           alert(data.message);
				        }
			  		 },
	                error: function (error) {
	                    alert("error"+error.message);
	                }
				});

			});			

}); //로드end
 
</script>
</body>
</html>