<%@page import="java.util.List" %>
<%@page import="java.util.Arrays" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL Core Tags</h1>
<c:forEach var="a" begin="1" end="10">
<c:out value="${a}"></c:out>
</c:forEach>
<%
List<String> listNames=new Arrays.asList("Rohit","Virat","KlRahul","AxarPatel","Bumrah");
application.setAttribute("names",listNames);
%>
<c:forEach items="${listNames} var="names">
<ul>
<p>${names}</p><br>
</ul>
</c:forEach>
</body>
</html>