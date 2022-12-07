<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>入力内容</h3>
	<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	int gen = Integer.parseInt(gender);
	String genderStr = gen == 0 ? "男" : "女";
	%>
	名前：<%=name %> <br>
	性別：<%=genderStr %>
</body>
</html>