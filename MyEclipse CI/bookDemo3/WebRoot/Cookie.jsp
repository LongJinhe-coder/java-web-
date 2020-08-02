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
    
    <title>My JSP 'Cookie.jsp' starting page</title>
    
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
   Cookie cookie = null;
   Cookie[] cookies = null;
   // 获取 cookies 的数据,是一个数组
   cookies = request.getCookies();
   if( cookies != null ){
      out.println("<h2> 查找 Cookie 名与值</h2>");
      for (int i = 0; i < cookies.length; i++){
         cookie = cookies[i];
         out.print("参数名 : " + cookie.getName());
         out.print("参数值: " + URLDecoder.decode(cookie.getValue(), "utf-8") +" <br>");
         out.print("------------------------------------<br>");
      }
  }else{
      out.println("<h2>没有发现 Cookie</h2>");
  }
%>
  </body>
</html>
