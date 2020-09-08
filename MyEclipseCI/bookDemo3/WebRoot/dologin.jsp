<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.etc.dao.UserDao" %>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dologin.jsp' starting page</title>
    
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
                          	
                          	if(name.equals("")||password.equals("")){
                          	System.out.print("用户名或密码为空");
                          	JOptionPane.showMessageDialog(null, "用户名或密码为空");
                          	response.sendRedirect("login.jsp");
                          	}else{
                          	UserDao userDao = new UserDao();
                          	boolean flag = userDao.checkLogin(name, password);
                          	if(flag==true){
                          	//JOptionPane.showMessageDialog(null, "登录成功");
                          	//将用户名保存在request属性范围
                          	request.setAttribute("name", name);
                          	//将用户名保存在session属性范围
                          	session.setAttribute("name", name);
                          	response.sendRedirect("book1.jsp");//request无效session有效
                          	//request.getRequestDispatcher("book1.jsp").forward(request, response);//request，session有效
                          	}else{
                          	response.sendRedirect("login.jsp");
                          	}
                          	}
    %>
  </body>
</html>
