<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Service Management Application-Edit</title>
</head>
<body>
<center>
    <h1>Service Management</h1>
    <h2>
        <a href="/services">List All Service</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Service
                </h2>
            </caption>
            <c:if test="${existingService != null}">
                <input type="hidden" name="id" value="<c:out value='${existingService.id}' />"/>
            </c:if>
            </tr>
            <tr>
                <th>Service Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${existingService.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Service Area:</th>
                <td>
                    <input type="text" name="area" size="45"
                           value="<c:out value='${existingService.area}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Service Cost:</th>
                <td>
                    <input type="text" name="cost" size="45"
                           value="<c:out value='${existingService.cost}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Service Max People:</th>
                <td>
                    <input type="text" name="maxPeople" size="45"
                           value="<c:out value='${existingService.maxPeople}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Service RentType</th>
            <td>
                <select name="rentTypeId">
                    <c:forEach items="${rentTypeList}" var="rentType">
                        <c:choose>
                            <c:when test="${rentType.id == existingService.rentTypeId}">
                                <option value="${rentType.id}" selected>${rentType.name} </option>
                            </c:when>
                            <c:otherwise>
                                <option value="${rentType.id}" >${rentType.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </td>
            </tr>
            <tr>
                <th>Service Type</th>
                <td>
                    <select name="serviceTypeId">
                        <c:forEach items="${serviceTypeList}" var="serviceType">
                            <c:choose>
                                <c:when test="${serviceType.id == existingService.typeId}">
                                    <option value="${serviceType.id}" selected>${serviceType.name} </option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${serviceType.id}" >${serviceType.name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Standard Room:</th>
                <td>
                    <input type="text" name="standardRoom" size="45"
                           value="<c:out value='${existingService.standardRoom}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Description Other Convenience:</th>
                <td>
                    <input type="text" name="descriptionOtherConvenience" size="45"
                           value="<c:out value='${existingService.descriptionOtherConvenience}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Pool Area:</th>
                <td>
                    <input type="text" name="poolArea" size="45"
                           value="<c:out value='${existingService.poolArea}' />"
                    />
                </td>
            </tr>
            <tr>
            <th>Number Of Floors:</th>
            <td>
                <input type="text" name="numberOfFloors" size="45"
                       value="<c:out value='${existingService.numberOfFloors}' />"
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