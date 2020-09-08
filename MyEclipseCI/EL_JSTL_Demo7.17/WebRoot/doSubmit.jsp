<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doSubmit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h2>你提交的内容如下：</h2>
    <%
    request.setCharacterEncoding("utf-8");
     %>
     
     姓名：${param.username}<br/>
     性别：${param.sex}<br/>
     出生日期：${param.Birthday}<br/>
     学校：${param.school}<br/>
  专业：${param.select} <br/>
   体育特长：${paramValues.hobby[0]}${paramValues.hobby[1]}${paramValues.hobby[2]}${paramValues.hobby[3]} <br/>
  密码：${param.pwd} <br/>
  简介：${param.info} <br/>
  </body>
</html>
