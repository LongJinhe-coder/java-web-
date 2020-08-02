<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="javax.swing.JOptionPane"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'positive.jsp' starting page</title>
    
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
   request.setCharacterEncoding("UTF-8");
  	response.setCharacterEncoding("UTF-8");
  	
  	String name = request.getParameter("username");
  	String password = request.getParameter("password");
  	String password2 = request.getParameter("password2");
  	String sex = request.getParameter("sex");
  	String[] interest = request.getParameterValues("interset");
  	String intersets = "";
  	for(int i =0; i<interest.length;i++)
  		intersets+=interest[i]+' ';
  	String select = request.getParameter("select");
  	String introduce = request.getParameter("introduce");
   %>
    <p>你的姓名是：<%=name %></p>
     <p>你的密码是：<%=password %></p>
      <p>你的性别是：<%=sex %></p>
       <p>你的爱好是：<%=intersets %></p>
        <p>你的星座是：<%=select %></p>
         <p>你的简介是：<%=introduce %></p>
        
    
    
    
  </body>
</html>
