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
    <h1>ADD NEW GROUND</h1>
    <c:if test="${mess!=null}">
        <p>${mess}</p>
    </c:if>

    <form action="/grounds?action=add" method="post">
        <table>
            <tr>
                <td>Mã mặt bằng</td>
                <td><input type="text" name="code" placeholder="nhâp mã mặt bằng"></td>
            </tr>
            <tr>
                <td>Service Area</td>
                <td><input type="text" name="area" placeholder="nhâp diện tích"></td>
            </tr>
            <tr>
                <td>Trạng thái</td>
                <td>
                    <select name="groundStatusId">
                        <c:forEach items="${groundStatusList}" var="groundStatus">
                            <option value="${groundStatus.id}">${groundStatus.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Tầng</td>
                <td>
                    <select name="floorId">
                        <c:forEach items="${floorList}" var="floor">
                            <option value="${floor.id}">${floor.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Loại mặt bằng</td>
                <td>
                    <select name="groundTypeId">
                        <c:forEach items="${groundTypeList}" var="groundType">
                            <option value="${groundType.id}">${groundType.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Mô tả thêm</td>
                <td><input type="text" name="detailDescription" placeholder="nhâp mô tả thêm"></td>
            </tr>
            <tr>
                <td>Giá</td>
                <td><input type="text" name="price" placeholder="nhâp diện tích"></td>
            </tr>
            <tr>
                <td>Ngày bắt đầu</td>
                <td><input type="date" name="startDate" placeholder="nhâp ngày bắt đầu"></td>
            </tr>
            <tr>
                <td>Ngày kết thúc</td>
                <td><input type="date" name="endDate" placeholder="nhâp ngày kết thúc"></td>
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
