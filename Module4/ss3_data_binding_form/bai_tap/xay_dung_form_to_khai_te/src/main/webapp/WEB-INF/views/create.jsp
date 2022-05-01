<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/04/2022
  Time: 5:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>CREAT NEW MEDICAL DECLARATION</h1>
    <form:form action="/medicalDeclaration/create" method="post" modelAttribute="medicalDeclaration">
        <h5>Họ Tên:</h5>
        <form:input path="name"></form:input>
        <h5>Giới Tính</h5>
        <form:radiobutton path="sex" value="true"></form:radiobutton>Nam
        <form:radiobutton path="sex" value="false"></form:radiobutton>Nữ
        <h5>Quốc tịch</h5>
        <form:input path="country"></form:input>
        <h5>CMND</h5>
        <form:input path="passport"></form:input>
        <h5>Thông tin di chuyển</h5>
        <form:radiobuttons path="travelInformation" items="${travelInformations}"></form:radiobuttons>
        <br>
        <input type="submit" value="CREATE">
    </form:form>
</center>

</body>
</html>
