<%@page import="com.javaex.vo.GuestBookVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<GuestBookVo> list = (List<GuestBookVo>)request.getAttribute("guestList");
	System.out.println(list.toString());
	System.out.println("addList 출력!");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="./gb">
		<input type="hidden" name="action" value="insert">
		<table border="1" width="510">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" value=""></td>
			</tr>	
			<tr>
				<td colspan="4"><textarea rows="10" cols="60" name="content"></textarea></td>
			</tr>	
			<tr>
				<td colspan="4"><input type="submit" value="확인"></td>
			</tr>
		</table><br>
	</form>
	<% for(GuestBookVo vo : list) {%>
	<table border="1" width="510">
		<tr>
			<td>[<%= vo.getNo() %>]</td>
			<td><%= vo.getName() %></td>
			<td><%= vo.getReg_date() %></td>
			<td><a href="./gb?action=deleteForm&no=<%= vo.getNo() %>">삭제</a></td>
		</tr>
		<tr>
			<td colspan="4"><%= vo.getContent() %></td>
		</tr>
	</table><br>
	<%} %>
</body>
</html>