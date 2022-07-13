<%@ page import="com.introjee.service.ProductService" %>
<%@ page import="com.introjee.models.Product" %><%--
  Created by IntelliJ IDEA.
  User: JAVA
  Date: 13-07-22
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>modification</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%! ProductService service = ProductService.getInstance(); %>
<%
    Product toUpdate = (Product) request.getAttribute("product");
%>
<h1>modification produit</h1>


<form class="row g-3 w-50 " action="update" method="post">

    <input type="hidden" class="form-control" name="id" id="id" value="<%= toUpdate.getId() %>" >
    <div class="col-12">
        <label for="name" class="form-label">Nom</label>
        <input type="text" class="form-control" name="name" id="name" value="<%= toUpdate.getName() %>">
    </div>
    <div class="col-12">
        <label for="brand" class="form-label">Marque</label>
        <input type="text" class="form-control" name="brand" id="brand" value="<%= toUpdate.getBrand() %>">
    </div>
    <div class="col-12">
        <label for="category" class="form-label">Categorie</label>
        <input type="text" class="form-control" name="category" id="category" value="<%= toUpdate.getCategory() %>">
    </div>
    <div class="col-12">
        <label for="price" class="form-label">Prix</label>
        <div class="input-group">
            <input type="number" class="form-control" name="price" id="price" value="<%= toUpdate.getPrice() %>">
            <div class="input-group-text">€</div>
        </div>
    </div>

    <div class="col-6">
        <a href="<%= request.getContextPath() %>"  class="btn btn-primary">retour</a>
    </div>
    <div class="col-6">
        <button type="submit" class="btn btn-primary">modifier</button>
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>