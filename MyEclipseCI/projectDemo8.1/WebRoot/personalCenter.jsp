<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.etc.dao.UserDao" %>
<%@ page import="com.etc.entity.User" %>
<%@ page import="com.etc.dao.ResumeDao" %>
<%@ page import="com.etc.entity.Resume" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>个人中心</title>
  <link rel="stylesheet" href="layui/css/layui.css">
</head>


<body class="layui-layout-body">
<%
	String loadPageUrl = "index.jsp";
	String adminName = (String)session.getAttribute("adminname");
  if(session.getAttribute("url")!=null){
  loadPageUrl = (String)session.getAttribute("url");
  System.out.println("用户名"+adminName);
  }
 
 %>
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">个人中心</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    
    <ul class="layui-nav layui-layout-right ">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="layui/images/face/61.gif" class="layui-nav-img">
         ${adminname} ，你好
        </a>
        <dl class="layui-nav-child">
          <dd><a href="javascript:changeUrl('displayPersonalinfo.jsp');">基本信息</a></dd>
          <dd><a href="javascript:changeUrl('displayPersonalResume.jsp');">个人简历</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="login.jsp">退出登录</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:">个人信息</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:changeUrl('displayPersonalinfo.jsp');">查看个人信息</a></dd>
            <dd><a href="javascript:changeUrl('changepersonalinfo.jsp');">修改个人信息</a></dd>
          </dl>
 		<li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:">我的简历</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:changeUrl('displayPersonalResume.jsp');">查看简历</a></dd>
            <dd><a href="javascript:changeUrl('changePersonalResume.jsp');">修改简历</a></dd>
            <dd><a href="javascript:changeUrl('personalResumes.jsp');">新增简历</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="javascript:changeUrl('personalNews.jsp');">我的消息</a></li>
        <li class="layui-nav-item"><a href="#">返回首页</a></li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
 <div style="margin-top: 20px"><jsp:include page="<%=loadPageUrl %>" flush="true" /></div>
    
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © hqu招聘会馆 - higher brothers
  </div>
</div>
<script src="layui/layui.js"></script>
<script type="text/javascript">
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});

function changeUrl(name){

console.log("name=",name);
	location.href="PersonalCenter?url="+name+"";
	
}


</script>
</body>
</html>
