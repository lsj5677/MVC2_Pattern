<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import ="com.mvc2.member.dao.LsjMemberDao" %>
<%@ page import ="com.mvc2.member.dao.LsjMemberDaoImpl" %>
<%@ page import ="com.mvc2.member.vo.LsjMemberVO" %>
<%@ page import = "java.util.ArrayList"%>
<%
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>memberLsjLogin</title>
	</head>
	<body>
		<form id="memberLsjLogin" name="memberLsjLogin" method="POST" enctype="application/x-www-form-urlencoded">
			<%
			Object obj = request.getAttribute("aList");
			System.out.println("obj >>> " + obj);
			
			if(obj!=null){
				ArrayList<String> aList = (ArrayList<String>)obj;
				if(aList.size()==1){
			%>
				<input type = "hidden" name="ISUD_TYPE" id="ISUD_TYPE">		
				<script>
					$(function(){
						alert("로그인 성공!!!");
						$("#ISUD_TYPE").val("SA");
						alert("$('#ISUD_TYPE').val('SA'); >>> " + $("#ISUD_TYPE").val());					
						$("#loginForm").attr("action","/mvc2Pattern/member").submit(); 
					});
				</script>			
			<%	
				}else{
			%>
				<script>
					$(function(){
						alert("로그인 실패!!!");
					});
				</script>
			<%
					}
				}
			%>
		</form>
	</body>
</html>