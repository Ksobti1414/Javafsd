
<%@ page import="java.util.*,com.test.dao.*,com.test.model.*" %>
<%ProductDao dao=new ProductDaoImpl();
List<Product>list=dao.listallproducts();
%>
<html>
<body>
<h2>Add product</h2>
<form action="ProductServlet" method="post">
Name : <input type="text" name="name"><br>
Brand: <input type="text" name="brand"><br>
Price: <input type="text" name="price"><br>
<input type="submit" value="Save"/>
</form>
<h2>Product List</h2>
<table border="1">
<tr>
<th>Id</th>
<th>Name</th>
<th>Brand</th>
<th>Price</th>
<th>Action</th>
</tr>
<%
for(Product p:list){
%>
<tr>
<td><%=p.getId() %></td>
<td><%=p.getName() %></td>
<td><%=p.getB_name() %></td>
<td><%=p.getPrice() %></td>
<td>
<a href="ProductServlet?action=delete&id=<%=p.getId() %>">Delete</a>
</td>
</tr>
<%
}%>
</table>
</body>
</html>
