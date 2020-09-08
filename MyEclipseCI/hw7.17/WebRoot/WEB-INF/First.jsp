<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 核心库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'First.jsp' starting page</title>
    
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
   <c:if test="${status}">
    	<script type="text/javascript">alert("用户名或密码错误")</script>
    </c:if>
  
    <form action="Second.jsp">
    	<input type="text" name="username" value="${username }"></input><br/>
    	<input type="password" name="password" value="${password }"></input><br/>
    	<input type="submit" value="提交"></input>
    	<input type="reset" value="清除"></input>
    </form>
  </body>
</html>
