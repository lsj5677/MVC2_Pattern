<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.mvc2.board.dao.LsjBoardDao" %>
<%@ page import="com.mvc2.board.dao.LsjBoardDaoImpl" %>
<%@ page import="com.mvc2.board.vo.LsjBoardVO" %>
<%@ page import="java.util.ArrayList" %>  

<%@ page import= "com.mvc2.common.utils.FilePath" %>

<% request.setCharacterEncoding("UTF-8"); %>
<%
	Object obj = request.getAttribute("aList");
	System.out.println("obj >>> : " + obj);
	ArrayList<LsjBoardVO> aList = (ArrayList<LsjBoardVO>)obj;
	int lCntU = aList.size();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>boardUpdate</title>
		
		<script type="text/javascript"
				src="https://code.jquery.com/jquery-1.11.0.min.js">
		</script>
		 <!--<script type="text/javascript"
				src="../js/jquery-1.11.0.min.js">
		</script>  -->
		
	</head>
	<body>
		<form name="updateOKForm" id="updateOKForm" method="POST" enctype="multipart/form-data">
		<% 

					
			if(lCntU == 1){
				System.out.println("lCntU >>> : " + lCntU);
				
		%>
			<input type = "hidden" name="ISUD_TYPE" id="ISUD_TYPE">		
			<script type = "text/javascript">		
				$(function () {
					alert("updateOK jsp >>>>> ");
					$("#ISUD_TYPE").val("BSA");
					alert("BSA >>> " + $("#ISUD_TYPE").val());
					$("#updateOKForm").attr("action","/mvc2Pattern/board").submit();  
				});
					
			</script>				
		<%	}else{
				out.println("업데이트 실패");
			}//object if 끝
		%>
		</form>
	</body>
</html>



