<%@ page import="com.introjee.service.ProductService" %><%--
  Created by IntelliJ IDEA.
  User: JAVA
  Date: 12-07-22
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Formulaire</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%! ProductService service = ProductService.getInstance(); %>

<h1>Formulaire d'ajout d'un produit</h1>
<%--<form action="">--%>
<%--    <input type="text" name="id" placeholder="id"><br/>--%>
<%--    <input type="text" name="nom" placeholder="nom"><br/>--%>
<%--    <input type="text" name="marque" placeholder="marque"><br/>--%>
<%--    <input type="text" name="category" placeholder="category"><br/>--%>
<%--    <input type="text" name="price" placeholder="price"><br/>--%>
<%--    <input type="submit" value="envoyer">--%>
<%--</form>--%>


<form class="row g-3 w-50 " action="../add" method="post">
    <div class="col-12">
        <label for="name" class="form-label">Nom</label>
        <input type="text" class="form-control" name="name" id="name" placeholder="(ex: ordinateur)">
    </div>
    <div class="col-12">
        <label for="brand" class="form-label">Marque</label>
        <input type="text" class="form-control" name="brand" id="brand" placeholder="(ex: hp)">
    </div>
    <div class="col-12">
        <label for="category" class="form-label">Categorie</label>
        <input type="text" class="form-control" name="category" id="category" placeholder="(ex: multimedia)">
    </div>
    <div class="input-group">
        <input type="number" class="form-control" name="price" id="price" placeholder="(ex: 400)">
        <div class="input-group-text">€</div>
    </div>

    <div class="col-6">
        <a href="<%= request.getContextPath() %>"  class="btn btn-primary">retour</a>
    </div>
    <div class="col-6">
        <button type="submit" class="btn btn-primary">ajouter</button>
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
