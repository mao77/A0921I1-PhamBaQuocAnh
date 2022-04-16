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
    <h1>Service Management</h1>
    <div>
        <h2><a href="/services?action=add">ADD NEW SERVICE</a></h2>
    </div>
    <form action="/services?action=search" method="post">
        <input name="searchName" placeholder="Input Name">
        <select name="searchServiceTypeId">
            <option value="" >Choose Service Type</option>
            <c:forEach items="${serviceTypeList}" var="serviceType">
                <option value="${serviceType.id}">${serviceType.name}</option>
            </c:forEach>
        </select>
        <select name="searchRentTypeId">
            <option value="" >Choose Rent Type</option>
            <c:forEach items="${rentTypeList}" var="rentType">
                <option value="${rentType.id}">${rentType.name}</option>
            </c:forEach>
        </select>
        <button type="submit"> Search</button>
    </form>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <h2>List of Services</h2>
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Name</th>
            <th>Area</th>
            <th>Cost</th>
            <th>Max People</th>
            <th>Rent Type</th>
            <th>Service Type</th>
            <th>Standard Room</th>
            <th>Other Convenience</th>
            <th>Pool Area</th>
            <th>Number OF Floors</th>
        </tr>
         <c:forEach items="${serviceList}" var="service" varStatus="item">
            <tr>
                <td>${item.count}</td>
                <td>${service.id}</td>
                <td>${service.name}</td>
                <td>${service.area}</td>
                <td>${service.cost}</td>
                <td>${service.maxPeople}</td>
                <c:forEach items="${rentTypeList}" var="rentType">
                    <c:if test="${rentType.id==service.rentTypeId}">
                        <td>${rentType.name}</td>
                    </c:if>
                </c:forEach>
             <c:forEach items="${serviceTypeList}" var="serviceType">
                <c:if test="${serviceType.id==service.typeId}">
                <td>${serviceType.name}</td>
                </c:if>
                </c:forEach>
                <td>${service.standardRoom}</td>
                <td>${service.descriptionOtherConvenience}</td>
                <td>${service.poolArea}</td>
                <td>${service.numberOfFloors}</td>
                <td>
                    <a href="/services?action=edit&id=${service.id}">EDIT</a>
                    <a href="/services?action=delete&id=${service.id}">DELETE</a>
                </td>
            </tr>
                </c:forEach>
    </table>
</div>
</body>
</html>
