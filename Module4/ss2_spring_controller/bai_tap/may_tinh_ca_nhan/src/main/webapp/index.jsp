<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/04/2022
  Time: 8:33 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Calculator</h1>
  <form action="/calculator" method="get">
    <input type="text" name="operand1">
    <input type="text" name="operand2">
    <br>
    <input type="submit" value="Add(+)" name="operator">
    <input type="submit" value="Sub(-)" name="operator">
    <input type="submit" value="Multi(*)" name="operator">
    <input type="submit" value="Div(/)" name="operator">
  </form>

  </body>
</html>
