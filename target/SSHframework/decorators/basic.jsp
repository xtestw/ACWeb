<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2015/11/4
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<html lang="zh-CN">
<head>

  <%@include file="/include/ruby-china.jsp"%>

    <sitemesh:write property='head' />

</head>
<body>
<%@include file="top.jsp"%>
<div id="main" class="main-container container" style="min-height: 500px;">
<sitemesh:write property='body' />
    </div>
<%@include file="footer.jsp"%>
</body>
</html>
