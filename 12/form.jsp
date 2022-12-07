<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
</head>
<body>
	<h1>教員登録画面</h1>
	<form action="RegisterTeacherServlet" method="post">
		名前：<input type="text" name="name"><br>
		年齢：<input type="number" name="age"><br>
		<input type="submit" value="登録">
	</form>
</body>
</html>