<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2015/11/4
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
用户列表
<table>
  <tr>
    <td>Hust</td>
    <td>name</td>
  </tr>
  <c:forEach var="item" items="${listReuslt}">
      <tr>
        <td>${item.hust_name}</td>
        <td>${item.name}</td>
      </tr>
  </c:forEach>
</table>
</body>
</html>
