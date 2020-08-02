<%@page import="com.etc.dao.RecruitDao"%>
<%@page import="com.etc.entity.RecruitmentInformation"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  <% 
  
  RecruitmentInformation ri=(RecruitmentInformation)request.getAttribute("recuritmentInfo");
  RecruitDao rdao=new RecruitDao();
  
  int firmID=Integer.parseInt(session.getAttribute("firmID").toString());
	 System.out.println("我拿到firmID------------->"+firmID);
 //System.out.println("test-------------------------->"+ri.getRecruitmentID()); 
  %>
  <body>


 <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend align="left" style="color:green;">招聘信息展示/详细</legend>
</fieldset>
<form class="layui-form"  id="form" action="">
<div class="layui-form-item">
    <label class="layui-form-label">招聘编号</label>
    <div class="layui-input-inline">
      <input type="text" name="recruitmentID"  value=<%=ri.getRecruitmentID() %> autocomplete="off" class="layui-input">
    </div>
    
    <label class="layui-form-label">企业编号</label>
     <div class="layui-input-inline">
      <input type="text" name="firmID" value=<%=ri.getFirmID().getFirmID()%> autocomplete="off" class="layui-input">
    </div>
  </div>


    
 <div class="layui-form-item">  
    <label class="layui-form-label">招聘岗位</label>  
    <div class="layui-input-inline">
      <input type="text" name="position"  value=<%=rdao.getPositionName(ri.getPositionID().getPositionID()) %> autocomplete="off" class="layui-input">
    </div>

    <label class="layui-form-label">岗位编号</label>  
    <div class="layui-input-inline">
      <input type="text" name="positionID" value=<%=ri.getPositionID().getPositionID() %>  autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
      <label class="layui-form-label">管理员编号</label>
      <div class="layui-input-inline">
        <input type="text" name="adminID" value=<%=ri.getAdminID().getAdminID()%> class="layui-input">
      </div>
 </div>
 
 <div class="layui-form-item">
      <label class="layui-form-label">岗位描述</label>
      <div class="layui-input-inline">
        <input type="text" name="positionDescribe" value=<%=ri.getPositionDescribe() %> style="width:500px" class="layui-input">
      </div>
 </div>
 
<div class="layui-form-item">
      <label class="layui-form-label">招聘数量</label>
      <div class="layui-input-inline">
       <input type="text" name="count"  value=<%=ri.getCount() %> class="layui-input">
        
		</div>
		
    <label class="layui-form-label">员工薪资</label>
    <div class="layui-input-inline">
        <input type="text" name="salary" value=<%=ri.getSalary()%> class="layui-input">
     </div> 
    
  </div>
  
   <div class="layui-form-item">
   
    <label class="layui-form-label">年龄要求</label>
    <div class="layui-input-block" style="width:500px">
     <input type="text" name="age"  value=<%=ri.getAge() %> class="layui-input">  
    </div>
  </div>

   <div class="layui-form-item">
   
    <label class="layui-form-label">联系电话</label>
    <div class="layui-input-block" style="width:500px">
     <input type="text" name="phone"   class="layui-input">  
    </div>
  </div>
  
   <div class="layui-form-item">
   
    <label class="layui-form-label">工作地址</label>
    <div class="layui-input-block" style="width:500px">
     <input type="text" name="address"   class="layui-input">  
    </div>
  </div>
 
 <div class="layui-form-item">
   
    <label class="layui-form-label">截止日期</label>
    <div class="layui-input-inline" style="width:250px">
     <input type="text" placeholder="请选择截止时间" id="date" value=<%=ri.getDueDate() %> name="dueDate"   class="layui-input">  
    </div>
     <i class="layui-input-inline layui-icon layui-icon-date"  style="font-size:35px;"></i>
  </div>
  
  
  <div class="layui-form-item">   

      <button type="button" class="layui-btn layui-btn-sm" onclick="goBack()" style="margin-left:10px">返回</button>

  </div> 
  </form> 
 
 
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  //日期
  laydate.render({
        elem: '#date' //指定元素
        ,eventElem: '.layui-icon-date'
        ,trigger: 'click'
  });
  laydate.render({
    elem: '#date1'
  });
  
  
  
});
  
function goBack(){
  var firmID=<%=firmID%>
   location.href="RecruitmentInfo?option=queryByPage&firmID="+firmID+"&url=recruitmentInfo.jsp";
}

</script>
  </body>
</html>