<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
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
    <h1>Customer Management</h1>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <h2>List of Customers</h2>
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Customer Type</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>ID Card</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${customerList}" var="customer" varStatus="item">
        <tr>
            <td>${item.count}</td>
            <td>${customer.id}</td>
            <c:forEach items="${customerTypeList}" var="customerType">
                <c:if test="${customerType.id==customer.typeID}">
                    <td>${customerType.name}</td>
                </c:if>
            </c:forEach>
            <td>${customer.name}</td>
            <td>${customer.birthday}</td>

            <c:if test="${customer.gender}">
                <td>Nam</td>
            </c:if>
            <c:if test="${!customer.gender}">
                <td>Nữ</td>
            </c:if>

            <td>${customer.idCard}</td>
           <td>${customer.phone}</td>
           <td>${customer.email}</td>
           <td>${customer.address}</td>
           <td>
               <a href="/customers?action=edit&id=${customer.id}">EDIT</a>
               <a href="/customers?action=delete&id=${customer.id}">DELETE</a>
           </td>

        </tr>
        </c:forEach>
        <form action="/customers?action=search" method="post">
            <input name="searchName" placeholder="Input Name">
            <input name="searchEmail" placeholder="Input Email">
            <select name="searchTypeId">
                <option value="" >Choose Customer Type</option>
                <c:forEach items="${customerTypeList}" var="customerType">
                    <option value="${customerType.id}">${customerType.name}</option>
                </c:forEach>
            </select>
            <button type="submit"> Search</button>
        </form>
</div>
<div>
    <h2><a href="/customers?action=add">ADD NEW CUSTOMER</a></h2>
</div>

</body>
</html>