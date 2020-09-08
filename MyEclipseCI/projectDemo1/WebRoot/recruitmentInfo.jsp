<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
 <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend align="left" style="color:green;">发布招聘信息/已发布</legend>
</fieldset>
<table class="layui-table">
  <colgroup>
    <col width="150">
    <col width="200">
    <col width="200">
  </colgroup>
  <thead>
    <tr>
      <th>职位</th>
      <th>月薪</th>
      <th>招聘人数</th>
      <th>年龄要求</th>
      <th>截止日期</th>
      <th>操作</th>
    </tr> 
  </thead>
  <tbody>
  <tr>
      <td>前端</td>
      <td>10000.0</td>
      <td>3</td>
      <td>20-35</td>
      <td>2020-12-12</td>
      <td><button type="button" class="layui-btn">修改信息</button><button type="button" class="layui-btn">删除信息</button><button type="button" class="layui-btn">增加信息</button></td>
    </tr>
  <tr>
     <td>前端</td>
      <td>10000.0</td>
      <td>3</td>
      <td>20-35</td>
      <td>2020-12-12</td>
      <td><button type="button" class="layui-btn">修改信息</button><button type="button" class="layui-btn">删除信息</button><button type="button" class="layui-btn">增加信息</button></td>
    </tr>

     <tr>
    <td>前端</td>
      <td>10000.0</td>
      <td>3</td>
      <td>20-35</td>
      <td>2020-12-12</td>
      <td><button type="button" class="layui-btn">修改信息</button><button type="button" class="layui-btn">删除信息</button><button type="button" class="layui-btn">增加信息</button></td>
    </tr>
   
    
  </tbody>
</table>

    
</body>
</html>        
