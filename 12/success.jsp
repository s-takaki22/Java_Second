<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録成功</title>
</head>
<body>
	<h3>登録成功</h3>
	<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	%>
	<p style="color:blue"><%=name %>さんの登録に成功しました。
</body>
</html>