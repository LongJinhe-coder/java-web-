<%@page import="com.etc.dao.RecruitDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.etc.entity.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>企业账号管理</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
 
</head>
<body>
<%
	PageData pagedata = (PageData)request.getAttribute("pagedata");
	 RecruitDao rdao=new RecruitDao();
	//System.out.println("jobSeeker.jsp-userlist="+pagedata.getData());
 %>
 <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend align="left" style="color:green;">招聘信息/已发布</legend>
</fieldset>


 <form class="layui-form"  action="">
  <div class="layui-form-item">
    <div class="layui-inline">
      <div class="layui-input-inline" style="margin-left:400px">
        <input onkeydown="show();" type="text" name="username" autocomplete="off"  id="btn_text" class="layui-input" placeholder="请输入要搜索的职位">
      </div>
      <div class="layui-input-inline">
       <button type="button" class="layui-btn" id="search_btn" onclick="search()">查 询</button>
      	<button type="button" class="layui-btn" onclick="refresh()"><i class="layui-icon">&#xe669;</i></button>
      </div>
    </div>
    </div>
</form>

<table class="layui-table">
  <colgroup>
    <col width="200">
    <col width="200">
    <col width="200">
    <col width="200">
  </colgroup>
  <thead>
    <tr>
      <th>企业编号</th>
      <th>职位</th>
      <th>月薪</th>
      <th>审核状态</th>
      <th>操作</th>
    </tr> 
  </thead>
  <tbody>
  
  <c:forEach  var="recruitment" items="${pagedata.data}">
  <tr>
      <c:set var="positionID" value="${recruitment.positionID.positionID}" scope="request"></c:set>
      <td>${recruitment.firmID.firmID}</td>
      <!-- 得到岗位名称 -->
      <td><%=rdao.getPositionName((int)request.getAttribute("positionID"))%></td>
      <td>${recruitment.salary}</td>
      <td><font color="green">${recruitment.checkStatus}</font></td>
      <td><button type="button" class="layui-btn" onclick="checkInfo(${recruitment.recruitmentID})">查看详情</button>
      <button type="button" class="layui-btn layui-btn-danger" onclick="deleteRecruitment(${recruitment.recruitmentID})">删除信息</button></td>
    </tr>
    
     </c:forEach>
  <tr>
   <tr>
   		<td colspan="2">
   			第<font color="red">${pagedata.pageNo}</font>页 共<font color="red">${pagedata.totalPage}</font>页
   			<button type="button" class="layui-btn layui-btn-sm" onclick="toFirst(${pagedata.pageNo},${pagedata.pageSize})" style="margin-left:10px">首 页</button>
   			<button type="button" class="layui-btn layui-btn-sm layui-btn-primary" onclick="prePage(${pagedata.pageNo},${pagedata.pageSize})">
			  <i class="layui-icon">&#xe603;</i>
			</button>
			<button type="button" class="layui-btn layui-btn-sm layui-btn-primary" onclick="nextPage(${pagedata.pageNo},${pagedata.pageSize},${pagedata.totalPage})">
			  <i class="layui-icon">&#xe602;</i>
			</button>
   			<button type="button" class="layui-btn layui-btn-sm" onclick="toLast(${pagedata.pageNo},${pagedata.pageSize},${pagedata.totalPage})">尾 页</button>
   		</td>
   </tr>
   </tbody>
</table>
<c:if test="${pagedata.totalPage == 0}">
      	 <center><font size="30px" color="black">还没有已发布的招聘信息！</font></center>
</c:if>
</body>
<script type="text/javascript">
function checkInfo(recruitmentID){

	location.href="RecruitmentInfo?option=queryByID&recruitmentID="+recruitmentID+"&url=displayRecruitmentAdmin.jsp";
}

function deleteRecruitment(recruitmentID){

	location.href="RecruitmentInfo?option=deleteInfoAdmin&recruitmentID="+recruitmentID+"&url=publishedRecruitment.jsp&checkStatus=已发布";
}


 //首页
  function toFirst(pageNo,pageSize){
   if(pageNo<=1){
  	return;
  }
  location.href="RecruitmentInfo?option=queryByPageAdmin&pageNo=1&pageSize="+pageSize+"&url=url=publishedRecruitment.jsp&checkStatus=已发布";
  }
  function prePage(pageNo,pageSize){
  if(pageNo<=1){
  	alert("当前已是第一页");
  	return;
  }
  	location.href="RecruitmentInfo?option=queryByPageAdmin&pageNo="+(pageNo-1)+"&pageSize="+pageSize+"&url=publishedRecruitment.jsp&checkStatus=已发布";
  }
  function nextPage(pageNo,pageSize,totalPage){
  
    if(pageNo>=totalPage){
    	alert("当前已是最后一页");
  		return;
    }
  	location.href="RecruitmentInfo?option=queryByPageAdmin&pageNo="+(pageNo+1)+"&pageSize="+pageSize+"&url=publishedRecruitment.jsp&checkStatus=已发布";
  }
  function toLast(pageNo,pageSize,totalPage){
  if(pageNo>=totalPage){
  		return;
    }
  	location.href="RecruitmentInfo?option=queryByPageAdmin&pageNo="+totalPage+"&pageSize="+pageSize+"&url=publishedRecruitment.jsp&checkStatus=已发布";
  }
  
  function search(){
 var positionName = document.getElementById("btn_text").value;
  if(positionName==null||positionName==""){
  alert("请输入查询的内容！");
  return;
  }
  location.href="RecruitmentInfo?option=queryLikeNameAdmin&positionName="+positionName+"&url=publishedRecruitment.jsp&checkStatus=已发布";
  }
  
  function refresh(){
  location.href="RecruitmentInfo?option=queryByPageAdmin&url=publishedRecruitment.jsp&checkStatus=已发布";
  }
   function show () {
      var e=window.event||arguments.callee.caller.arguments[0];
      if(e.keyCode==13){
         event.keyCode = 0;//屏蔽回车键
          event.returnValue = false;
          alert("请点击查询按钮！");
      }
    }
   

</script>
</html>        
