<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<head>
  <title>用户登录</title>
  <meta charset="utf-8" />
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
  <script src="../layui/layui.all.js" charset="utf-8"></script>
 </head>
  <body>
  <%
  String info = (String)request.getAttribute("info");
  System.out.println("jsp-info="+info);
  if(info!=null){JOptionPane.showMessageDialog(null, info);}
   %>
  
  <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend align="left">用户登录</legend>
</fieldset>

<div style="margin-top: 10%">
   <form class="layui-form" id="form">
   
  <div class="layui-container">
  	<div class="layui-form-item">
    <label class="layui-form-label" style="margin-left:310px ;width: 100px;"><i class="layui-icon layui-icon-group"></i>用户类型：</label>
    <div class="layui-input-inline " style="margin-left: 35px">
      <select name="type" id = "sel">
      	
      	<c:choose>
      		<c:when test="${type eq '企业'}">
      			<option></option>
      			<option value="企业" selected="selected">企业</option>
		        <option value="应聘者">求职者</option>
		        <option value="管理员">管理员</option>
      		</c:when>
      		<c:when test="${type eq '应聘者'}">
      			<option></option>
      			<option value="企业">企业</option>
		        <option value="应聘者" selected="selected">求职者</option>
		        <option value="管理员">管理员</option>
      		</c:when>
      		<c:when test="${type eq '管理员'}">
      			<option></option>
      			<option value="企业">企业</option>
		        <option value="应聘者">求职者</option>
		        <option value="管理员" selected="selected">管理员</option>
      		</c:when>
      		<c:otherwise>
      			<option></option>
		      	<option value="企业">企业</option>
		        <option value="应聘者">求职者</option>
		        <option value="管理员">管理员</option>
      		</c:otherwise>
      	</c:choose>
      </select>
    </div>
  </div>
  	
   <div class="layui-row" style="margin-bottom: 10px">
    <div class="layui-col-md2  layui-col-md-offset3" ><i class="layui-icon layui-icon-username" style="font-size: 30px;"></i><label class="layui-form-label">用户名:</label></div>
      <div class="layui-col-md4">
      <input type="text" name="email" lay-verify="username"  placeholder="请输入username" class="layui-input" value="${email}">
      </div>
    <div class="layui-col-md3" ></div>
    </div>
    
    <div class="layui-row" style="margin-bottom: 10px">
   <div  class="layui-col-md2 layui-col-md-offset3 "><i class="layui-icon layui-icon-password" style="font-size: 30px;"></i><label class="layui-form-label">密码:</label></div>
    <div class="layui-col-md4">
      <input type="password"  name="password" lay-verify="title" autocomplete="off" placeholder="请输入password" class="layui-input" value="${userpwd}">
    </div>
    <div class="layui-col-md3" ></div>
    </div>
    
    <div class="layui-row" style="margin-bottom: 10px">
   <div  class="layui-col-md2  layui-col-md-offset3"><i class="layui-icon layui-icon-release" style="font-size: 30px;"></i><label class="layui-form-label">验证码:</label></div>
    <div class="layui-col-md2">
      <input type="text" name="checkcode" lay-verify="check" autocomplete="off" placeholder="请输入验证码" class="layui-input">
    </div>
    
    <div class="layui-col-md2">
        <img border="0" src="checkcode" />
	   <input class="layui-btn layui-btn-radius" type="submit" value="换一张" onclick="document.getElementById('form').action='changecheckcode'"/>
    </div>
    </div>
    
  <hr></hr>
  
  <div class="layui-row">
   <div class="layui-col-md2 layui-col-md-offset4 "><input type="button" id="Login" onclick="doLogin()" class="layui-btn layui-btn-radius" style="width: 150px;"value="登录"/></div>
    <div class="layui-col-md2 layui-col-md-offset1"><input type="button" id="register"  onclick="doRegister()" class="layui-btn layui-btn-radius" style="width: 150px;"value="注册"/></div>
 </div>
</div>
   
  </form>
  </div>

  </body>
  
   <script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
});

   function doRegister(){
   var x=document.getElementById("form");
        x.action="firmregister.jsp";
        x.submit();
   
   }
   

   function doLogin(){
     var x=document.getElementById("form");
        x.action="logcheck";
        x.submit();
   }
   
</script>
</html>