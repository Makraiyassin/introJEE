<%@ page import="com.introjee.service.ProductService" %>
<%@ page import="com.introjee.models.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: JAVA
  Date: 12-07-22
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
</head>
<body>
<%! ProductService service = ProductService.getInstance(); %>
<%
    List<Product> productList = service.getAll();
    if(productList.size() == 0) {
        response.setStatus(404);
        return;
    }
%>
<h1>liste produits: </h1>


<%--<%productList.forEach(product -> {%>--%>
<%for (Product product: productList) {%>
<div>
    <p><span>id: </span> <%= product.getId() %></p>
    <p><span>nom: </span> <%= product.getName() %> </p>
    <p><span>marque: </span> <%= product.getMarque() %> </p>
    <p><span>categorie: </span> <%= product.getCategory() %> </p>
    <p><span>prix: </span> <%= product.getPrice() %> </p>
    <a href="http://localhost:8080/introJEE/product/getOne.jsp?id= <%=Integer.toString(product.getId())%>">détail</a>

</div>

<% };%>

<a href="http://localhost:8080/introJEE/">retour</a>
</body>
</html>
