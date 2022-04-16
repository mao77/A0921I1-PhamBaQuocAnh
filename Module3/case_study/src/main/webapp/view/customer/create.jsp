<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 3/23/2022
  Time: 6:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Them moi</title>
</head>
<body>
<center>
<h1>ADD NEW CUSTOMER</h1>
<c:if test="${mess!=null}">
    <p>${mess}</p>
</c:if>

<form action="/customers?action=add" method="post">
    <table>
        <%--        <tr>--%>
        <%--            <td>ID</td>--%>
        <%--            <td><input type="text" name="id" placeholder="nhâp id"></td>--%>
        <%--        </tr>--%>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" placeholder="nhâp tên"></td>
        </tr>
        <tr>
            <td>Customer Type</td>
            <td>
                <select name="customerTypeId">
                    <c:forEach items="${customerTypeList}" var="customerType">
                        <option value="${customerType.id}">${customerType.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
            <tr>
            <td>Gender</td>
            <td>
                <input type="radio" name="gender" value="true"> nam
                <input type="radio" name="gender" value="false">nữ
            </td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td><input type="date" name="birthday"></td>
        </tr>
            <tr>
                <td>ID Card</td>
                <td><input type="text" name="idCard"></td>
            </tr>
            <tr>
                <td>Phone</td>
                <td><input type="text" name="phone"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" placeholder="nhập email"></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit">ADD</button>
                </td>
            </tr>
        <%--        <tr>--%>
        <%--            <td>Account</td>--%>
        <%--            <td><input type="text" name="account" placeholder="nhập account"></td>--%>
        <%--        </tr>--%>

    </table>

</form>
</center>
</body>
</html>
