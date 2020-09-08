<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
   <h2 align="center">学生注册信息</h2>
		<!--form 表单 -->
		<form name="student" method="get" action="doSubmit.jsp">
			<table>
				<tr>
					<td>姓名：</td>
					<!-- 文本框-->
					<td><input type="text" name="username"/></td>
					
				</tr>
				<tr>
					<td>性别：</td>
					<!--单选按钮 -->
					<!--空格 &nbsp -->
					<td>
						<input type="radio" name="sex" checked="checked" value="男"/> 男&nbsp;&nbsp;
						<input type="radio" name="sex" value="女"/> 女
					</td>	
				</tr>
				<tr>
					<td>出生日期</td>
					<!--日期-->
					<td><input type="date" name="Birthday"/></td>					
				</tr>
				<tr>
					<td>学校：</td>
					<!-- 文本框-->
					<td><input type="text" name="school"/></td>
				</tr>
				<tr>
					<td>专业</td>
					<td>
						<select name="select">
							<option value="计算机科学与技术" selected>计算机科学与技术</option>
							<option value="软件工程">软件工程</option>
							<option value="人工智能">人工智能</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>体育特长</td>
					<!--复选框-->
					<td>
						<input type="checkbox" name="hobby" value="篮球" checked/>篮球&nbsp;&nbsp;
						<input type="checkbox" name="hobby" value="足球"/>足球<br/>
						<input type="checkbox" name="hobby" value="排球"/>排球&nbsp;&nbsp;
						<input type="checkbox" name="hobby" value="羽毛球"/>羽毛球<br/>	
					</td>
				</tr>
				<tr>
					<td>上传照片</td>
					<!--文件域-->
					<td>
						<input  type="file"/>
					</td>
				</tr>
				<tr>
					<td>密码</td>
					<!--密码 ****-->
					<td>
						<input  type="password" name="pwd"/>						
					</td>
				</tr>
				<tr>
					<td>个人简介</td>
					<td>
						<textarea cols="10" rows="10" name="info">	
						    大家好，我是华侨大学软件工程的学生。
						</textarea>						
					</td>
				</tr>

				<tr>
					<td>
						<!--响应action-->
						<input type="submit" value="注册">&nbsp;&nbsp;
						<!--注册信息清除-->
						<input type="reset" value="取消">
					</td>

				</tr>
				
				
			</table>

		</form>
		
  </body>
</html>
