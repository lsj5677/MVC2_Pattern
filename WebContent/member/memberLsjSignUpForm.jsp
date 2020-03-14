<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>memberLsjSignUpForm</title>
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script>
			$(function(){
				$('#lidCheckBtn').click(function(){
					alert("lidCheckBtn >>> ");
					
					var lidVal = $('#lid').val();
					if(!lidVal){
						alert('아이디를 입력하세요');
						$('#lid').focus();
						return false;
					}
					
					idCheck();
				}); // #lidCheckBtn click event
				
				function idCheck(){
					$.ajax({
						type : "POST",
						url : "/mvc2Pattern/member",
						data :{
							lid : $('#lid').val(),
							ISUD_TYPE : "idCheck",
						},
						success : WhenSuccess,
						error : WhenError
					});
					
					function WhenSuccess(result){
						// result tag 안에 text 찾음
						var idCheck = $(result).find("result").text();
						var result = eval(idCheck);
						
						if(result==1){
							alert("사용 가능한 아이디 입니다");
						}else{
							alert("사용중인 아이디 입니다");
						}
					}
					
					function WhenError(e){
						alert("Error >>>");
					}
				} // ajax
				
				$('#lpwCheckBtn').click(function(){
					alert('lpwCheckBtn >>> ');
					
					var lpw = $('#lpw').val();
					var lpwCheck = $('#lpwCheck').val();
					
					// 입력여부 검사
					if(!lpw){
						alert('비밀번호를 입력하세요');
						$('#lpw').focus();
						return false;
					}
					if(!lpwCheck){
						alert('비밀번호 확인란을 입력하세요');
						$('#lpwCheck').focus();
						return false;
					}
					if(lpw == lpwCheck){
						alert('비밀번호 확인 완료');
					}else{
						alert('비밀번호를 확인하세요');
						$('#lpw').val('');
						$('#lpwCheck').val('');
						$('#lpw').focus();
					}
				});// lpwCheckBtn click event
				
				// insert버튼 눌러을 때 입력여부 검사
				$('#insertBtn').click(function(){
					alert('insertBtn click >>>');
					
					if(!$('#lid').val()){
						alert('아이디를 입력하세요');
						$('#lid').focus();
						return false;
					}
					if(!$('#lpw').val()){
						alert('비밀번호를 입력하세요');
						$('#lpw').focus();
						return false;
					}
					if(!$('#lpwCheck').val()){
						alert('비밀번호 확인란을 입력하세요');
						$('#lpwCheck').focus();
						return false;
					}
					if(!$('#lname').val()){
						alert('이름을 입력하세요');
						$('#lname').focus();
						return false;
					}
					if(!$('#lgender').val()){
						alert('성별을 입력하세요');
						$('#lgender').focus();
						return false;
					}
					/*if(!$('#lbirth').val()){
						alert('생년월일을 입력하세요');
						$('#lbirth').focus();
						return false;
					} 
					if(!$('#lemail').val()){
						alert('이메일을 입력하세요');
						$('#lemail').focus();
						return false;
					}
					if(!$('#lhp').val()){
						alert('휴대폰 번호를 입력하세요');
						$('#lhp').focus();
						return false;
					}
					if(!$('#lpostno').val()){
						alert('우편번호를 입력하세요');
						$('#lpostno').focus();
						return false;
					}
					if(!$('#laddr').val()){
						alert('주소를 입력하세요');
						$('#laddr').focus();
						return false;
					}
					if(!$('#limage').val()){
						alert('사진을 첨부하세요');
						$('#limage').focus();
						return false;
					}*/
					
					$('#ISUD_TYPE').val('I');
					alert("$('#ISUD_TYPE').val('I') >>> " + $('#ISUD_TYPE').val());
					$('#memberLsjSignUpForm').attr('action','/mvc2Pattern/member').submit();
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
		                
		                document.getElementById("laddr1").focus();
		            }
		        }).open();
		    }
		</script>
	</head>
	<body>
		<!-- wrap -->
		<div class="wrap">
			<!-- form -->
			<form id="memberLsjSignUpForm" name="memberLsjSignUpForm" method="POST" enctype="multipart/form-data">
				<!-- table -->
				<table class="table" border="1">
					<!-- tr -->
					<tr>
						<td class="info_title">아이디</td>
						<td class="info_input">
							<input type="text" name="lid" id="lid" placeholder="아이디를 입력하세요" />
							<input type="button" class="btn" id="lidCheckBtn" name="lidCheckBtn" value="아이디 중복체크">
						</td>
						
					</tr>
					<!-- //tr -->
					<!-- tr -->
					<tr>
						<td class="info_title">비밀번호</td>
						<td class="info_input"><input type="password" name="lpw" id="lpw" placeholder="비밀번호를 입력하세요" /></td>
					</tr>
					<!-- //tr -->
					<tr>
						<td class="info_title">비밀번호확인</td>
						<td class="info_input">
							<input type="password" name="lpwCheck" id="lpwCheck" placeholder="비밀번호 확인" />
							<input type="button" class="btn" id="lpwCheckBtn" value="비밀번호 확인">
						</td>
					</tr>
					<!-- //tr -->
					<!-- tr -->
					<tr>
						<td class="info_title">이름</td>
						<td class="info_input"><input type="text" name="lname" id="lname" placeholder="이름을 입력하세요" /></td>
					</tr>
					<!-- //tr -->
					<!-- //tr -->
					<tr>
						<td class="info_title">성별</td>
						<td class="info_input">
							<input type="text" name="lgender" id="lgender" placeholder="M or F" />
						</td>
					</tr>
					<!-- //tr -->
					<!-- tr -->
					<tr>
						<td class="title info_title">생년월일</td>
						<td class="info_input">
							<input type="text" name="lbirth" placeholder="YYMMDD">
						</td>
					</tr>
					<!-- //tr -->
					<!-- tr -->
					<tr>
						<td class="info_title">이메일</td>
						<td class="info_input">
							<input type="text" name="lemail" placeholder="이메일을 입력하세요">
						</td>
					</tr>
					<!-- //tr -->
					<!-- tr -->
					<tr>
						<td class="info_title">휴대폰번호</td>
						<td class="info_input">
							<input type="text" name="lhp" placeholder="하이픈 없이 입력하세요">
						</td>
					</tr>
					<!-- //tr -->
					<tr>
						<td class="info_title">우편번호</td>
						<td class="info_input">
						<!-- input type="text" name="lpostno" placeholder="우편번호 5자리"-->
							<input type="text" id="lpostno" name="lpostno" placeholder="우편번호">
							<input type="button" class="btn" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
							
						</td>
					</tr>
					<tr>
						<td class="info_title">주소</td>
						<td class="info_input">
							<input type="text" name="laddr" id="laddr" placeholder="도로명주소">
							<input type="text" name="laddr1" id="laddr1" placeholder="상세주소">
							
						</td>
						
					</tr>
					<tr>
						<td class="info_title">회원사진</td>
						<td class="info_input"><input type="file" name="limage" id="limage"></td>
					</tr>
					<!-- tr -->
					<tr>
						<td colspan="2" class="info_button">
							<input type="hidden" id="ISUD_TYPE" name="ISUD_TYPE">
							<input type="button" value="가입하기" id="insertBtn" name="insertBtn" class="btn">
							<input type="reset" value="다시" id="retry" class="btn">
						</td>
					</tr>
					<!-- //tr -->
				</table>
				<!-- //table -->
			</form>
			<!-- //form -->
		</div>
		<!-- //wrap -->
	</body>
</html>