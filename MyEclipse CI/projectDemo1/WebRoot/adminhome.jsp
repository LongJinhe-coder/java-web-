<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.etc.entity.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>招聘网后台管理</title>
  <link rel="stylesheet" href="layui/css/layui.css">
</head>


<body class="layui-layout-body">
<%
	String loadPageUrl = "index.jsp";
	String adminName = (String)request.getAttribute("adminname");
  if(session.getAttribute("url")!=null){
  loadPageUrl = (String)session.getAttribute("url");
  }
  //if(loadPageUrl.equals("jobSeekers.jsp")){//根据loadPageUrl不同给不同界面传递不同的list
  // List<User> list = (List<User>)request.getAttribute("userlist");
  //}
	PageData pagedata = (PageData)request.getAttribute("pagedata");
  	System.out.println("adminhome-pagedata="+pagedata);
  	String adminname = (String)session.getAttribute("adminname");
 %>
<div class="layui-layout layui-layout-admin">
  <div class="layui-header layui-bg-cyan">
    <div class="layui-logo">招聘网后台管理系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    
    <ul class="layui-nav layui-layout-right ">
      <li class="layui-nav-item layui-bg-cyan">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
           ${adminname} 
        </a>
      </li>
      <li class="layui-nav-item"><a href="login.jsp">退出登录</a></li>
    </ul>
  </div>
  
  <div class="layui-side  layui-bg-cyan">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:">用户管理</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:getFirm('firmAccount.jsp');">企业</a></dd>
            <dd><a href="javascript:getUser('userAccount.jsp');">用户</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:">招聘信息</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:changeUrl('checkJobs.jsp');">待审核</a></dd>
            <dd><a href="javascript:changeUrl('publishedJobs.jsp');">已发布</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;">广告信息</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:changeUrl('displayFirmResume.jsp');">待审核</a></dd>
            <dd><a href="javascript:;">已发布</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="javascript:getFirm('checkFirmRegister.jsp');">企业审核</a></li>
        <li class="layui-nav-item"><a href="javascript:changeUrl('addAdmin.jsp')">新增管理员</a></li>
      </ul>
      
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
 <div style="margin-top: 20px">
 <jsp:include page="<%=loadPageUrl %>" flush="true">
 <jsp:param value="${pagedata}" name="pagedata"/>
 <jsp:param value="${adminname}" name="adminname"/>
 </jsp:include>
 </div>
    
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
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
	location.href="ChangeUrlServlet?url="+name+"";
	
}
function getUser(url){
	location.href="UserServlet?option=queryByPage&url="+url+"";
}

function getFirm(url){
	location.href="FirmServlet?option=queryByPage&url="+url+"";
}

</script>
</body>
</html>
