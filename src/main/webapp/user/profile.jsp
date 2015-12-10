  <%--
    Created by IntelliJ IDEA.
    User: admin
    Date: 2015/11/20
    Time: 15:55
    To change this template use File | Settings | File Templates.
  --%>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <html>
  <head>
      <title>${user.email}的个人信息</title>
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

      <div class="page-header">
        <h3>TODO..</h3>
      </div>
      <div class="row">
        <div class="col-sm-4">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">未完成题解</h3>
            </div>
            <div class="panel-body">
              <a>HDU_</a>
            </div>
        </div>
          </div>
          <div class="col-sm-4">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">未完成总结</h3>
            </div>
            <div class="panel-body">
              <a>HDU_</a>
            </div>
          </div>
          </div>
      </div>
      <div class="page-header">
        <h3>最新解题报告</h3>
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

        </tbody>
      </table>
      <div class="page-header">
        <h3>最新总结报告</h3>
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

        </tbody>
      </table>
  </div>
    </div>
  </body>
  </html>
