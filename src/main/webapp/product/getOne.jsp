<%@ page import="com.introjee.service.ProductService" %>
<%@ page import="com.introjee.models.Product" %><%--
  Created by IntelliJ IDEA.
  User: JAVA
  Date: 12-07-22
  Time: 14:01
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
     String id = request.getParameter("id");
     if(id == null) {
         response.setStatus(400);
         return;
     }
     Product product = service.getOne(Integer.parseInt(id));
     if(product == null) {
         response.setStatus(404);
         return;
     }
 %>
<h1>Detail d'un produit</h1>

 <div>
     <p><span>id: </span> <%= product.getId() %> </p>
     <p><span>nom: </span> <%= product.getName() %> </p>
     <p><span>marque: </span> <%= product.getBrand() %> </p>
     <p><span>categorie: </span> <%= product.getCategory() %> </p>
     <p><span>prix: </span> <%= product.getPrice() %> € </p>
 </div>
</body>
</html>
