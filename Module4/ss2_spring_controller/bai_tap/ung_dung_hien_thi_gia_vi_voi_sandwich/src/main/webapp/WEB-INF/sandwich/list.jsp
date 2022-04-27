<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/04/2022
  Time: 8:11 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich condiments</h1>
<h3>Các gia vị được chọn</h3>
<table>
<c:forEach items="${condiments}" var="condiment">
    <tr>
        <td>${condiment}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
