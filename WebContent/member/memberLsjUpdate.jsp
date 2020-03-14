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
		<title>memberLsjUpdate</title>
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script>
			$(function(){
				$("#updateBtn").click(function(){
					alert("updateBtn >>>>> ");
					$("#ISUD_TYPE").val("UOK");
					alert("$('#ISUD_TYPE').val('UOK') >>> " + $("#ISUD_TYPE").val())
					$("#memberUpdateForm").attr("action","/mvc2Pattern/member").submit();
				});	
				$("#selectBtn").click(function(){
					alert("selectBtn >>>>> ");
					$("#ISUD_TYPE").val("S");
					alert("$('#ISUD_TYPE').val('S') >>> " + $("#ISUD_TYPE").val())
					$("#memberUpdateForm").attr("action","/mvc2Pattern/member").submit();
				});	
				$('#lpostno').click(function(){
					sample4_execDaumPostcode();
				});
			});
			
			function sample4_execDaumPostcode() {
		        new daum.Postcode({
		            oncomplete: function(data) {
		                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

		                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
		                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
		                var roadAddr = data.roadAddress; // 도로명 주소 변수

		                // 우편번호와 주소 정보를 해당 필드에 넣는다.
		                document.getElementById('lpostno').value = data.zonecode;
		                document.getElementById("laddr").value = roadAddr;
		            }
		        }).open();
		    }
		</script>
	</head>
	<body>
		<!-- form -->
			<form id="memberUpdateForm" name="memberUpdateForm" method="POST" enctype="multipart/form-data">
				<%
					Object obj = request.getAttribute("aList");
					ArrayList<LsjMemberVO> aList = (ArrayList<LsjMemberVO>)obj;
					int lCnt = aList.size();
					
					if(obj!=null){
					
					if(1>=lCnt){
						for(int i=0; i<lCnt; i++){
							LsjMemberVO lvo = aList.get(i);
					
				%>
				<!-- table -->
				<table class="table" border="1">
					<tr>
						<td class="info_title" colspan="3">회원정보수정</td>						
					</tr>
					<tr>
						<td rowspan="6" class="info_title"><img src = "./upload/<%=lvo.getLimage()%>" border=0 width="150" height="100" readonly></td>
						<td class="info_title">회원번호</td>
						<td class="info_input">
							<input type="text" name="lmem" id="lmem" value="<%=lvo.getLmem() %>" readonly>
						</td>
					</tr>
					
					<tr>
						<td class="info_title">아이디</td>
						<td class="info_input">
							<input type="text" name="lid" id="lid" placeholder="아이디를 입력하세요" value="<%=lvo.getLid() %>" readonly>
						</td>
					</tr>
					<!-- tr -->
					<tr>
						<td class="info_title">비밀번호</td>
						<td class="info_input"><input type="password" name="lpw" id="lpw" placeholder="비밀번호를 입력하세요" value="<%=lvo.getLpw() %>"/></td>
					</tr>
					<!-- //tr -->
					<!-- tr -->
					<tr>
						<td class="info_title">이름</td>
						<td class="info_input"><input type="text" name="lname" id="lname" placeholder="이름을 입력하세요" value="<%=lvo.getLname() %>" /></td>
					</tr>
					<!-- //tr -->
					<!-- //tr -->
					<tr>
						<td class="info_title">성별</td>
						<td class="info_input">
						<input type="text" name="lgender" id="lgender" placeholder="M or F"  value="<%=lvo.getLgender() %>" readonly/>
						</td>
					</tr>
					<!-- //tr -->
					<!-- tr -->
					<tr>
						<td class="title info_title">생년월일</td>
						<td class="info_input">
							<input type="text" name="lbirth" placeholder="YYMMDD" value="<%=lvo.getLbirth() %>" readonly>
						</td>
					</tr>
					<!-- //tr -->
					<!-- tr -->
					<tr>
						<td class="info_title">이메일</td>
						<td colspan="2" class="info_input">
						<input type="text" name="lemail" placeholder="이메일을 입력하세요" value="<%=lvo.getLemail() %>">
						</td>
					</tr>
					<!-- //tr -->
					<!-- tr -->
					<tr>
						<td class="info_title">휴대폰번호</td>
						<td colspan="2" class="info_input">
						<input type="text" name="lhp" placeholder="하이픈 없이 입력하세요" value="<%=lvo.getLhp() %>">
						</td>
					</tr>
					<!-- //tr -->
					<tr>
						<td class="info_title">우편번호</td>
						<td  colspan="2" class="info_input">
							<input type="text" id="lpostno" class="postno" name="lpostno" placeholder="우편번호" value="<%=lvo.getLpostno() %>">
							<input type="button" class="btn" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
							
						</td>
					</tr>
					<tr>
						<td class="info_title">주소</td>
						<td  colspan="2" class="info_input">
							<input type="text" name="laddr" id="laddr" placeholder="도로명주소" value="<%=lvo.getLaddr() %>" >
						</td>
						
					</tr>
					<%
							}
					%>
					<tr>
						<td colspan="3" class="info_button">
							<input type="hidden" id="ISUD_TYPE" name="ISUD_TYPE">
							<input type="button" value="수정" id="updateBtn" name="updateBtn" class="btn">
							<input type="button" value="목록" id="selectBtn" name="selectBtn" class="btn">
						</td>
					</tr>
					<!-- //tr -->
				</table>
				<!-- //table -->
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
	</body>
</html>