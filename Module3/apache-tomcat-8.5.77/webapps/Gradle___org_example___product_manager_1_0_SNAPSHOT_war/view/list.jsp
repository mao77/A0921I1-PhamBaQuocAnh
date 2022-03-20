<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20/03/2022
  Time: 5:19 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Products</h1>
<p>
    <a href="/products?action=create">Create new product</a>
</p>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Producer</td>
    </tr>
<%--    <c:forEach items='${products}' var="product">--%>
<%--        <tr>--%>
<%--            <td><a href="/customers?action=view&id=${product.getId()}">${product.getName()}</a></td>--%>
<%--            <td>${product.getName()}</td>--%>
<%--            <td>${product.getPrice()}</td>--%>
<%--            <td>${product.getDescription()}</td>--%>
<%--            <td>${product.getProducer()}</td>--%>
<%--            <td><a href="/customers?action=edit&id=${product.getId()}">edit</a></td>--%>
<%--            <td><a href="/customers?action=delete&id=${product.getId()}">delete</a></td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
</table>
</body>
</html>
