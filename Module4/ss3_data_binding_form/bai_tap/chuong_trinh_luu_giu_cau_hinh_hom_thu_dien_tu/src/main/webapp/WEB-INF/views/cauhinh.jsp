<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/04/2022
  Time: 12:08 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>language</td>
        <th>${email.language}</th>
    </tr>
    <tr>
        <td>pageSize</td>
        <th>${email.pageSize}</th>
    </tr>
    <tr>
        <td>spamFilter</td>
        <th>${email.spamFilter ? "CÓ" : "KHÔNG"}</th>
    </tr>
    <tr>
        <td>signature</td>
        <th>${email.signature}</th>
    </tr>

</table>
</body>
</html>
