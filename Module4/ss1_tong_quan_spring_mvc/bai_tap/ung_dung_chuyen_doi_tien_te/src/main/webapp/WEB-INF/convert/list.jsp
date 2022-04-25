<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22/04/2022
  Time: 11:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display all student</title>
</head>
<body>
<h1>Ứng dụng chuyển đổi tiền tệ</h1>
<form action="/convert" method="post">
    <input type="text" placeholder="điền giá trị usd cần convert" name="usd">
    <button>
        convert
    </button>
</form>
<c:choose>
    <c:when test="${usd == null}">
        <hidden><input type="hidden" value="${usd} usd = ${vnd} vnd" disabled></hidden>
    </c:when>
    <c:otherwise>
        <input type="text" value="${usd} usd = ${vnd} vnd" disabled>
    </c:otherwise>
</c:choose>

</body>
</html>
