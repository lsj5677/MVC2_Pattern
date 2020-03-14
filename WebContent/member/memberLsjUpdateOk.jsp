<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import ="com.mvc2.member.dao.LsjMemberDao" %>
<%@ page import ="com.mvc2.member.dao.LsjMemberDaoImpl" %>
<%@ page import ="com.mvc2.member.vo.LsjMemberVO" %>
<%@ page import = "java.util.ArrayList"%>
<%@ page import= "com.mvc2.common.utils.FilePath" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>memberLsjUpdateOk</title>
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
	</head>
	<body>
		<form name="memberLsjUpdateOkForm" id="memberLsjUpdateOkForm" method="POST" enctype="multipart/form-data">
		<% 
		
			Object obj = request.getAttribute("aList");
			System.out.println("obj >>> : " + obj);
			ArrayList<LsjMemberVO> aList = (ArrayList<LsjMemberVO>)obj;
			int lCntU = aList.size();
			
			if(lCntU == 1){
				System.out.println("lCntU >>> : " + lCntU);
				
		%>
			<input type = "hidden" name="ISUD_TYPE" id="ISUD_TYPE">		
			<script type = "text/javascript">		
				$(function () {
					alert("updateOK jsp >>>>> ");
					$("#ISUD_TYPE").val("S");
					alert("S >>> " + $("#ISUD_TYPE").val());
					$("#memberLsjUpdateOkForm").attr("action","/mvc2Pattern/member").submit();  
				});
					
			</script>				
		<%	}else{
				out.println("업데이트 실패");
			}//object if 끝
		%>
		</form>
	</body>
</html>