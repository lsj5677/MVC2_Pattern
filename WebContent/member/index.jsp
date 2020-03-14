<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
		<style>
			/* reset */
			* {
				margin: 0;
				padding: 0;
			}
			
			/* wrap */
			.wrap {
				width: 100%;
				height: 100vh;
				background-color: #eee;
				position: relative;
			}
			
			/* header , footer */
			header,
			footer {
				padding: 20px 0;
				text-align: center;
				background-color: #ddd;
			}
			
			/* footer */
			footer {
				width: 100%;
				position: absolute;
				bottom: 0;
			}
			
			/* login-contents */
			#login-contents {
				position: absolute;
				text-align: center;
			    left: 50%;
			    top: 50%;
			    transform: translate(-50%,-50%);
			}

			
			#login-contents h2 {
				font-size: 50px;
				margin-bottom: 20px;
				text-transform: uppercase;
			}
			
			/* input-group */
			.input-group {
			}
			
			.input-group > input {
				display: block;
				margin: 10px auto;
				padding: 15px 0;
				width: 300px;
				border: 0;
				box-sizing: border-box;
				border-radius: 3px;
			}
			
			.input-group .input-group-text {
				padding-left: 15px;
			}
			
			.input-group .input-group-btn {
				cursor: pointer;
				background-color: #333;
				color: #fff;
			}
			
			.input-group .input-group-btn:last-child {
				background-color: #cf0000;
			}
			
			.input-group .input-group-btn:hover {
				background-color: #aaa;
				color: #333;
				transition: .2s all ease;
			}
			
			.input-group .input-group-btn:last-child:hover {
				color: #cf0000;
			}
			
		</style>
		<script>
			$(function(){
				$('#loginBtn').click(function(){
					alert('loginBtn click >>>');

					if(!$('#lid').val()){
						alert('아이디를 입력하세요');
						$('#lid').focus();	
						return false;
					}
					if(!$('#lpw').val()){
						alert('비밀번호를 입력하세요');
						$('#lpw').focus();	
						return false;
					}
					
					$('#ISUD_TYPE').val('LOGIN');
					alert("$('#ISUD_TYPE').val() >>> " + $('#ISUD_TYPE').val());
					$('#loginForm').attr('action','/mvc2Pattern/member').submit();
				});
				$('#signUpBtn').click(function(){
					alert('signUpBtn click >>>');
					$('#loginForm').attr('action','/mvc2Pattern/member/memberLsjSignUpForm.jsp').submit();
				});
				
				
				
			});
		</script>
	</head>
	<body>
		<!-- wrap -->
		<div class="wrap">
			<!-- header -->
			<header>
				<h2>header area</h2>
			</header>
			<!-- //header -->
			<!-- login-contents -->
			<div id="login-contents">
				<!-- h2 -->
				<h2>Login</h2>
				<!-- //h2 -->
				
				<!-- loginForm -->
				<form id="loginForm" name="loginForm" method="POST">
					<!-- input-group-->
					<div class="input-group">
						<input type="text" id="lid" name="lid" class="input-group-text" placeholder="아이디를 입력하세요" />
						<input type="password" id="lpw" name="lpw" class="input-group-text" placeholder="비밀번호를 입력하세요" />
					</div>
					<!-- //input-group -->
					
					<!-- input-group -->
					<div class="input-group">
						<input type="hidden" id="ISUD_TYPE" name="ISUD_TYPE">
						<input type="button" value="LOGIN" class="input-group-btn" id="loginBtn" />
						<input type="button" value="SIGNUP" class="input-group-btn" id="signUpBtn" />
						<input type="reset" value="RETRY" class="input-group-btn" />
					</div>
					<!-- //input-group -->
				</form>
				<!-- //loginForm -->
			</div>
			<!-- //login-contents -->
			<!-- footer -->
			<footer>
				Copyright ⓒ 2020 LeeSujin
			</footer>
			<!-- //footer -->
		</div>
		<!-- //wrap -->	
	</body>
</html>