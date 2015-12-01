<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2015/12/1
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <sitemesh:write property='head' />
</head>
<body>
<div class="row">
  <div class="col-sm-3 sidebar">
    <ul class="nav nav-sidebar">
      <li class="active"><a href="#">DashBoard</a></li>
      <li><a href="#">我的任务</a></li>
      <li><a href="#">我的题解</a></li>
      <li><a href="#">我的总结</a></li>
      <li><a href="#">集训队总结</a></li>
    </ul>
  </div>
  <div class="col-sm-9">
    <sitemesh:write property='body' />
   </div>
  </div>
</body>
</html>
