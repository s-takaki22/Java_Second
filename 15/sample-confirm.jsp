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
	<%
		SampleConfirm form = (SampleConfirm)session.getAttribute("input_data");
	%>
	<p>下記のデータを登録します。よろしいですか？</p>
	名前：<%=form.getName() %><br>
	年齢：<%=form.getAge() %><br>
	メール：<%=form.getMail() %><br>
	<a href="SampleRegisterServlet">OK</a><br>
	<a href="SampleFormServlet">戻る</a>
</body>
</html>