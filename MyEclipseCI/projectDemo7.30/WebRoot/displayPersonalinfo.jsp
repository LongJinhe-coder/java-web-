<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.etc.dao.UserDao" %>
<%@ page import="com.etc.entity.User" %>
<%@page import="com.etc.entity.Resume"%>
<%@ page import="com.etc.dao.ResumeDao" %>
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
		int id=0;
		for(User user : list) {
			if(adminName.equals(user.getUserName())){
			userRe=user;
			id=user.getUserID();
			System.out.println("yes");
			}
			//System.out.println(user);
		}
			ResumeDao resumeDao=new ResumeDao();
		List<Resume> list2  =  resumeDao.queryAllResumes();
		Resume resume=new Resume();
		for(Resume re : list2) {
		if(id==(re.getUser().getUserID())){
			resume=re;
			System.out.println(resume);
			//System.out.println("okok3");
		}
		}
 %>
 <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend align="left" style="color:green;">个人信息</legend>
</fieldset>
<table class="layui-table">
  		<tbody>
  		<tr>
  				<td ><b>用户编号</b></td>
  				<td><%=userRe.getUserID() %></td>
  			</tr>
  			<tr>
  				<td ><b>用户名</b></td>
  				<td><%=userRe.getUserName() %></td>
  			</tr>
  			<tr>
  				<td><b>姓名</b></td>
  				<td><%=resume.getName()%></td>
  			</tr>
  			<tr>
  				<td><b>性别</b></td>
  				<td><%=resume.getSex()%></td>
  			</tr>
  			<tr>
  				<td ><b>出生日期</b></td>
  				<td><%=resume.getBirthDate()%></td>
  			</tr>
  			<tr>
  				<td><b>邮箱</b></td>
  				<td><%=userRe.getEmail()%></td>
  			</tr>
  			<tr>
  				<td><b>手机号</b></td>
  				<td><%=userRe.getAvatarName()%></td>
  			</tr>
  			<tr>
  				<td ><b>毕业学校</b></td>
  				<td><%=resume.getSchool()%></td>
  			</tr>
  			<tr>
  				<td ><b>最高学历</b></td>
  				<td><%=resume.getDegree() %></td>
  			</tr>
  			<tr>
  				<td ><b>所学专业</b></td>
  				<td><%=resume.getLearnMajor()%></td>
  			</tr>
  			<tr>
  				<td><b>密码</b></td>
  				<td><%=userRe.getUserPwd()%></td>
  			</tr>
  		</tbody>
	</table>
</body>
</html>        
