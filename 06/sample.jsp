<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Human" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sample JSP</title>
</head>
<body>
	<% for(int i = 0; i < 10; i++) { %>
	<p>こんにちは。</p>
	<% }
		int x = 80;
		Human h = new Human("高橋", 30);
	%>
	<p>年齢は<%=x %>です。</p>
	<p>年齢は<%=h.getAge() %>です。</p>
	<a href="SecondServlet">次へ</a>
</body>
</html>