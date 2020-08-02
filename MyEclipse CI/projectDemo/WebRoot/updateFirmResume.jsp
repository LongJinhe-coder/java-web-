<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.etc.entity.*" %>
<%@ page import="com.etc.dao.*" %>
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
  int firmID=Integer.parseInt(session.getAttribute("firmID").toString());
  System.out.println("firmID---------->"+firmID);

  
  System.out.println();
  FirmDao fdao=new FirmDao();
  Firm firm=fdao.queryByID(firmID);

  System.out.println("firm-jsp="+firm);
   %>
  
 <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend align="left" style="color:green;">企业信息</legend>
</fieldset>
<form class="layui-form" action="FirmServlet?">

<div class="layui-form-item">
    <label class="layui-form-label">企业编号</label>
    <div class="layui-input-block">
      <input style="width:190px"type="text" name="firmID" value="<%=firm.getFirmID() %>"  autocomplete="off" class="layui-input">
    </div>
  </div>

 <div class="layui-form-item">  
      <label class="layui-form-label">企业用户名</label>
      <div class="layui-input-inline">
        <input type="text" name="firmAccount" value="<%=firm.getFirmAccount() %>"  class="layui-input">
      </div>
      
      <label class="layui-form-label">注册时间</label>
      <div class="layui-input-inline">
       <input type="text" name="registerTime"  value="<%=firm.getRegisterTime() %>" class="layui-input">
        
		</div>
    </div>
   
   <div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">公司名称</label>
    <div class="layui-input-block">
        <input type="text" name="firmName"  value="<%=firm.getFirmName() %>"  class="layui-input">
    </div>
  </div>
   </div>
   
   <div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">注册地区</label>
    <div class="layui-input-block">
     <input type="text" name="registerArea"  value="<%=firm.getRegisterArea() %>"  class="layui-input">  
    </div>
  </div>
   </div>
   
   <div class="layui-form-item">
   
    <label class="layui-form-label">公司性质</label>
    <div class="layui-input-inline">
      <input type="text" name="firmNature" value="<%=firm.getFirmNature() %>"   class="layui-input">
    </div>
    <label class="layui-form-label">注册资金</label>
    <div class="layui-input-inline">
      <input type="text" name="registerFund" value="<%=firm.getRegisterFund() %>"  class="layui-input">
    </div>
    <label class="layui-form-label">联系人</label>
    <div class="layui-input-inline">
      <input type="text" name="linkMan" value="<%=firm.getLinkMan() %>"  class="layui-input">
    </div>
  </div>
   
    <div class="layui-form-item">
     <label class="layui-form-label">公司简介</label>
    <div class="layui-input-block">
    <input type="text" name="firmBrief" value="<%=firm.getFirmBrief() %>" class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">联系电话</label>
    <div class="layui-input-block">
      <input type="text" name="linkPhone" value="<%=firm.getLinkPhone() %>"  class="layui-input">
    </div>
  </div>
   
    <div class="layui-form-item">
    <div class="layui-inline">
    <label class="layui-form-label">公司地址</label>
    <div class="layui-input-inline">
    <input type="text" name="firmArea" value="<%=firm.getFirmArea() %>" class="layui-input">
    </div>
      <label class="layui-form-label">注册号</label>
      <div class="layui-input-inline" style="width: 100px;">
        <input type="text" name="registerNum" value="<%=firm.getRegisterNum() %>" class="layui-input">
      </div>
    </div>
  </div>
   <div class="layui-form-item">
   <div class="layui-inline">
    
  </div>
   </div>
   
      <div class="layui-form-item">
    <label class="layui-form-label">企业邮箱</label>
    <div class="layui-input-block">
      <input type="text" name="firmEmail" value="<%=firm.getFirmEmail() %>"  class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">审核状态</label>
    <div class="layui-input-block">
      <input type="text" name="checkStatus" value="<%=firm.getCheckStatus() %>"  class="layui-input">
    </div>
  </div>
   
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">企业密码</label>
      <div class="layui-input-inline">
        <input type="text" name="firmPwd"  value="<%=firm.getFirmPwd() %>"  class="layui-input">
      </div>
    </div>
    
     <div class="layui-form-item">

      <label class="layui-form-label">账号状态</label>
      <div class="layui-input-block">
        <input type="text" name="accountStatus"  value="<%=firm.getAccountStatus() %>" class="layui-input">
      </div>
    </div>
    
    
    <div class="layui-form-item">
      <div class="layui-input-block">
        <input type="text" name="option"  value="updateFirmResume"  style="display: none" class="layui-input">
      </div>
    </div>
    
    <div class="layui-form-item">
      <div class="layui-input-block">
        <input type="text" name="url"  value="updateFirmResume.jsp"  style="display: none" class="layui-input">
      </div>
    </div>
    
    </div>
    <div class="layui-form-item">    <div class="layui-input-block">
      <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
    
    </div>
  </div> 
    
  </form>
  
<script src="layui/layui.js" charset="utf-8"></script>

  </body>
</html>