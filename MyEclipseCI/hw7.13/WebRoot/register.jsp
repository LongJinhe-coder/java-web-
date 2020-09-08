<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'book.jsp' starting page</title>
    
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
  
  <form action="showInfo.jsp">
  <table align="center">
  	<tr>
		<td align="right"> 用户名：</td>
		<td><input type="text" name = "username">(必填)</td>
	</tr>
	<tr>
		<td align="right">   密码：</td>
		<td><input type="password" name = "password">(必填)</td>
	</tr>
	<tr>
		<td align="right">    确认密码：</td>
		<td><input type="password" name = "password2"></td>
	</tr>
     <tr>
		<td align="right">  性别：</td>
		<td><input type="radio" name="sex" value="男" checked="true"/>男&nbsp;&nbsp;
		<input type="radio" name="sex" value="女"/>女</td>
	</tr>
	 <tr>
		<td align="right">  爱好：</td>
		<td><input type="checkbox" name="interset" id="" value="计算机" />计算机
		<input type="checkbox" name="interset" id="" value="音乐" />音乐
		<input type="checkbox" name="interset" id="" value="体育" />体育
		<input type="checkbox" name="interset" id="" value="文学" />文学</td>
	</tr>
	<tr>
		<td align="right"> 星座：</td>
		<td>
		<select name="select">
		<option value="水瓶座">水瓶座</option>
		<option value="射手座">射手座</option>
		<option value="白羊座" selected="true">白羊座</option>
		</select>
		</td>
	</tr>
  	<tr>
		<td align="right">   个人简介：</td>
		<td><textarea name="introduce" rows="5" cols="10">
		大家好，我是xxx，我是软件工程二班的学生
		</textarea></td>
	</tr>	
	<tr>
		<td align="right"><input type="submit" value="注册"></td>
		<td><input type="reset" value="重置"></td>
	</tr>	
    </table>
   </form>

  </body>
</html>
