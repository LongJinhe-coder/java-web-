<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>企业管理</title>
  <link rel="stylesheet" href="layui/css/layui.css">
</head>


<body class="layui-layout-body">
<%
	String loadPageUrl = "index.jsp";
  if(session.getAttribute("url")!=null){
  loadPageUrl = (String)session.getAttribute("url");
  }
 %>
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">企业管理界面</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    
    <ul class="layui-nav layui-layout-right ">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          企业
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
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
          <a class="" href="javascript:">招聘管理</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:changeUrl('sendRecruitment.jsp');">发布企业招聘</a></dd>
            <dd><a href="javascript:changeUrl('recruitmentInfo.jsp')">招聘信息</a></dd>

          </dl>
        </li>
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:">广告信息</a>
          <dl class="layui-nav-child">
           <dd><a href="javascript:">发布广告</a></dd>
            <dd><a href="javascript:">待审核</a></dd>
            <dd><a href="javascript:">已发布</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;">企业信息</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:changeUrl('displayFirmResume.jsp');">查看信息</a></dd>
            <dd><a href="javascript:;">修改信息</a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
 <div style="margin-top: 20px"><jsp:include page="<%=loadPageUrl %>" flush="true" /></div>
    
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
	location.href="ChangeUrlServlet2?url="+name+"";
	
}
</script>
</body>
</html>
