<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.mvc2.member.dao.LsjMemberDao" %>
<%@ page import = "com.mvc2.member.dao.LsjMemberDaoImpl"%>
<%
	int idCheck = (int)request.getAttribute("idCheck");
	System.out.println("	idChck >>> " + idCheck);
	
	// reset
	int idNcnt = 0;
	boolean bool = false;
	
	if(idCheck == 0){
		bool = true;
	}else {
		bool = false;
	} 
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>idCheck</title>
	</head>
	<body>
		<?xml version='1.0' encoding='UTF-8'?>
		<login>
			<result><%=idCheck %></result>
		</login>
	</body>
</html>