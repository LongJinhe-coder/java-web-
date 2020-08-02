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
  <legend align="left" style="color:green;">招聘信息/待审核</legend>
</fieldset>
<table class="layui-table">
  <colgroup>
    <col width="150">
    <col width="200">
    <col width="200">
    
  </colgroup>
  <thead>
    <tr>
      <th>企业</th>
      <th>职位</th>
      <th>发布日期</th>
      <th>操作</th>
    </tr> 
  </thead>
  <tbody>
  <tr>
      <td>腾讯</td>
      <td>web前端工程师</td>
      <td>2020-07-23</td>
      <td><button type="button" class="layui-btn">查看</button>
      <button type="button" class="layui-btn layui-btn-danger">删除</button></td>
      
    </tr>
  <tr>
      <td>阿里巴巴</td>
      <td>java攻城狮</td>
      <td>2020-07-22</td>
      <td><button type="button" class="layui-btn">查看</button>
      <button type="button" class="layui-btn layui-btn-danger">删除</button></td>
    </tr>
     <tr>
       <td>字节跳动</td>
      <td>全栈程序猿</td>
      <td>2020-07-23</td>
     <td><button type="button" class="layui-btn">查看</button>
      <button type="button" class="layui-btn layui-btn-danger">删除</button></td>
    </tr>
  </tbody>
</table>
</body>
</html>        
