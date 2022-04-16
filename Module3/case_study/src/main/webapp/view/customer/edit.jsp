<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application-Edit</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="/customers">List All Customers</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Customer
                </h2>
            </caption>
            <c:if test="${customer != null}">
                <input type="hidden" name="id" value="<c:out value='${customer.id}' />"/>
            </c:if>
            <tr>
            <th>Customer Type</th>
            <td>
                <select name="customerTypeId">
                    <c:forEach items="${customerTypeList}" var="customerType">
<%--                        <c:if test="${customerType.id == customer.typeID}">--%>
<%--                            <option value="${customerType.id}" selected="">${customerType.name} </option>--%>
<%--                        </c:if>--%>
                        <c:choose>
                            <c:when test="${customerType.id == customer.typeID}">
                                <option value="${customerType.id}" selected>${customerType.name} </option>
                            </c:when>
                            <c:otherwise>
                                <option value="${customerType.id}" >${customerType.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </td>
            </tr>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${customer.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Gender:</th>
                <td>
                    <c:choose >
                        <c:when test="${customer.gender}">
                            <input type="radio" name="gender" value="true" checked> nam
                            <input type="radio" name="gender" value="true" > nữ
                        </c:when>
                        <c:when test="${!customer.gender}">
                            <input type="radio" name="gender" value="true" > nam
                            <input type="radio" name="gender" value="true" checked> nữ
                        </c:when>
                        <c:otherwise>
                            <input type="radio" name="gender" value="true"> nam
                            <input type="radio" name="gender" value="false">nữ
                        </c:otherwise>
                    </c:choose>

                </td>
            </tr>
            <tr>
                <th>Customer Birthday:</th>
                <td>
                    <input type="date" name="birthday" size="45"
                           value="<c:out value='${customer.birthday}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer ID Card:</th>
                <td>
                    <input type="text" name="idCard" size="45"
                           value="<c:out value='${customer.idCard}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Phone:</th>
                <td>
                    <input type="text" name="phone" size="45"
                           value="<c:out value='${customer.phone}' />"
                    />
                </td>
            </tr>

            <tr>
                <th>Customer Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${customer.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Address</th>
                <td>
                    <input type="text" name="address" size="15"
                           value="<c:out value='${customer.address}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Edit"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>