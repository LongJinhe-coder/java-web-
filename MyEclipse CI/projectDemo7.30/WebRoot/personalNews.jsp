<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.etc.entity.Resume"%>
<%@page import="com.etc.entity.Message"%>
<%@ page import="com.etc.dao.UserDao" %>
<%@ page import="com.etc.entity.User" %>
<%@ page import="com.etc.dao.ResumeDao" %>
<%@ page import="com.etc.dao.MessageDao" %>
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
 		System.out.println("用户名"+adminName);
		UserDao userdao  =  new UserDao();
		List<User> list  =  userdao.queryAllUsers();
		User userRe=new User();
		int id=0;
		for(User user : list) {
			if(adminName.equals(user.getUserName())){
			id=user.getUserID();
			userRe.setEmail(user.getEmail());
			userRe.setUserPwd(user.getUserPwd());
			userRe.setAvatarName(user.getAvatarName());
			userRe.setUserID(user.getUserID());
			System.out.println("userid="+id);
			}
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
		MessageDao messagedao = new MessageDao();
		List<Message> list3 =  messagedao.queryAllMessages(resume.getUserInfoID());
		int i = 1;
	 %>
 <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend align="left" style="color:green;">我的消息</legend>
</fieldset>
<table class="layui-table">
  <colgroup>
    <col width="150">
	<col width="150">
	<col width="150">
	<col width="150">
	<col width="750">
  </colgroup>
<thead>
			<tr>
				<th id="id">编号</th>
				<th>企业名称</th>
				<th>联系方式</th>
				<th>应聘状态</th>
				<th>企业留言</th>
				<th>操作</th>
			</tr>
		</thead>
		<%for(Message r:list3) { %>
		<tbody>

			<tr>
				<td><%=r.getUserInfoID() %></td>
				<td><%=r.getFirmName() %></td>
				<td><%=r.getLinkPhone() %></td>
				<td><%=r.getHandleStatus() %></td>
				<td><%=r.getMessage() %></td>
				<td><button type="button" class="layui-btn" onclick="deleteMessage(<%=r.getUserInfoID()%>)">删除</button></td>
			</tr>

		</tbody>
		<%
		   System.out.println(r);
		  } 
		  %>
</table>
<script>
function deleteMessage(message){
var recruitmentID=message;
alert(recruitmentID);
location.href="MessageServlet?option=deleteMessage&recruitmentID="+recruitmentID+"";
}
</script>
</body>
</html>        
