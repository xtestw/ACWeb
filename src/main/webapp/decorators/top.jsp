<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2015/11/19
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div class="header">
  <nav class="navbar navbar-static-top navbar-default">
    <div class="container">
      <div class="navbar-header" id="navbar-header" data-turbolinks-permanent>
        <a href="/" class="navbar-brand"><b>CQU</b> Acmer</a>
      </div>

        <span id="main-nav-menu" data-turbolinks-temporary>
          <ul class="nav navbar-nav">
            <li><a href="/">首页</a></li>
              <li><a href="/problem/list">题解</a></li>
              <li><a href="/problem/list">AC代码</a></li>
              <li><a href="/problem/list">资料下载</a></li>
              <li><a href="/problem/list">集训队简介</a></li>
              <li><a href="/problem/list">联系我们</a></li>
          </ul>
        </span>

        <c:choose>
          <c:when test="${sessionScope.user==null}">
      <ul class="nav user-bar navbar-nav navbar-right">
        <li><a href="/register.jsp">注册</a></li>
        <li><a href="/login.jsp">登录</a></li>
      </ul>
     </c:when>
        <c:otherwise>
      <ul class="nav user-bar navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">${sessionScope.user.name} <span class="caret"></span></a>
          <button class="navbar-toggle" type="button" data-toggle="dropdown" role="button" aria-expanded="false">
            <span class="sr-only">Toggle</span>
            <i class="fa fa-reorder"></i>
          </button>
          <ul class="dropdown-menu" role="menu">
              <li class=""><a href="/user/profile">我的主页</a></li>
              <li class=""><div class='divider'></div></li>
              <li class=""><a href="/account/edit">个人资料设置</a></li>
              <li class=""><a href="/notes">记事本</a></li>
              <li class=""><a href="/xtestw/favorites">我的收藏</a></li>
              <li class=""><div class='divider'></div></li>
              <li class=""><a rel="nofollow" data-method="delete" href="/logout">退出</a></li></ul>
        </li>
      </ul></c:otherwise>
      </c:choose>
      <ul class="nav navbar-nav navbar-right">
        <li class="nav-search hidden-xs">
          <form class="navbar-form form-search" action="/search" method="GET">
            <div class="form-group">
              <input class="form-control" name="q" type="text"  placeholder="搜索本站内容" />
            </div>
          </form>
        </li>


      </ul>
    </div>
  </nav>
</div>