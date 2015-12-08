<%--
  Created by IntelliJ IDEA.
  User: xuwei
  Date: 2015/11/27
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加题解</title>
  <script type="text/javascript" src="/js/tiny_mce/tiny_mce.js"></script>
  <script type="text/javascript">
    $(function(){
      tinyMCE.init({
        // General options
        language: "zh-cn",
        mode: "exact",
        elements: "solution",
        theme: "advanced",
        plugins: "autosave,style,advhr,advimage,advlink,preview,inlinepopups,media,paste,syntaxhl,wordcount",
        // Theme options
        theme_advanced_buttons1: "formatselect,fontselect,fontsizeselect,|,bold,italic,underline,strikethrough,forecolor,|,advhr,blockquote,syntaxhl,",
        theme_advanced_buttons2: "undo,redo,|,bullist,numlist,outdent,indent,|,justifyleft,justifycenter,justifyright,justifyfull,|,pastetext,pasteword,|,link,unlink,image,iespell,|,cleanup,preview,",
        theme_advanced_buttons3: "",
        theme_advanced_toolbar_location: "top",
        theme_advanced_toolbar_align: "left",
        theme_advanced_resizing: true,
        theme_advanced_statusbar_location: "bottom",
        extended_valid_elements: "link[type|rel|href|charset],pre[name|class],iframe[src|width|height|name|align],+a[*]",
        valid_children: "+body[style]",
        relative_urls: false,
        remove_script_host: false,
        height:500,
        width:"100%",
        oninit: function () {
          if (typeof (conf.fun) === "function") {
            conf.fun();
          }
        }
      });
    });
  </script>
  <style >

  </style>
</head>
<body>
<c:if test="${addInfo!=null}">
  <div class="alert">
    <a class="close" data-dismiss="alert">×</a>
    <strong>${addInfo}</strong></div>
</c:if>
<form class="form-horizontal" method="post" action="/solution/add">
  <fieldset>
    <div id="legend" class="">
      <legend class="">添加题目</legend>
    </div>
    <div class="control-group">

      <!-- Select Basic -->
      <label class="control-label">OJ:</label>
      <div class="controls">
        <select class="form-control" name="problem.ojName">
          <option value="CodeForces">CodeForces</option>
          <option value="POJ">POJ</option>
          <option value="HDU">HDU</option>
          <option value="HUST">HUST</option>
          <option value="ZOJ">ZOJ</option>
          <option value="FZU">FZU</option>
          <option value="UVA">UVA</option>
        </select>
      </div>

    </div>


    <div class="control-group">
      <!-- Text input-->
      <label class="control-label" for="problem.ojId">题号:</label>
      <div class="controls">
        <input type="text" id="problem.ojId" name="problem.ojId" placeholder="Problem ID" class="form-control input-xlarge">
      </div>
    </div>

    <div class="control-group">

      <!-- Text input-->
      <label class="control-label" for="problem.tags">类型(分号隔开):</label>
      <div class="controls">
        <input type="text" id="problem.tags" name="problem.tags" placeholder="Problem Type" class="form-control input-xlarge">
      </div>
    </div>


    <div class="control-group">
    <!-- Select Basic -->
    <label class="control-label">难度:</label>
    <div class="controls">
      <select class="form-control" name="problem.level">
        <option value="水题">水题</option>
        <option value="简单">简单</option>
        <option value="中档">中档</option>
        <option value="中档偏难">中档偏难</option>
        <option value="难题">难题</option>
        <option value="非常难">非常难</option>
        <option value="final">final</option>
      </select>
    </div>

    </div>

    <div class="control-group">
      <!-- Textarea -->
      <label class="control-label">题解</label>
      <div class="controls">
        <div class="textarea" id="mceEditor" style="width:100%;">
          <textarea id="solution" name="solution" type="" class=""> </textarea>
        </div>
      </div>
    </div>
    <div class="control-group text-right" style="margin-top:5px">
        <input type="submit" value="提交" class="btn btn-default"/>
    </div>
  </fieldset>
</form>
</body>
</html>
