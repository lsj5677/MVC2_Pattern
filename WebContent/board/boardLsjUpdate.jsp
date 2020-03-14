<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mvc2.board.dao.LsjBoardDao" %>
<%@ page import="com.mvc2.board.dao.LsjBoardDaoImpl" %>
<%@ page import="com.mvc2.board.vo.LsjBoardVO" %>
<%@ page import="java.util.ArrayList" %>  

<%@ page import= "com.mvc2.common.utils.FilePath" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	Object obj = request.getAttribute("aList");
	ArrayList<LsjBoardVO> aList = (ArrayList<LsjBoardVO>)obj;
	int lCnt = aList.size();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>boardLsjUpdate</title>
		<script type="text/javascript"
				src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script>
			$(function(){
				$("#boardLsjSelectAllBtn").click(function(){
					alert("boardLsjSelectAllBtn >>>>> ");
					$("#ISUD_TYPE").val("BSA");
					alert("BSA >>> " + $("#ISUD_TYPE").val());
					$("#boardLsjUpdate").attr("action","/mvc2Pattern/board").submit();
				});	
				$("#boardLsjUpdateBtn").click(function(){
					alert("boardLsjUpdateBtn >>>>> ");
					$("#ISUD_TYPE").val("BUOK");
					alert("BUOK >>> " + $("#ISUD_TYPE").val())
					$("#boardLsjUpdate").attr("action","/mvc2Pattern/board").submit();
				});	
			});
		</script>
	</head>
	<body>
		<div class="wrap">
			<form name="boardLsjUpdate" method="POST" id="boardLsjUpdate" enctype="multipart/form-data">
				<%
					if(obj!=null){
					
					if(1>=lCnt){
						for(int i=0; i<lCnt; i++){
							LsjBoardVO lvo = aList.get(i);
					
				%>
				<table class="table" border="1">
					<tr>
						<td colspan="2" class="table_title">
							게시판 글 수정
						</td>
					</tr>
					<tr>
						<td class="info_title">회원번호</td>
						<td class="info_input">
							<input type="text" name="lno" id="lno" value=<%=lvo.getLno() %> readonly>
						</td>
					</tr>
					<tr>
						<td class="info_title">제목</td>
						<td class="info_input"><input type="text" name="lsubject" id="lsubject" placeholder="제목을 입력하세요" value=<%=lvo.getLsubject() %> ></td>
					</tr>
					<tr>
						<td class="info_title">이름</td>
						<td class="info_input"><input type="text" name="lname" id="lname" placeholder="이름를 입력하세요" value=<%=lvo.getLname() %> readonly ></td>
					</tr>
					<tr>
						<td class="info_title">비밀번호</td>
						<td class="info_input"><input type="password" name="lpw" id="lpw" placeholder ="비밀번호를 입력하세요" value=<%=lvo.getLpw() %>></td>
					</tr>
					<tr>
						<td class="info_title">내용</td>
						<td class="info_input">
							<textarea name="lmemo" id="lmemo" placeholder="내용을 입력하세요" value=<%=lvo.getLmemo() %>></textarea>
						</td>
					</tr>
					<tr>
						<td class="info_title">첨부파일</td>
						<td class="info_input"><input type="file" name="limage" id="limage"></td>
					</tr>
					<tr>
						<td class="info_title">현재파일</td>
						<td class="info_input"><img src = "./upload/<%=lvo.getLimage()%>" border=0 width="100%" height="100" readonly></td>
					</tr>
					<%
							}
					%>
					<tr>
						<td colspan="2" class="info_button">
							<input type="hidden" id="ISUD_TYPE" name="ISUD_TYPE">
							<input type="button" value="수정" id="boardLsjUpdateBtn" name="boardLsjUpdateBtn" class="btn">
							<input type="button" value="게시판목록" id="boardLsjSelectAllBtn" name="boardLsjSelectAllBtn" class="btn">
							<input type="reset" value="다시 입력" id="retry" class="btn">
						</td>
					</tr>
				</table>
			</form>
			<%
			
				}else{
					
			%>
			<script>
				alert("수정할 데이터가 없습니다");
			</script>
			<%
					}
				}
			%>
		</div>
	</body>
</html>