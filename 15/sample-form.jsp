<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.SampleConfirm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>登録画面</h3>
	<form action="SampleConfirmServlet" method="post">
		名前：<input type="text" name="name"><br>
		年齢：<input type="number" name="age"><br>
		メール：<input type="email" name="email"><br>
		<input type="submit" value="送信">
	</form>
</body>
</html>