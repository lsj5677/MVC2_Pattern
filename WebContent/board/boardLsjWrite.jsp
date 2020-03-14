<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>boardInsert</title>
		<script type="text/javascript"
				src="https://code.jquery.com/jquery-1.11.0.min.js">
		</script>
	</head>
	<body>
		<form name="boardWrite" id="boardWrite" method="POST" enctype="application/x-www-form-urlencoded">
		<% 

		    
		    Object obj = request.getAttribute("lCnt"); 
			System.out.println("obj >>> : " +obj);
					
			if (obj !=null){
				System.out.println("boardInsert jsp >>> : ");
				
		%>
			<input type = "hidden" name="ISUD_TYPE" id="ISUD_TYPE">		
			<script type = "text/javascript">		
				$(function () {
						alert("boardWrite jsp >>>>> ");
						$("#ISUD_TYPE").val("BW");
						alert("BW >>> " + $("#ISUD_TYPE").val());
						$("#boardWrite").attr("action","/mvc2Pattern/board").submit();  
					});
					
			</script>				
		<%	}else{
				out.println("가입후 조회 실패");
			}//object if 끝
		%>
		</form>
	</body>
</html>