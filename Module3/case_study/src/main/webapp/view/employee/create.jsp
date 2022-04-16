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
    <h1>ADD NEW EMPLOYEE</h1>
    <c:if test="${mess!=null}">
        <p>${mess}</p>
    </c:if>

    <form action="/employees?action=add" method="post">
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" placeholder="nhâp tên employee"></td>
            </tr>
            <tr>
                <td>Employee Birthday</td>
                <td><input type="date" name="birthday" placeholder="nhâp employee birthday"></td>
            </tr>
            <tr>
                <td>Employee Id Card</td>
                <td><input type="text" name="idCard" placeholder="nhâp employee id card"></td>
            </tr>
            <tr>
                <td>Employee Salary</td>
                <td><input type="text" name="salary" placeholder="nhâp employee salary"></td>
            </tr>
            <tr>
                <td>Employee Phone</td>
                <td><input type="text" name="phone" placeholder="nhâp employee phone"></td>
            </tr>
            <tr>
                <td>Employee Email</td>
                <td><input type="text" name="email" placeholder="nhâp employee email"></td>
            </tr>
            <tr>
                <td>Employee Address</td>
                <td><input type="text" name="address" placeholder="nhâp employee address"></td>
            </tr>
            <tr>
                <td>Position</td>
                <td>
                    <select name="positionId">
                        <c:forEach items="${positionList}" var="position">
                            <option value="${position.id}">${position.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Education Degree</td>
                <td>
                    <select name="educationDegreeId">
                        <c:forEach items="${educationDegreeList}" var="educationDegree">
                            <option value="${educationDegree.id}">${educationDegree.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Division</td>
                <td>
                    <select name="divisionId">
                        <c:forEach items="${divisionList}" var="division">
                            <option value="${division.id}">${division.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit">ADD</button>
                </td>
            </tr>
        </table>

    </form>
</center>
</body>
</html>
