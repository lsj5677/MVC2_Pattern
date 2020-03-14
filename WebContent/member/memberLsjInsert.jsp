<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>memberLsjInsert</title>
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
	</head>
	<body>
		<form name="memberLsjInsert" id="memberLsjInsert" method="POST" enctype="application/x-www-form-urlencoded">
			<%
				// setAttribute key값 넣어주기
				Object bFlag = request.getAttribute("bFlag");
				System.out.println("	bFlag >>> " + bFlag);
				
				if(bFlag!=null){
			%>
				<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" />
				<script>
					$(function(){
						alert("memberLsjInsert jsp >>> ");
						$('#ISUD_TYPE').val("SA");
						
						alert("$('#ISUD_TYPE').val() >>> " + $('#ISUD_TYPE').val());
						$('#memberLsjInsert').attr('action','/mvc2Pattern/member').submit();
					});
				</script>
			<%
				}else{
					System.out.println("가입 후 조회실패");
				}
			%>
		</form>
	</body>
</html>