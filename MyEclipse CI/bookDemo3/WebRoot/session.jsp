<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'session.jsp' starting page</title>
    
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
   <hr>
       session的创建时间是:<%=new Date(session.getCreationTime())%> <br>
       session的Id号:<%=session.getId()%><br>
        客户最近一次访问时间是:
        <%=new java.sql. Time(session.getLastAccessedTime())%> <br>
        两次请求间隔多长时间session将被取消(ms):
       <%=session.getMaxInactiveInterval()%> <br>
        是否是新创建的session:<%=session.isNew()?"是":"否"%>
       <hr/>

  </body>
</html>
