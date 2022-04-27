<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/04/2022
  Time: 7:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
<h1>Sandwich condiments</h1>
<form action="/sandwich/order" method="post">
    <input type="checkbox" value="Lettuce" name="condiments">Lettuce
    <input type="checkbox" value="Tomato" name="condiments">Tomato
    <input type="checkbox" value="Mustard" name="condiments">Mustard
    <input type="checkbox" value="Sprouts" name="condiments">Sprouts
    <br>
    <input type="submit" value="ORDER">
</form>
</body>
</html>
