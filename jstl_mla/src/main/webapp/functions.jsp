<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.functions" prefix="fn" %>
      <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Functions Tags</h1>
<c:set value="Spring framework is frameworks of Framework and support AI" var="data"></c:set>
<c:out value="${data}"></c:out>
<c:if test="${fn:contains(data,'supports')}">
<p>In data variable contains<b>supports</b>keyword</p>
</c:if>
<c:if test="${fn:containsIgnoreCase(data,'spring')}">
<p>In data variable contains <b>spring</b> keyword</p>
</c:if>
</body>
</html>