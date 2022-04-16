<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Service Management Application</title>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</head>
<body>
<ul class="nav justify-content-center">
    <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="/home">HOME</a>
    </li>
    <li class="nav-item">
        <a class="nav-link active" href="/customers">CUSTOMER</a>
    </li>
    <li class="nav-item">
        <a class="nav-link active" href="/services">SERVICE</a>
    </li>
    <li class="nav-item">
        <a class="nav-link active" href="/employees">EMPLOYEE</a>
    </li>
    <li class="nav-item">
        <a class="nav-link active">Disabled</a>
    </li>

</ul>
<center>
    <h1>Employee Management</h1>
    <div>
        <h2><a href="/employees?action=add">ADD NEW EMPLOYEE</a></h2>
    </div>
    <form action="/employees?action=search" method="post">
        <input name="searchName" placeholder="Input Name">
        <select name="searchPositionId">
            <option value="" >Choose Position</option>
            <c:forEach items="${positionList}" var="position">
                <option value="${position.id}">${position.name}</option>
            </c:forEach>
        </select>
        <select name="searchEducationDegreeId">
            <option value="" >Choose Education Degree</option>
            <c:forEach items="${educationDegreeList}" var="educationDegree">
                <option value="${educationDegree.id}">${educationDegree.name}</option>
            </c:forEach>
        </select>
        <select name="searchDivisionId">
            <option value="" >Choose Division</option>
            <c:forEach items="${divisionList}" var="division">
                <option value="${division.id}">${division.name}</option>
            </c:forEach>
        </select>
        <button type="submit"> Search</button>
    </form>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <h2>List of Employees</h2>
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>ID Card</th>
            <th>Salary</th>
            <th>Phone</th>
            <th>Email Type</th>
            <th>Address</th>
            <th>Position</th>
            <th>Education Deegree</th>
            <th>Division</th>
        </tr>
        <c:forEach items="${employeeList}" var="employee" varStatus="item">
            <tr>
                <td>${item.count}</td>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.birthday}</td>
                <td>${employee.idCard}</td>
                <td>${employee.salary}</td>
                <td>${employee.phone}</td>
                <td>${employee.email}</td>
                <td>${employee.address}</td>
                <c:forEach items="${positionList}" var="position">
                    <c:if test="${position.id==employee.positionId}">
                        <td>${position.name}</td>
                    </c:if>
                </c:forEach>
                <c:forEach items="${educationDegreeList}" var="educationDegree">
                    <c:if test="${educationDegree.id==employee.educationDegreeId}">
                        <td>${educationDegree.name}</td>
                    </c:if>
                </c:forEach>
                <c:forEach items="${divisionList}" var="division">
                    <c:if test="${division.id==employee.divisionId}">
                        <td>${division.name}</td>
                    </c:if>
                </c:forEach>
                <td>
                    <a href="/employees?action=edit&id=${employee.id}">EDIT</a>
                    <a href="/employees?action=delete&id=${employee.id}">DELETE</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
