<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.etc.entity.*" %>
<%@page import="com.etc.dao.RecruitDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  RecruitmentInformation ri = (RecruitmentInformation)request.getAttribute("recruitmentInformation");
  System.out.println("recruitmentInformation-jsp="+ri);
  RecruitDao rdao=new RecruitDao();
  String checkStatus = ri.getCheckStatus();
  System.out.println("checkStatus="+checkStatus);
   %>
  
 <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend align="left" style="color:green;">招聘信息</legend>
</fieldset>
<form class="layui-form"  action="">
<div class="layui-form-item">
    <label class="layui-form-label">招聘编号</label>
    <div class="layui-input-inline">
      <input type="text" name="recruitmentID" readonly="readonly"  value=<%=ri.getRecruitmentID()%>  class="layui-input">
    </div>
    
    <label class="layui-form-label">企业编号</label>
     <div class="layui-input-inline">
      <input type="text" name="firmID" readonly="readonly" value=<%=ri.getFirmID().getFirmID()%> autocomplete="off" class="layui-input">
    </div>
  </div>


    
 <div class="layui-form-item">  
    <label class="layui-form-label">招聘岗位</label>  
    <div class="layui-input-inline">
      <input type="text" name="position" readonly="readonly" value=<%=rdao.getPositionName(ri.getPositionID().getPositionID()) %> autocomplete="off" class="layui-input">
    </div>

    <label class="layui-form-label">岗位编号</label>  
    <div class="layui-input-inline">
      <input type="text" name="positionID" readonly="readonly" value=<%=ri.getPositionID().getPositionID() %>  autocomplete="off" class="layui-input">
    </div>
  </div>
  
  
 
 <div class="layui-form-item">
      <label class="layui-form-label">岗位描述</label>
      <div class="layui-input-inline">
        <input type="text" name="positionDescribe" readonly="readonly" value=<%=ri.getPositionDescribe() %> style="width:500px" class="layui-input">
      </div>
 </div>
 
<div class="layui-form-item">
      <label class="layui-form-label">招聘数量</label>
      <div class="layui-input-inline">
       <input type="text" name="count" readonly="readonly"  value=<%=ri.getCount() %> class="layui-input">
        
		</div>
		
    <label class="layui-form-label">员工薪资</label>
    <div class="layui-input-inline">
        <input type="text" name="salary" readonly="readonly" value=<%=ri.getSalary()%> class="layui-input">
     </div> 
    
  </div>
  
   <div class="layui-form-item">
   
    <label class="layui-form-label">年龄要求</label>
    <div class="layui-input-block" style="width:500px">
     <input type="text" name="age" readonly="readonly" value=<%=ri.getAge() %> class="layui-input">  
    </div>
  </div>

   <div class="layui-form-item">
   
    <label class="layui-form-label">联系电话</label>
    <div class="layui-input-block" style="width:500px">
     <input type="text" name="phone" readonly="readonly" value=<%=rdao.getFirmPhone(ri.getFirmID().getFirmID()) %> class="layui-input">  
    </div>
  </div>
  
   <div class="layui-form-item">
   
    <label class="layui-form-label">工作地址</label>
    <div class="layui-input-block" style="width:500px">
     <input type="text" name="address" readonly="readonly" value=<%=rdao.getFirmArea(ri.getFirmID().getFirmID()) %> class="layui-input">  
    </div>
  </div>
 
 <div class="layui-form-item">
   
    <label class="layui-form-label">截止日期</label>
    <div class="layui-input-inline" style="width:250px">
     <input type="text" placeholder="请选择截止时间" id="date" readonly="readonly" value=<%=ri.getDueDate() %> name="dueDate"   class="layui-input">  
    </div>
     <i class="layui-input-inline layui-icon layui-icon-date"  style="font-size:35px;"></i>
  </div>
  
  
  <div class="layui-form-item"> 
  <%if(checkStatus.equals("未审核")){ %>
      	<div class="layui-input-inline" style="margin-left:50px">
        <button type="button" class="layui-btn" onclick="boolPassCheck('<%=ri.getRecruitmentID()%>','已发布' )">通过审核</button>
      </div>
      
      <div class="layui-input-inline">
       <button type="button" class="layui-btn layui-btn-warm" onclick="boolPassCheck('<%=ri.getRecruitmentID()%>','审核不通过' )">不通过审核</button>
		</div>	
	<%} %>
	<!--  
	<%if(checkStatus.equals("已发布")){ %> 
	<div class="layui-input-inline">
      <button type="button" class="layui-btn layui-btn-sm" onclick="goBack()" style="margin-left:50px">返 回</button>
		</div>
   <%} %>
   -->
  </div> 
  </form> 
  
<script src="layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
function goBack(){
   location.href="RecruitmentInfo?option=queryByPageAdmin&&url=publishedRecruitment.jsp&checkStatus=已发布";
}

function boolPassCheck(recruitmentID,status){
		location.href="RecruitmentInfo?option=boolPassCheck&recruitmentID="+recruitmentID+"&checkstatus="+status+"&url=checkRecruitment.jsp&checkStatus=未审核";
	}
</script>
  </body>
</html>