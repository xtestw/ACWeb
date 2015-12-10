<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2015/11/20
  Time: 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
  <style>
    #canvas {
      background-color: white;
      display: block;
    }
  </style>

  <script src="/js/pointRun.js"></script>
  <link rel="stylesheet" href="/css/login.css" />
  <script type="text/javascript" src="/js/md5.js"></script>
  <script type="text/javascript">
    function changeImg() {
      var imgSrc = $("#imgObj");
      var src = imgSrc.attr("src");
      imgSrc.attr("src", chgUrl(src));
    }
    function chgUrl(url) {
      var timestamp = (new Date()).valueOf();
      url = url.substring(0, 17);
      if ((url.indexOf("&") >= 0)) {
        url = url + "×tamp=" + timestamp;
      } else {
        url = url + "?timestamp=" + timestamp;
      }
      return url;
    }

    function login(){
      $("#inputPassword").val($.md5($("#inputPassword").val()));
      return true;
    }
  </script>
</head>
<body>
<div class="row" id="pointRun" >
  <div class="col-sm-8" >

    <canvas id="canvas"></canvas>
  </div>
  <div class="col-sm-4">
  <form class="form-signin" action="/user/login" onsubmit="return login();" method="post">
    <c:if test="${loginError!=null}">
      <div class="alert">
        <a class="close" data-dismiss="alert">×</a>
        <strong>${loginError}</strong></div>
    </c:if>
    <h2 class="form-signin-heading">Please sign in</h2>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email address" required="" autofocus="">
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required="">
    <div data-selector="email-code-wrap" class="login-form">
      <input type="text" placeholder="Captcha" value="" name="code" class=" form-control " autocomplete="off" style="width:67%;display:inline-block;">
      <img class="image-verycode" src="/code"  style="height: 40px;width: 30%" onclick="changeImg()" id="imgObj"/>
    </div>
    <div class="checkbox">
      <label>
        <input type="checkbox"  name="rememberMe"> Remember me
      </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
  </form>
  </div>

</div>
</body>
</html>
