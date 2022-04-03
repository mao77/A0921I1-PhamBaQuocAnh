<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="users?action=users">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    SEARCH USER BY COUNTRY
                </h2>
            </caption>
            <tr>
                <th>User Country:</th>
                <td>
                    <input type="text" name="country" size="45">
                </td>
            </tr>
        </table>
        <input type="submit" value="FIND">
    </form>
</div>
</body>
</html>