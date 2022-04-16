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
</ul>
<center>
    <h1>Ground Management</h1>
    <div>
        <h2><a href="/grounds?action=add">ADD NEW GROUND</a></h2>
    </div>
    <form action="/grounds?action=search" method="post">
        <select name="searchGroundTypeId">
            <option value="" >Choose Ground Type</option>
            <c:forEach items="${groundTypeList}" var="groundType">
                <option value="${groundType.id}">${groundType.name}</option>
            </c:forEach>
        </select>
        <select name="searchFloorId">
            <option value="" >Choose floor</option>
            <c:forEach items="${floorList}" var="floor">
                <option value="${floor.id}">${floor.name}</option>
            </c:forEach>
        </select>
        <button type="submit"> Search</button>
    </form>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <h2>List of Ground</h2>
        <tr>
            <th>STT</th>
            <th>Mã Bệnh Án</th>
            <th>Mã Bệnh Nhân</th>
            <th>Tên Bệnh Nhân</th>
            <th>Ngày Nhập Viện</th>
            <th>Ngày Ra Viện</th>
            <th>Lý do nhập viện</th>
            <th>Tác vụ</th>
        </tr>
        <c:forEach items="${benhAnList}" var="benhAn" varStatus="item">
            <tr>
                <td>${item.count}</td>
                <td>${benhAn.id}</td>
                <td>${benhAn.idBenhNhan}</td>
                <c:forEach items="${benhNhanList}" var="benhnhan">
                    <c:if test="${benhnhan.id==benhAn.idBenhNhan}">
                        <td>${benhnhan.name}</td>
                    </c:if>
                </c:forEach>
                <td>${benhAn.startDay}</td>
                <td>${benhAn.endDay}</td>
                <td>${benhAn.lyDo}</td>
                <td>
                    <a href="/benhan?action=delete&id=${benhAn.id}">DELETE</a>
                    <a href="/benhan?action=edit&id=${benhAn.id}">EDIT</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
