<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
</head>
<body>
	<h1>学生登録画面</h1>
	<form action="RegisterStudentServlet" method="post">
		名前：<input type="text" name="name"><br>
		学年：<input type="text" name="grade"><br>
		メール：<input type="email" name="email"><br>
		性別：
		<input type="radio" name="gender" value="0">男
		<input type="radio" name="gender" value="1">女<br>
		<input type="submit" value="登録">
	</form>
</body>
</html>