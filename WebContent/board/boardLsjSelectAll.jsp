<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mvc2.board.dao.LsjBoardDao" %>
<%@ page import="com.mvc2.board.dao.LsjBoardDaoImpl" %>
<%@ page import="com.mvc2.board.vo.LsjBoardVO" %>
<%@ page import="java.util.ArrayList" %>  
<% request.setCharacterEncoding("UTF-8"); %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>boardLsjSelectAll</title>
		<script type="text/javascript"
		src="https://code.jquery.com/jquery-1.11.0.min.js"></script> 
		
		<script>
			$(function(){
				$("#boardLsjInsertBtn").click(function(){
					alert("boardLsjInsertBtn >>>>> ");
					$("#ISUD_TYPE").val("BW");
					alert("BW >>> " + $("#ISUD_TYPE").val());
					$("#boardSelectAll").attr("action","/mvc2Pattern/board").submit();
				});	
				$("#boardLsjSelectAllBtn").click(function(){
					alert("boardLsjSelectAllBtn >>>>> ");
					$("#ISUD_TYPE").val("BSA");
					alert("BSA >>> " + $("#ISUD_TYPE").val());
					$("#boardSelectAll").attr("action","/mvc2Pattern/board").submit();
				});	
				$("#boardLsjDeleteBtn").click(function(){
					alert("boardLsjDeleteBtn >>>>> ");
					$("#ISUD_TYPE").val("BD");
					alert("BD >>> " + $("#ISUD_TYPE").val());
					$("#boardSelectAll").attr("action","/mvc2Pattern/board").submit();
				});	
				$("#boardLsjUpdateBtn").click(function(){
					alert("boardLsjUpdateBtn >>>>> ");
					$("#ISUD_TYPE").val("BU");
					alert("BU >>> " + $("#ISUD_TYPE").val())
					$("#boardSelectAll").attr("action","/mvc2Pattern/board").submit();
				});	
			});
		</script>
	</head>
	<body>
		<form name="boardSelectAll" id="boardSelectAll" method ="POST">
		<% 

		Object obj = request.getAttribute("aList"); 
		System.out.println("obj1 >>> : " +obj);
				
		if (obj != null){
			ArrayList<LsjBoardVO> aList = (ArrayList<LsjBoardVO>) obj;
			if (aList.size() == 0){
	
			%>	
			<table border="1" class="table">
				<tr>
					<td>NO DATA</td>
				</tr>
			</table>			
			<% 		
	 		}else{
			%>
			<table border="1" class="table">
				<tr>
					<td colspan="7" align="center"><h3>게시판목록  </h3></td>
				</tr>	
				<tr>
					<td class="info_title"><input type="checkbox" name="chkAll" id="chkAll"></td>
					<td class="info_title">글번호</td>
					<td class="info_title">제목</td>
					<td class="info_title">이름</td>
					<!-- <td class="info_title">비밀번호</td> -->
					<td class="info_title">내용</td>
					<td class="info_title">회원사진</td>
				</tr>
			 		
		<% 		for(int i =0; i<aList.size(); i++){  
					LsjBoardVO lvo = aList.get(i);
					System.out.println("사진경로>>> : "+ "../upload/"+ lvo.getLimage());
		%>
				<tr>
				    <td class="info_con"><input type="checkbox" name="chkInLno" id="chkInLno"  
												value=<%= lvo.getLno() %> onclick="checkOnly(this)"></td>
				<td class="info_con"><%=lvo.getLno() %></td>
				<td class="info_con"><%=lvo.getLsubject() %></td>
				<td class="info_con"><%=lvo.getLname() %></td>
				<%-- <td class="info_con"><%=lvo.getLpw() %></td> --%>
				<td class="info_con"><%=lvo.getLmemo() %></td>
				<td><img src = "./upload/<%=lvo.getLimage()%>" border=0 width="150" height="100"></td>
				</tr>
				
		<%			} //for끝
				} //aList.size if 끝
			}//object if 끝%>
			<!-- tr -->
				<tr>
					<td colspan="7" class="info_button">
						<input type="hidden" id="ISUD_TYPE" name="ISUD_TYPE">
						<input type="button" value="글쓰기" id="boardLsjInsertBtn" name="boardLsjInsertBtn" class="btn">
						<input type="button" value="수정" id="boardLsjUpdateBtn" name="boardLsjUpdateBtn" class="btn">
						<input type="button" value="삭제" id="boardLsjDeleteBtn" name="boardLsjDeleteBtn" class="btn">
						<input type="button" value="게시판목록" id="boardLsjSelectAllBtn" name="boardLsjSelectAllBtn" class="btn">
						<!-- <input type="reset" value="다시" id="retry" class="btn"> -->
					</td>
				</tr>
				<!-- //tr -->
			</table>	
		</form>
	</body>
</html>