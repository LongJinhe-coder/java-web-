<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.net.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
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
   <%
   // 编码，解决中文乱码   
   String str = URLEncoder.encode(request.getParameter("name"),"utf-8");  
   // 设置 name 和 url cookie 
   Cookie name = new Cookie("name",
           str);
   Cookie url = new Cookie("url",
              request.getParameter("url"));

   // 设置cookie过期时间为24小时。
   name.setMaxAge(60*60*24); 
   url.setMaxAge(60*60*24); 

   // 在响应头部添加cookie
   response.addCookie( name );
   response.addCookie( url );
%>

<h1>设置 Cookie</h1>

<ul>
<li><p><b>网站名:</b>
   <%= request.getParameter("name")%>
</p></li>
<li><p><b>网址:</b>
   <%= request.getParameter("url")%>
</p></li>
</ul>
  </body>
</html>
