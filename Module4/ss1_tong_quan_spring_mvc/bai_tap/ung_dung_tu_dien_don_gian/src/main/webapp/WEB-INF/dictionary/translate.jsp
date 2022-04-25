<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/04/2022
  Time: 2:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>TRA TỪ ĐIỂN</h1>
<form action="/dictionary/translate" method="post">
    <input type="text" placeholder="nhập từ cần dịch" name="word">
    <button>TRANSLATE</button>
</form>
<input type="text" value="${result}">
</body>
</html>
