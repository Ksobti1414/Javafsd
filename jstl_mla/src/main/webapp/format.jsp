<%@page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
      <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="today" value="<%= new Date()%>"></c:set>
<p>Time:<Strong><fmt:formatDate type="time" value="${today}"/></Strong></p><br>
<p>Date:<Strong><fmt:formatDate type="date" value="${today}"/></Strong></p><br>
<p>Date &amp;:<Strong><fmt:formatDate type="both" value="${today}"/></Strong></p><br>
</body>
</html>