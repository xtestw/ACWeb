<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2015/11/22
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>题解</title>
</head>
<body>
<div class="text-center"><h1>${problem.ojName} ${problem.ojId}</h1></div>
<div class="page-header">
  <h2>Description</h2>
</div>

<div class="page-header">
  <h2>Solutions</h2>
</div>

<div class="row">
  <div class="col-sm-12">
    <c:forEach var="item" items="${list}">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3 class="panel-title">${item.username}'s Solution</h3>
      </div>
      <div class="panel-body">
        ${item.solution}
      </div>
    </div>
    </c:forEach>
  </div>
</div>
</body>
</html>
