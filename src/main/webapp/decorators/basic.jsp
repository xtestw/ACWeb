<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2015/11/4
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<html>
<head>
    <title>
      <sitemesh:write property='title' />
    </title>
  <%@include file="/include/ruby-china.jsp"%>
</head>
<body>
<%@include file="top.jsp"%>
<sitemesh:write property='body' />
<%@include file="footer.jsp"%>
</body>
</html>
