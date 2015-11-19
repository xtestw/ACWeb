<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2015/11/19
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="header">
  <nav class="navbar navbar-static-top navbar-default">
    <div class="container">
      <div class="navbar-header" id="navbar-header" data-turbolinks-permanent>
        <a href="/" class="navbar-brand"><b>CQU</b> Acmer</a>
      </div>

        <span id="main-nav-menu" data-turbolinks-temporary>
          <ul class="nav navbar-nav">
            <li><a href="/index.jsp">首页</a></li>
            <li><a href="/index.jsp">首页</a></li>
            <li><a href="/index.jsp">首页</a></li>
            <li><a href="/index.jsp">首页</a></li>
          </ul>
        </span>
      <ul class="nav user-bar navbar-nav navbar-right">
        <li><a href="/account/sign_up">注册</a></li>
        <li><a href="/account/sign_in">登录</a></li>
      </ul>

      <ul class="nav user-bar navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">xtestw <span class="caret"></span></a>
          <button class="navbar-toggle" type="button" data-toggle="dropdown" role="button" aria-expanded="false">
            <span class="sr-only">Toggle</span>
            <i class="fa fa-reorder"></i>
          </button>
          <ul class="dropdown-menu" role="menu"><li class=""><a href="/xtestw">我的主页</a></li><li class=""><div class='divider'></div></li><li class=""><a href="/account/edit">个人资料设置</a></li><li class=""><a href="/notes">记事本</a></li><li class=""><a href="/xtestw/favorites">我的收藏</a></li><li class=""><div class='divider'></div></li><li class=""><a rel="nofollow" data-method="delete" href="/account/sign_out">退出</a></li></ul>
        </li>
      </ul>

      <ul class="nav navbar-nav navbar-right">
        <li class="nav-search hidden-xs">
          <form class="navbar-form form-search" action="/search" method="GET">
            <div class="form-group">
              <input class="form-control" name="q" type="text"  placeholder="搜索本站内容" />
            </div>
            <i class="fa btn-search fa-search"></i>
            <i class="fa btn-close fa-times-circle"></i>
          </form>
        </li>


      </ul>
    </div>
  </nav>
</div>