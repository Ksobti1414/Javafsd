<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
    <%@ page import="com.test.User" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1" width="50%">
	<tr>
	<th>Id</th>
	<th>FullName</th>
	<th>UserName</th>
	<th>Password</th>
	<th>Action</th>
	</tr>
	<tbody>
	<c:forEach var="obj" items="${info}">
	<tr>
	<td>${obj.getId()}</td>
	<td>${obj.getFname()}</td>
	<td>${obj.getUsername()}</td>
	<td>${obj.getPassword()}</td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	<%

%>
</body>
</html>