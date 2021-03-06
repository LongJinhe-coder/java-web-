<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.etc.entity.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'personalzhuce.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
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
  Firm firm = (Firm)request.getAttribute("firm");
  System.out.println("firm-jsp="+firm);
  String adminName = (String)session.getAttribute("adminname");
  System.out.println("jsp-adminName="+adminName);
   %>
  
 <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend align="left" style="color:green;">企业信息</legend>
</fieldset>
<form class="layui-form" action="">

<div class="layui-form-item">
    <label class="layui-form-label">企业编号</label>
    <div class="layui-input-block">
      <input style="width:190px"type="text" name="firmID" value="${firm.firmID}" readonly="readonly"  autocomplete="off" class="layui-input">
    </div>
  </div>

 <div class="layui-form-item">  
      <label class="layui-form-label">企业用户名</label>
      <div class="layui-input-inline">
        <input type="text" name="firmAccount" value="${firm.firmAccount}" readonly="readonly" class="layui-input">
      </div>
      
      <label class="layui-form-label">注册时间</label>
      <div class="layui-input-inline">
       <input type="text" name="registerTime"  value="${firm.registerTime}" readonly="readonly" class="layui-input">
        
		</div>
    </div>
   
   <div class="layui-form-item">

    <label class="layui-form-label">公司名称</label>
    <div class="layui-input-block">
        <input type="text" name="firmName"  value="${firm.firmName}" readonly="readonly" class="layui-input">
    </div>
  </div>
   
   <div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">注册地区</label>
    <div class="layui-input-block">
     <input type="text" name="registerArea"  value="${firm.registerArea}" readonly="readonly" class="layui-input">  
    </div>
  </div>
   </div>
   
   <div class="layui-form-item">
   
    <label class="layui-form-label">公司性质</label>
    <div class="layui-input-inline">
      <input type="text" name="firmNature" value="${firm.firmNature}" readonly="readonly"  class="layui-input">
    </div>
    <label class="layui-form-label">注册资金</label>
    <div class="layui-input-inline">
      <input type="text" name="registerFund" value="${firm.registerFund}" readonly="readonly" class="layui-input">
    </div>
    <label class="layui-form-label">联系人</label>
    <div class="layui-input-inline">
      <input type="text" name="linkMan" value="${firm.linkMan}" readonly="readonly" class="layui-input">
    </div>
  </div>
   
    <div class="layui-form-item">
     <label class="layui-form-label">公司简介</label>
    <div class="layui-input-block">
    <input type="text" name="firmBrief" value="${firm.firmBrief}" readonly="readonly" class="layui-input">
    </div>
  </div>
   
    <div class="layui-form-item">
    <label class="layui-form-label">公司地址</label>
    <div class="layui-input-block">
    <input type="text" name="firmArea" value="${firm.firmArea}" readonly="readonly" class="layui-input">
    </div>
    </div>
   
   <div class="layui-form-item">
    <label class="layui-form-label">联系电话</label>
    <div class="layui-input-inline">
      <input type="text" name="linkPhone" value="${firm.linkPhone}" readonly="readonly" class="layui-input">
    </div>
  </div>
   
   <div class="layui-form-item">
      <div class="layui-inline">
      <label class="layui-form-label">注册号</label>
      <div class="layui-input-inline" >
        <input type="text" name="registerNum" value="${firm.registerNum}" readonly="readonly" class="layui-input">
      </div>
    <label class="layui-form-label">企业邮箱</label>
    <div class="layui-input-inline">
      <input type="text" name="firmEmail" value="${firm.firmEmail}" readonly="readonly" class="layui-input">
    </div>
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">审核状态</label>
    <div class="layui-input-inline">
      <input type="text" name="checkStatus" value="${firm.checkStatus}" readonly="readonly" class="layui-input">
    </div>
  </div>
  
   
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">企业密码</label>
      <div class="layui-input-inline">
        <input type="text" name="frimpwd"  value="${firm.firmPwd}" readonly="readonly" class="layui-input">
      </div>
    </div>
    
     <div class="layui-form-item">

      <label class="layui-form-label">账号状态</label>
      <div class="layui-input-inline">
        <input type="text" name="accountStatus"  value="${firm.accountStatus}" readonly="readonly" class="layui-input">
      </div>
    </div>
    </div>
    
    <div class="layui-form-item">  
      <div class="layui-input-inline" style="margin-left:50px">
        <button type="button" class="layui-btn" onclick="boolPassCheck(${firm.firmID},'审核通过' )">通过审核</button>
      </div>
      
      <div class="layui-input-inline">
       <button type="button" class="layui-btn layui-btn-warm" onclick="boolPassCheck(${firm.firmID},'审核不通过' )">不通过审核</button>
		</div>
    </div>
  </form>
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

  </body>
  <script type="text/javascript">
	function boolPassCheck(firmID,status){
	
		location.href="FirmServlet?option=boolPassCheck&firmID="+firmID+"&checkstatus="+status+"&url=firmAccount.jsp";
	}
</script>
</html>