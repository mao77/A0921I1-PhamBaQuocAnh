<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20/03/2022
  Time: 5:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Products</h1>
<p>
    <a href="products?action=create">Create new product</a>
</p>
<table border="1">
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>PRICE</td>
        <td>DESCRIPTION</td>
        <td>PRODUCER</td>
    </tr>
    <c:forEach items='${productList}' var="product">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getProducer()}</td>
            <td><a href="/products?action=edit&id=${product.getId() - 1}">edit</a></td>
            <td><a href="/products?action=delete&id=${product.getId() - 1}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
