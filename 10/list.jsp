<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1">
		<tr>
			<th>名前</th>
			<th>学年</th>
			<th>メール</th>
			<th>性別</th>
		</tr>
	<%
	List<Student> list = (ArrayList<Student>)request.getAttribute("list");
	for(Student s : list) {
	%>
		<tr>
			<td><%=s.getName() %></td>
			<td><%=s.getGrade() %></td>
			<td><%=s.getEmail() %></td>
			<td><%=s.getGender() %></td>
		</tr>
	<%} %>
	</table>
	
	<a href="./">戻る</a>
</body>
</html>