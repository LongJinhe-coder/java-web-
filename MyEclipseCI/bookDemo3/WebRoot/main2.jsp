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
    
    <title>My JSP 'main2.jsp' starting page</title>
    
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
   //获取logincheck.jsp 传递的用户名
   String name = (String)session.getAttribute("username");
   System.out.print("session中用户名"+name);
   Cookie cookie = null;
   if(name==null||name.equals("")){  //seesion中用户名为空，说明没有登录
   //获取cookie的一些属性值
	   Cookie[] cs = request.getCookies();
	    for (int i = 0; i <cs.length; i++){
         cookie = cs[i]; //索引
           System.out.print("参数名 : " + cookie.getName());
       
         System.out.print("参数值: " + URLDecoder.decode(cookie.getValue(), "utf-8") +" <br>");
         
         }
	   System.out.print("cookie的信息"+cs);
	   String value= null;//属性值
	   if(cs!=null){
	   for(int i =0 ;i<cs.length;i++){
	   	   //获取cookie对象中的name值
	   	   if(cs[i].getName().equals("username")){
	   	   		value = cs[i].getValue();
	   	   		out.print("参数值 : " + value);
	   	          
	   	   }
	      }
	   
	      }
	      if(value!=null&&!name.equals("")){
	      	out.print(value+"登录成功");
	      	response.sendRedirect("book1.jsp");
	   }else{
	   		out.print("您还没登录，请先登录");
	      	//response.sendRedirect("login.jsp");
	      	response.setHeader("Refresh", "3,url=login.jsp");
	   }
   }else{
   //用户名不为空，说明登录
  	    out.print(name+"登录成功");
  	    System.out.print(name+"登录成功");
      //	response.sendRedirect("book.jsp");
      	response.setHeader("Refresh", "3,url=book1.jsp");
   }
    
    %>
  </body>
</html>
