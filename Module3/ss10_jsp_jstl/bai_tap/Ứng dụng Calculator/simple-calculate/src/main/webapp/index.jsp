<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/03/2022
  Time: 2:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>simple calculator</h1>
  <form method="post" action="/calculate">
    <table>
      <tr>
        <td>First Operand</td>
        <td><input type="text" name="firstOperand"></td>
      </tr>
      <tr>
        <td>Operator</td>
        <td>
          <select name="operator">
            <option value="+">Add</option>
            <option value="-">Sub</option>
            <option value="*">Multi</option>
            <option value="/">Divi</option>
          </select>
        </td>
      </tr>
      <tr>
        <td>Second Operand</td>
        <td><input type="text" name="secondOperand"></td>
      </tr>
    </table>
    <tr>
      <td></td>
      <td><input type="submit" value="Calculate"/></td>
    </tr>
  </form>
  </body>
</html>
