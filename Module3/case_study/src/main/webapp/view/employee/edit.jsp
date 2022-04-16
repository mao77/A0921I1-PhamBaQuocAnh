<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Service Management Application-Edit</title>
</head>
<body>
<center>
    <h1>Employee Management</h1>
    <h2>
        <a href="/employees">List All Employee</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Employee
                </h2>
            </caption>
            <c:if test="${existingEmployee != null}">
                <input type="hidden" name="id" value="<c:out value='${existingEmployee.id}' />"/>
            </c:if>
            </tr>
            <tr>
                <th>Employee Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${existingEmployee.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Birthday:</th>
                <td>
                    <input type="text" name="birthday" size="45"
                           value="<c:out value='${existingEmployee.birthday}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Id Card:</th>
                <td>
                    <input type="text" name="idCard" size="45"
                           value="<c:out value='${existingEmployee.idCard}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Salary:</th>
                <td>
                    <input type="text" name="salary" size="45"
                           value="<c:out value='${existingEmployee.salary}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Phone:</th>
                <td>
                    <input type="text" name="phone" size="45"
                           value="<c:out value='${existingEmployee.phone}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${existingEmployee.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Address:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="<c:out value='${existingEmployee.address}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Position</th>
                <td>
                    <select name="positionId">
                        <c:forEach items="${positionList}" var="position">
                            <c:choose>
                                <c:when test="${position.id == existingEmployee.positionId}">
                                    <option value="${position.id}" selected>${position.name} </option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${position.id}">${position.name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Education Degree</th>
                <td>
                    <select name="educationDegreeId">
                        <c:forEach items="${educationDegreeList}" var="educationDegree">
                            <c:choose>
                                <c:when test="${educationDegree.id == existingEmployee.educationDegreeId}">
                                    <option value="${educationDegree.id}" selected>${educationDegree.name} </option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${educationDegree.id}">${educationDegree.name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Division</th>
                <td>
                    <select name="divisionId">
                        <c:forEach items="${divisionList}" var="division">
                            <c:choose>
                                <c:when test="${division.id == existingEmployee.divisionId}">
                                    <option value="${division.id}" selected>${division.name} </option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${division.id}">${division.name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
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