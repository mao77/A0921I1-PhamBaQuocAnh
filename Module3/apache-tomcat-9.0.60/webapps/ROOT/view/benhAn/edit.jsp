<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bệnh Án Management Application-Edit</title>
</head>
<body>
<center>
    <h1>Bệnh Án Management</h1>
    <h2>
        <a href="/benhan">List All Bệnh Án</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Bệnh Án
                </h2>
            </caption>
            <c:if test="${existingBenhAn != null}">
                <input type="hidden" name="id" value="<c:out value='${existingBenhAn.id}' />"/>
            </c:if>
            </tr>
            <tr>
                <th>Mã bệnh án:</th>
                <td>
                    <input type="text" name="id" size="45"
                           disabled value="<c:out value='${existingBenhAn.id}' />" d
                    />
                </td>
            </tr>
            <tr>
                <th>Mã bệnh nhân</th>
                <td>
                    <input type="text" name="idBenhNhan" size="45"
                         disabled  value="<c:out value='${existingBenhAn.idBenhNhan}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Tên Bệnh Nhân</th>
                <td>
                    <c:forEach items="${benhNhanList}" var="benhNhan">
                        <c:choose>
                            <c:when test="${benhNhan.id == existingBenhAn.idBenhNhan}">
                                <input type="text" name="nameBenhNhan" size="45"
                                       value="<c:out value='${benhNhan.name}' />"
                                />
                            </c:when>
                            <c:otherwise>

                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <th>Ngày Nhập Viện</th>
                <td>
                    <input type="text" name="startDay" size="45"
                           value="<c:out value='${existingBenhAn.startDay}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Ngày Ra Viện</th>
                <td>
                    <input type="text" name="endDay" size="45"
                           value="<c:out value='${existingBenhAn.endDay}' />"
                    />
                </td>
            </tr>

            <tr>
                <th>Lý Do nhập viện</th>
                <td>
                    <input type="text" name="lyDo" size="45"
                           value="<c:out value='${existingBenhAn.lyDo}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Edit"/>
                    <a href="/benhan">trở về danh sách</a>
                </td>


            </tr>

        </table>
    </form>
</div>
</body>
</html>