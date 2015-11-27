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
  <script type="text/javascript" src="/js/tinymce/tinymce.min.js"></script>
  <script type="text/javascript">
    $(function(){
      alert("start");
      tinymce.init({
        selector: "#solution",
        theme: "modern",
        width: 600,
        height: 300,
        plugins: [
          "advlist autolink link image lists charmap print preview hr anchor pagebreak spellchecker",
          "searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking",
          "save table contextmenu directionality emoticons template paste textcolor"
        ],
        content_css: "css/content.css",
        toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image | print preview media fullpage | forecolor backcolor emoticons"
      });
    });
  </script>
</head>
<body>
<form class="form-horizontal" method="post" action="/solution/add">
  <fieldset>
    <div id="legend" class="">
      <legend class="">添加题目</legend>
    </div>
    <div class="control-group">

      <!-- Select Basic -->
      <label class="control-label">OJ:</label>
      <div class="controls">
        <select class="form-control" name="ojName">
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
      <label class="control-label" for="ojId">题号:</label>
      <div class="controls">
        <input type="text" id="ojId" name="ojId" placeholder="Problem ID" class="input-xlarge">
      </div>
    </div>

    <div class="control-group">

      <!-- Textarea -->
      <label class="control-label">题解</label>
      <div class="controls">
        <div class="textarea">
          <textarea id="solution" name="solution" type="" class=""> </textarea>
        </div>
      </div>
    </div>
  <input type="submit" value="提交"/>
  </fieldset>
</form>

</body>
</html>
