<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ResultServlet" method="get">
		名前：<input type="text" name="name"><br>
		男<input type="radio" name="gender" value="0">
		女<input type="radio" name="gender" value="1"><br>
		<input type="hidden" name="time" value="<%= System.currentTimeMillis() %>">
		<select name="from">
		<option>岩手県</option>
		<option>青森県</option>
		<option>秋田県</option>
		</select>
		<input type="submit" value="送信">
	</form>
	<%int x = 0; %>
	<a href="ResultServlet?name=takahashi&gender=<%=x %>">こちらをクリック</a>
</body>
</html>