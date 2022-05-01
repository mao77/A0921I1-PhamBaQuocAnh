<%@ taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/04/2022
  Time: 4:40 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Họ và Tên</td>
        <td>Giới tính</td>
        <td>Quốc tịch</td>
        <td>CMND</td>
        <td>Lịch sử di chuyển</td>
    </tr>
    <c:forEach items="${medicalDeclarationList}" var="medicalDeclaration">
        <tr>
            <td>${medicalDeclaration.id}</td>
            <td>${medicalDeclaration.name}</td>
            <td>${medicalDeclaration.sex ? "Nam" : "Nữ"}</td>
            <td>${medicalDeclaration.country}</td>
            <td>${medicalDeclaration.country}</td>
            <td>
            <c:forEach items="${medicalDeclaration.travelInformation}" var="travelInformation">
                <c:out value="${travelInformation}"></c:out>
            </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>

    <a href="/medicalDeclaration/create">create new medical declaration</a>

</body>
</html>
