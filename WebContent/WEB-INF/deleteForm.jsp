<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	
	String no = request.getParameter("no");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="./gb">
	<input type="hidden" name="action" value="delete">
	<p>비밀번호
		<input type="password" name="pwd" value="">
		<input type="hidden" name="no" value="<%= no%>">
		<input type="submit" value="확인">
		<a href="./gb?action=addList">메인으로 돌아가기</a>
	</p>
</form>
</body>
</html>