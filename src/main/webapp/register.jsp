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
  <link rel="stylesheet" href="/css/register.css" />
  <link href="//cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css" rel="stylesheet">
  <link href="//cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css" rel="stylesheet">
  <script src="//cdn.bootcss.com/bootstrap-validator/0.5.3/js/language/zh_CN.js"></script>
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
    function register(){
      var pw=$("#rpassword").val();
      var rpw=$("#rrepassword").val();
      if(pw!=rpw){
        alert("两次密码输入不一致");
        return false;
      }
      $("#rpassword").val($.md5(pw));

      return true;
    }
  </script>
</head>
<body>
<div class="page-header">
  <h4>注册信息填写</h4>
</div>
<form class="form-register registerForm" id="registerForm" method="post" onsubmit="return register()" action="/user/register">
  <div class="row">
    <c:if test="${registerError!=null}">
      <div class="alert">
        <a class="close" data-dismiss="alert">×</a>
        <strong>${registerError}</strong></div>
    </c:if>
    <div class="col-sm-6">
      <ul class="list-group">
        <li class="list-group-item"> <label for="remail" class="sr-only">Email address</label>
          <input type="email" id="remail" class="form-control" name="email" placeholder="Email address" required="" autofocus="">
        </li>
        <li class="list-group-item"> <label for="rname" class="sr-only">RealName</label>
          <input type="text" id="rname" class="form-control" name="name" placeholder="RealName" required="" autofocus="">
        </li>
        <li class="list-group-item"> <label for="rpassword" class="sr-only">Password</label>
        <input type="password" id="rpassword" class="form-control" name="password" placeholder="Password" required="" autofocus="">
      </li>
        <li class="list-group-item"> <label for="rrepassword" class="sr-only">Confirm Password</label>
          <input type="password" id="rrepassword" class="form-control" name="repassword" placeholder="Confirm Password" required="" autofocus="">
        </li>
        <li class="list-group-item"> <label for="ridcard" class="sr-only">IDCard</label>
          <input type="text" id="ridcard" class="form-control" name="iDCard" placeholder="IDCard" required="" autofocus="">
        </li>
        <li class="list-group-item"> <label for="SchoolID" class="sr-only">SchoolID</label>
          <input type="text" id="SchoolID" class="form-control" name="schoolId" placeholder="SchoolID" required="" autofocus="">
        </li>
        <li class="list-group-item"> <label for="Campus" class="sr-only">Campus</label>
          <input type="text" id="Campus" class="form-control" name="campus" placeholder="Campus" required="" autofocus="">
        </li>
        <li class="list-group-item"> <label for="Major" class="sr-only">Major</label>
          <input type="text" id="Major" class="form-control" name="major" placeholder="Major" required="" autofocus="">
        </li>
        <li class="list-group-item"> <label for="TshirtSize" class="sr-only">TshirtSize</label>
          <input type="text" id="TshirtSize" class="form-control" name="thirt" placeholder="TshirtSize S,M,X,XL,XLL,XLLL" required="" autofocus="">
        </li>
        <li class="list-group-item"> <label for="Telephone" class="sr-only">Telephone</label>
          <input type="text" id="Telephone" class="form-control" name="telephone" placeholder="Telephone" required="" autofocus="">
        </li>
      </ul>
    </div>
    <div  class="col-sm-6">
      <ul class="list-group">
        <li class="list-group-item"> <label for="Blog" class="sr-only">Blog Address</label>
          <input type="text" id="Blog" class="form-control" name="blog" placeholder="Blog Address"  autofocus="">
        </li>
        <li class="list-group-item"> <label for="DefaultUsername" class="sr-only">DefaultUsername</label>
          <input type="text" id="DefaultUsername" class="form-control" name="username" placeholder="DefaultUsername" required="" autofocus="">
        </li>
        <li class="list-group-item"> <label for="CodeForces" class="sr-only">CodeForces</label>
          <input type="text" id="CodeForces" class="form-control" name="codeforces" placeholder="CodeForces"  autofocus="">
        </li>
        <li class="list-group-item"> <label for="POJ" class="sr-only">POJ</label>
          <input type="text" id="POJ" class="form-control" name="poj" placeholder="POJ(Let it empty if the same as defaultusernmae)"  autofocus="">
        </li>
        <li class="list-group-item"> <label for="ZOJ" class="sr-only">ZOJ</label>
          <input type="text" id="ZOJ" class="form-control" name="zoj" placeholder="ZOJ(Let it empty if the same as defaultusernmae)"  autofocus="">
        </li>
        <li class="list-group-item"> <label for="HDU" class="sr-only">HDU</label>
          <input type="text" id="HDU" class="form-control" name="hdu" placeholder="HDU(Let it empty if the same as defaultusernmae)" autofocus="">
        </li>
        <li class="list-group-item"> <label for="FZU" class="sr-only">FZU</label>
          <input type="text" id="FZU" class="form-control" name="fzu" placeholder="FZU(Let it empty if the same as defaultusernmae)" autofocus="">
        </li>
        <li class="list-group-item"> <label for="HUST" class="sr-only">HUST</label>
          <input type="text" id="HUST" class="form-control" name="hust_name" placeholder="HUST(Let it empty if the same as defaultusernmae)"  autofocus="">
        </li>

        <li class="list-group-item"> <label for="Captcha" class="sr-only">Code</label>
          <input type="text" id="Captcha" placeholder="Verity Code" value="" name="code" class=" form-control " required="" autocomplete="off" style="width:67%;display:inline-block;">
          <img class="image-verycode" src="/code"  style="height: 40px;width: 30%" onclick="changeImg()" id="imgObj"/>
        </li>
      </ul>
    </div>
  </div>

  <div class="row">
    <div class="col-sm-5"></div>

    <div class="col-sm-2">
      <input type="submit"  class="btn btn-lg btn-success btn-block" value="注册"/>
    </div>

    <div class="col-sm-5"></div>
  </div>
</form>
</body>
</html>
