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
    <title>Title</title>
</head>
<body>
<%! ProductService service = ProductService.getInstance(); %>

<h1>Formulaire d'ajout d'un produit</h1>
<form action="">
    <input type="text" name="id" placeholder="id">
    <input type="text" name="nom" placeholder="nom">
    <input type="text" name="marque" placeholder="marque">
    <input type="text" name="category" placeholder="category">
    <input type="text" name="price" placeholder="price">
    <input type="submit" value="envoyer">
</form>


</body>
</html>
