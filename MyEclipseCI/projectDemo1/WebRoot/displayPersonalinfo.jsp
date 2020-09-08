<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.etc.dao.UserDao" %>
<%@ page import="com.etc.entity.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<%	
	String adminName = (String)session.getAttribute("adminname");
  System.out.println("yonghuming"+adminName);
		UserDao userdao  =  new UserDao();
		List<User> list  =  userdao.queryAllUsers();
		User userRe=new User();
		for(User user : list) {
			if(adminName.equals(user.getUserName())){
			userRe.setEmail(user.getEmail());
			userRe.setUserPwd(user.getUserPwd());
			userRe.setAvatarName(user.getAvatarName());
			System.out.println("yes");
			}
			System.out.println(user);
		}
 %>
 <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend align="left" style="color:green;">个人信息</legend>
</fieldset>
<table class="layui-table">
  <colgroup>
    <col width="150">
    <col width="200">
    <col width="200">
  </colgroup>
  <thead>
    <tr>
      <th>姓名</th>
      <th>用户名（邮箱）</th>
      <th>手机号</th>
      <th>密码</th>
      
    </tr> 
  </thead>
  <tbody>
  <tr>
      <td>${adminname}</td>
      <td><%=userRe.getEmail()%></td>
      <td><%=userRe.getAvatarName()%></td>
      <td><%=userRe.getUserPwd() %></td>
    </tr>

  </tbody>
</table>
</body>
</html>        
