<%@page import="com.test.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EditProduct</title>
</head>
<body>

		<%
			Product pr = (Product)application.getAttribute("data");
		
		   
		
		%>
		
		

		<h1 align="center">Edit Product</h1>
	<center>	
		<form action="EditProduct" method="post">
			
			ID:<input type="text" name = "id" value="<%= pr.getId() %>" readonly="readonly"><br><br>
			Name : <input type = "text" name = "name" value="<%= pr.getP_name() %>"><br><br>		
			Brand : <input type = "text" name = "brand" value="<%= pr.getP_brand() %>"><br><br>
			Price : <input type = "text" name = "price" value="<%= pr.getP_price() %>"><br><br>
			
					<input type = "submit" value="update">
		</form>
	</center>
</body>
</html>