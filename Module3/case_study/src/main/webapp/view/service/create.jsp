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
    <h1>ADD NEW SERVICE</h1>
    <c:if test="${mess!=null}">
        <p>${mess}</p>
    </c:if>

    <form action="/services?action=add" method="post">
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" placeholder="nhâp tên service"></td>
            </tr>
            <tr>
                <td>Service Area</td>
                <td><input type="text" name="area" placeholder="nhâp service area"></td>
            </tr>
            <tr>
                <td>Service Cost</td>
                <td><input type="text" name="cost" placeholder="nhâp service cost"></td>
            </tr>
            <tr>
                <td>Service Max People</td>
                <td><input type="text" name="maxPeople" placeholder="nhâp max people"></td>
            </tr>
            <tr>
                <td>Rent Type</td>
                <td>
                    <select name="rentTypeId">
                        <c:forEach items="${rentTypeList}" var="rentType">
                            <option value="${rentType.id}">${rentType.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Service Type</td>
                <td>
                    <select name="serviceTypeId">
                        <c:forEach items="${serviceTypeList}" var="serviceType">
                            <option value="${serviceType.id}">${serviceType.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Standard Room</td>
                <td><input type="text" name="standardRoom" placeholder="nhâp tiêu chuẩn phòng"></td>
            </tr>
            <tr>
                <td>Description Other Convenience</td>
                <td><input type="text" name="descriptionOtherConvenience" placeholder="nhâp Description Other Convenicence"></td>
            </tr>
            <tr>
                <td>Pool Area</td>
                <td><input type="text" name="poolArea" placeholder="nhâp diện tích hồ bơi"></td>
            </tr>
            <tr>
                <td>Number Of Floors</td>
                <td><input type="text" name="numberOfFloors" placeholder="nhâp số tầng"></td>
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
