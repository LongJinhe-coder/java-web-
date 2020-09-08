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
  <legend align="left" style="color:green;">我的消息</legend>
</fieldset>
<table class="layui-table">
  <colgroup>
    <col width="150">
    <col width="200">
    <col width="200">
  </colgroup>
  <thead>
    <tr>
      <th>企业编号</th>
      <th>企业名称</th>
      <th>联系方式</th>
      <th>消息内容</th>
      <th>操作</th>
    </tr> 
  </thead>
  <tbody>
  
  <tr>
      <td>100001</td>
      <td>华侨大学</td>
      <td>12345678900</td>
      <td>您已通过审核，请您与2020年7月24日下午2：00，前往福建省厦门市集美大道668号D4-503处面试。过期不候。</td>
      <td><button type="button" class="layui-btn">删除</button></td>
    </tr>

  </tbody>
</table>
</body>
</html>        
