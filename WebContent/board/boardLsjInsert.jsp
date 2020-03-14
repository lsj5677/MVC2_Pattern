<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>boardInsert</title>
		<script type="text/javascript"
				src="https://code.jquery.com/jquery-1.11.0.min.js">
		</script>
	</head>
	<body>
		<form name="boardInsert" id="boardInsert" method="POST" enctype="application/x-www-form-urlencoded">
		<% 

		    
		    Object obj = request.getAttribute("lCnt"); 
			System.out.println("obj >>> : " +obj);
					
			if (obj !=null){
				System.out.println("boardInsert jsp >>> : ");
				
		%>
			<input type = "hidden" name="ISUD_TYPE" id="ISUD_TYPE">		
			<script type = "text/javascript">		
				$(function () {
						alert("boardInsert jsp >>>>> ");
						$("#ISUD_TYPE").val("BSA");
						alert("BSA >>> " + $("#ISUD_TYPE").val());
						$("#boardInsert").attr("action","/mvc2Pattern/board").submit();  
					});
					
			</script>				
		<%	}else{
				out.println("글쓰기 실패");
			}//object if 끝
		%>
		</form>
	</body>
</html>