<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
  <c:choose>
  <c:when test="${adminname eq '龙金河'}">
      	<div style="font-size: 50px;margin-top: 15%;text-align: center;">亲爱的BOSS<font size="30px" color="green">${adminname}</font>,</br>欢迎您登录Higher Brothers招聘网站后台管理系统，
      	您有权添加管理员！</div>
	</c:when>
	<c:otherwise>
<div style="font-size: 50px;margin-top: 15%;text-align: center;">亲爱的管理员<font size="30px" color="green">${adminname}</font>,</br>欢迎您登录Higher Brothers招聘网站后台管理系统！</div>
  </c:otherwise>
  </c:choose>
  </body>
  
</html>
