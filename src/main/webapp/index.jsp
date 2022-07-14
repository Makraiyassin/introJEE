<%@ page import="com.introjee.service.ProductService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<%!ProductService service = ProductService.getInstance();%>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="product/getAll.jsp">liste de produits</a>
<br/>
<a href="product/addProduct.jsp">ajouter un produit</a>

</body>
</html>
