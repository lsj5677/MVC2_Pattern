<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>boardLsjInsertForm</title>
		<script type="text/javascript"
				src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script>
			$(function(){
				$("#boardLsjInsertBtn").click(function(){
					alert("boardLsjInsertBtn >>>>> ");
					$("#ISUD_TYPE").val("BI");
					 if(getTextLength($('.lcontent').val()) > 80){
		                alert("문자는 300바이트 이하로 적어 주세요.");
		                $("#lmemo").focus();
		                return false;
		            }else{
		                alert("문자가 300바이트 이하입니다.");
		            }
					alert("BI >>> " + $("#ISUD_TYPE").val())
					$("#boardInsertForm").attr("action","/mvc2Pattern/board").submit();
				});
				
		/* 		$("#limage").keydown(function(e){ 
					if(e.keyCode == 13){ $("#boardForm").submit(); // limage 입력부분에서 엔터를 치면 submit 실행 } });
				} */
				

			});
			 function getTextLength(str) {
			        var len = 0;
			        for (var i = 0; i < str.length; i++) {
			            if (escape(str.charAt(i)).length == 6) {
			                len++;
			            }
			            len++;
			        }
			        return len;
			    }

			    function cut_300(obj){
			        var text = $(obj).val();
			        var leng = text.length;
			        while(getTextLength(text) > 300){
			            leng--;
			            text = text.substring(0, leng);
			        }
			        $(obj).val(text);
			        $('.bytes').text(getTextLength(text));
			    }
		</script>
	</head>
	<body>
		<div class="wrap">
			<form name="boardInsertForm" method="POST" id="boardInsertForm" enctype="multipart/form-data">
				<table class="table" border="1">
					<tr>
						<td colspan="2" class="table_title">
							게시판 글쓰기
						</td>
					</tr>
					<tr>
						<td class="info_title">제목</td>
						<td class="info_input"><input type="text" name="lsubject" id="lsubject" placeholder="제목을 입력하세요"></td>
					</tr>
					<tr>
						<td class="info_title">이름</td>
						<td class="info_input"><input type="text" name="lname" id="lname" placeholder="이름를 입력하세요"></td>
					</tr>
					<tr>
						<td class="info_title">비밀번호</td>
						<td class="info_input"><input type="password" name="lpw" id="lpw" placeholder ="비밀번호를 입력하세요"></td>
					</tr>
					<tr>
						<td class="info_title">내용</td>
						<td class="info_input">
							<textarea name="lmemo" id="lmemo" cols="30" rows="10" class="lcontent" placeholder="내용을 입력하세요">
							</textarea>
								<span class="bytes"></span>
						</td>
					</tr>
					<tr>
						<td class="info_title">첨부파일</td>
						<td class="info_input"><input type="file" name="limage" id="limage"></td>
					</tr>
					<tr>
						<td colspan="2" class="info_button">
							<input type="hidden" name="ISUD_TYPE" class="btn" id="ISUD_TYPE">
							<input type="button" value="입력" class="btn" id="boardLsjInsertBtn" name="boardLsjInsertBtn">
							<input type="reset" value="다시 입력" id="retry" class="btn">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>