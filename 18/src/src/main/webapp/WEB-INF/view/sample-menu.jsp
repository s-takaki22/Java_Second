<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Account" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Account ac = (Account)session.getAttribute("user");
	%>
	<h3>就活管理システム</h3>
	<p>ようこそ<%=ac.getName() %>さん</p>
	<a href="RegisterCompanyServlet">新規受験企業登録</a><br>
	<a href="ListCompanyServlet">受験企業状況一覧</a><br>
	<a href="DeleteCompanyServlet">受験企業削除</a><br>
	<a href="UpdateCompanyServlet">受験状況更新</a><br>
	<a href="LogoutServlet">ログアウト</a>
</body>
</html>