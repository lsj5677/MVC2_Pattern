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
		<title>memberLsjSelect</title>
	</head>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.0.min.js"></script> 
	<script>
		$(function(){
			$("#selectAllBtn").click(function(){
				alert("selectAllBtn >>>>> ");
				$("#ISUD_TYPE").val("SA");
				alert("$('#ISUD_TYPE').val('SA') >>> " + $("#ISUD_TYPE").val())
				$("#memberLsjSelect").attr("action","/mvc2Pattern/member").submit();
			});	
			$("#updateBtn").click(function(){
				alert("updateBtn >>>>> ");
				$("#ISUD_TYPE").val("U");
				alert("$('#ISUD_TYPE').val('U') >>> " + $("#ISUD_TYPE").val())
				$("#memberLsjSelect").attr("action","/mvc2Pattern/member").submit();
			});	
			$("#deleteBtn").click(function(){
				alert("deleteBtn >>>>> ");
				$("#ISUD_TYPE").val("D");
				alert("$('#ISUD_TYPE').val('D') >>> " + $("#ISUD_TYPE").val())
				$("#memberLsjSelect").attr("action","/mvc2Pattern/member").submit();
			});	
			$("#boardSelectBtn").click(function(){
				alert("boardSelectBtn >>>>> ");
				$("#ISUD_TYPE").val("BSA");
				alert("$('#ISUD_TYPE').val('BSA') >>> " + $("#ISUD_TYPE").val())
				$("#memberLsjSelect").attr("action","/mvc2Pattern/member").submit();
			});	
		});
	</script>
	<body>
		<form name="memberLsjSelect" id="memberLsjSelect" method ="POST" >
		<% 

		Object obj = request.getAttribute("aList"); 
		System.out.println("obj1 >>> : " +obj);
				
		if (obj != null){
			ArrayList<LsjMemberVO> aList = (ArrayList<LsjMemberVO>) obj;
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
					<td colspan="16" align="center"><h3>회원정보  </h3></td>
				</tr>	
				<tr>
					<td class="info_title"><input type="checkbox" name="chkAll" id="chkAll"></td>
				 	<td class="info_title">회원번호</td>
					<td class="info_title">아이디</td>
					<td class="info_title">비밀번호</td>
					<td class="info_title">이름</td>
					<td class="info_title">성별</td>
					<td class="info_title">생년월일</td>
					<td class="info_title">이메일</td>
					<td class="info_title">핸드폰</td>
					<td class="info_title">우편번호</td>
					<td class="info_title">주소</td>
					<td class="info_title">회원사진</td>
					<td class="info_title">삭제여부</td>
					<td class="info_title">등록일</td>
					<td class="info_title">수정일</td>
				</tr>
			 		
		<% 		for(int i =0; i<aList.size(); i++){  
					LsjMemberVO lvo = aList.get(i);
					System.out.println("사진경로>>> : "+ "../upload/"+ lvo.getLimage());
		%>
				<tr>
				 <td class="info_con"><input type="checkbox" name="chkInLmem" id="chkInLmem"  
												value="<%= lvo.getLmem() %>"></td>    
				<td class="info_con"><%=lvo.getLmem() %></td>
				<td class="info_con"><%=lvo.getLid() %></td>
				<td class="info_con"><%=lvo.getLpw() %></td>
				<td class="info_con"><%=lvo.getLname() %></td>
				<td class="info_con"><%=lvo.getLgender() %></td>
				<td class="info_con"><%=lvo.getLbirth() %></td>
				<td class="info_con"><%=lvo.getLemail() %></td>
				<td class="info_con"><%=lvo.getLhp() %></td>
				<td class="info_con"><%=lvo.getLpostno() %></td>
				<td class="info_con"><%=lvo.getLaddr() %></td>
				<td><img src = "./upload/<%=lvo.getLimage()%>" border=0 width="150" height="100"></td>
				<td class="info_con"><%=lvo.getLdeleteyn() %></td>
				<td class="info_con"><%=lvo.getLinsertdate() %></td>
				<td class="info_con"><%=lvo.getLupdatedate() %></td>		
				</tr>
				
		<%			} //for끝
				} //aList.size if 끝
			}//object if 끝%>
				<!-- tr -->
				<tr>
					<td colspan="16" class="info_button">
						<input type="hidden" id="ISUD_TYPE" name="ISUD_TYPE">
						<input type="button" value="전체조회" id="selectAllBtn" name="selectAllBtn" class="btn">
						<input type="button" value="수정" id="updateBtn" name="updateBtn" class="btn">
						<input type="button" value="삭제" id="deleteBtn" name="deleteBtn" class="btn">
						<input type="button" value="게시판목록" id="boardSelectBtn" name="boardSelectBtn" class="btn">
					</td>
				</tr>
				<!-- //tr -->
			</table>	
		</form>
	</body>
</html>