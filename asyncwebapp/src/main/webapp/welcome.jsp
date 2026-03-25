<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.security.Principal" %>
    <%@ page import="java.util.*" %>
    <%@ page import="javax.security.auth.Subject" %>
    <%
    Subject subject=(Subject) session.getAttribute("subject");
    if(subject==null){
    	response.sendRedirect("login.jsp"); 
    	return;
    }
    Set<Principal> principals=subject.getPrincipals();
    String username=(String)session.getAttribute("username");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome...<%= username %></h1>
<p>Your Roles:</p>
<ul>
<%
 for(Principal p:principals){
	 if(p.getName().equals(username)){
		 out.println("<li>"+p.getName()+"</li>");
	 }
 }
%></ul>
</body>
</html>