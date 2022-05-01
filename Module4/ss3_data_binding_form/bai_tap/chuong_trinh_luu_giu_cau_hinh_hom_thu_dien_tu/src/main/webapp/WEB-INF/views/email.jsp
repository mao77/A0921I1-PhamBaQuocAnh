<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/04/2022
  Time: 10:40 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/email/update" method="post" modelAttribute="email">
    <table>
        <tr>
            <td>language</td>
            <th>
                <form:select path="language" items="${languages}"></form:select>
            </th>
        </tr>
        <tr>
            <td>pageSize</td>
            <th>
                <form:select path="pageSize" items="${pageSizes}"></form:select>
            </th>
        </tr>
        <tr>
            <td>spamFilter</td>
            <th>
<%--                <form:radiobutton path="spamFilter" value="true" ></form:radiobutton>YES--%>
<%--                <form:radiobutton path="spamFilter" value="false"></form:radiobutton>NO--%>
                <form:checkbox path="spamFilter" value=""></form:checkbox>
            </th>
        </tr>
        <tr>
            <td>Signature</td>
            <th>
                <form:input path="signature"></form:input>
            </th>
        </tr>
        <tr>
            <td>
                <input type="submit" value="UPDATE">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
