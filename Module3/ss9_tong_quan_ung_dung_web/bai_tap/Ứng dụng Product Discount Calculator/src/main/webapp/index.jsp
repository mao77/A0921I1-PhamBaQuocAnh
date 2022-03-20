<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/03/2022
  Time: 1:25 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Currency Converter</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Product Discount Calculator</h2>
<form method="post" action="/display-discount">
  <label>Product Description: </label><br/>
  <input type="text" name="productDescription" placeholder="Product Description"/><br/>
  <label>List Price: </label><br/>
  <input type="text" name="listPrice" placeholder="USD" value="0"/><br/>
  <label>Discount Percent(%): </label><br/>
  <input type="text" name="discountPercent"  value="0"/><br/>
  <input type = "submit" id = "submit" value = "Calculate Discount"/>
</form>
</body>
</html>
