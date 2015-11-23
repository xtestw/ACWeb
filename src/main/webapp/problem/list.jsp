<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2015/11/22
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>题解报告</title>

  <!-- 只有使用字体图标时才需要加载 Font-Awesome -->
  <link href="http://cdn.bootcss.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

  <link href="/css/problem.css" rel="stylesheet">
  <script type="text/javascript">
    $(function(){
        var ul =$("#pagination");
      if(1>=${problems.pagesCount}){
        return;
      }
        var loca=window.location.toString();
        var regex=new RegExp("page=[0-9]*");

      var result=regex.exec(loca);
      if(result==null) {
          loca = loca + "?page=1";
      }
      var result=regex.exec(loca);
        ul.append("<li>\
                <a href=\""+loca.replace(result,"page=1")+"\">&lt;&lt;</a>\
              </li>");
        for(var i=1;i<=${problems.pagesCount};i++){
          var cla="";
          if(i==${problems.curIndex}){cla="active";}
          ul.append("<li class=\""+cla+"\"><a href=\""+loca.replace(result,"page="+i)+"\">"+(i)+"</a><li>");
        }
        ul.append("<li>\
                <a href=\""+loca.replace(result,"page="+${problems.pagesCount})+"\">&gt;&gt;</a>\
              </li>");
    });
  </script>
</head>
<body>
<div class="hidden-xs">
  <div class="row">
    <div class="col-sm-6"><h1>Problem List</h1></div>
    <div class="col-sm-6 text-right h1-align">
      <form action="/problem/search" method="get" class="form-inline">
        <fieldset>
          <select class="form-control" name="ojName">
            <option value="CodeForces">CodeForces</option>
            <option value="POJ">POJ</option>
            <option value="HDU">HDU</option>
            <option value="HUST">HUST</option>
            <option value="ZOJ">ZOJ</option>
            <option value="FZU">FZU</option>
            <option value="UVA">UVA</option>
          </select>
          <div class="input-group">
            <input type="text" class="form-control" name="ojId" placeholder="Problem ID..." value="">
            <div class="input-group-btn"><button type="submit" id="searchItem" class="btn btn-default"><span class="fa fa-search"></span></button></div>
          </div>
          <input type="text" name="page" value="1" style="display:none;"/>
        </fieldset>
      </form>
    </div>
  </div>
  <table class="table table-striped table-bordered table-center">
    <thead>
    <tr>
      <th style="width: 30%;">Source</th>
      <th>PID</th>
      <th>Tags</th>
      <th>Hard</th>
      <th>Solution</th>
    </tr>
    </thead>
    <tbody>
<c:forEach var="item" items="${problems.items}">
  <tr>
    <td>
        ${item.ojName}
    </td>
    <td>
        ${item.ojId}
    </td>
    <td>
        ${item.tags}
    </td>
    <td>
        ${item.level}
    </td>
    <td>
      <a href="/solution/show?pid=${item.id}"> 题解</a>
    </td>
  </tr>
</c:forEach>

    </tbody>
    </table>
   <ul class="pagination" id="pagination" role="pagination">

   </ul>


  </div>
</body>
</html>
