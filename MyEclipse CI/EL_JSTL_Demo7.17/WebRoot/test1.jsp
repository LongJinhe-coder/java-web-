<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test1.jsp' starting page</title>
    
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
   <center>
   	<table border="1">
   	<tr>
   		<td>说明</td>
   		<td>EL表达式</td>
   		<td>结果</td>
   	
   	</tr>
   	<tr>
   		<td>加</td>
   		<td>\${1+2}</td>
   		<td>${1+2}</td>
   	</tr>
   	<tr>
   		<td>取余</td>
   		<td>\${10%3}</td>
   		<td>${10%3}</td>
   	</tr>
   	<tr>
   		<td>与</td>
   		<td>\${true and false}</td>
   		<td>${true and false}</td>
   	</tr>
   	<tr>
   		<td>大于</td>
   		<td>\${10>5}</td>
   		<td>${10>5}</td>
   	</tr>
   	<tr>
   		<td>三目运算符</td>
   		<td>\${(10>5)?10:5}</td>
   		<td>${(10>5)?10:5}</td>
   	</tr>
   	<tr>
   		<td>empty</td>
   		<td>\${empty "2020"}</td>
   		<td>${empty "2020"}</td>
   	</tr>
   	<tr>
   		<td>empty</td>
   		<td>\${empty null}</td>
   		<td>${empty null}</td>
   	</tr>
   	<tr>
   		<td>自动类型转换</td>
   		<td>\${true}\${false}</td>
   		<td>${true}${false}</td>
   	</tr>	
   	<tr>
   		<td>自动类型转换</td>
   		<td>\${"123.45"+1.2}</td>
   		<td>${"123.45"+1.2}</td>
   	</tr>	
   	
   	</table>
   
   
   
   
   </center>
  </body>
</html>
