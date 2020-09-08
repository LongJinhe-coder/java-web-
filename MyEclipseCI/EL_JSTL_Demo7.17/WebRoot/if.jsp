<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 核心库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 数据库存储 -->
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'if.jsp' starting page</title>
    
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
    <c:out value="${1+2}"></c:out>
    
    <h4>根据当前时间输出不同的问候语言</h4>
    <%
    Calendar cal = Calendar.getInstance();
    Integer Hour = cal.get(Calendar.HOUR_OF_DAY);
    request.setAttribute("hour", Hour);
     %>
     
     <c:out value="${hour}"></c:out>
     <h5>采用单分支标签实现</h5>
     <c:if test="${hour>=0&&hour<=11}">上午好</c:if>
     <c:if test="${hour>11&&hour<=17}">下午好</c:if>
     <c:if test="${hour>17&&hour<24}">晚上好</c:if>
     <h5>采用多分支标签实现</h5>
     <c:choose>
     	<c:when test="${hour>=0&&hour<=11}">上午好</c:when>
     	<c:when test="${hour>11&&hour<=17}">下午好</c:when>
     	<c:otherwise>晚上好</c:otherwise>
     </c:choose>
     <h5>1825122033龙金河</h5>
  </body>
</html>
