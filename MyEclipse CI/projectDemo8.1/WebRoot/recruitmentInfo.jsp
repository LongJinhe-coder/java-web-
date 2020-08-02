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
  <title>Layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>

<%
	PageData pagedata = (PageData)request.getAttribute("pagedata");
	 
	 int firmID=Integer.parseInt(session.getAttribute("firmID").toString());
	 System.out.println("我拿到firmID------------->"+firmID);
	 RecruitDao rdao=new RecruitDao();
 %>

<body>
 <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend align="left" style="color:green;">发布招聘信息/已发布</legend>
</fieldset>
 <form class="layui-form"  action="">
  <div class="layui-form-item">
    <div class="layui-inline">
      <div class="layui-input-inline" style="margin-left:400px">
        <input onkeydown="show();" type="text" name="positionName" autocomplete="off"  id="btn_text" class="layui-input" placeholder="请输入要搜索的用户名">
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
    <col width="150">
    <col width="200">
    <col width="200">
  </colgroup>
  <thead>
    <tr>
      <th>职位</th>
      <th>月薪</th>
      <th>招聘人数</th>
      <th>年龄要求</th>
      <th>截止日期</th>
      <th>操作</th>
    </tr> 
  </thead>
  <tbody>
  
  <c:forEach  var="recruitment" items="${pagedata.data}">
  <tr>
      <c:set var="positionID" value="${recruitment.positionID.positionID}" scope="request"></c:set>
      <!-- 得到岗位名称 -->
      <td><%=rdao.getPositionName((int)request.getAttribute("positionID"))%></td>
      <td>${recruitment.salary}</td>
      <td>${recruitment.count}</td>
      <td>${recruitment.age}</td>
      <td>${recruitment.dueDate}</td>

      <td><button type="button" class="layui-btn" onclick="lookInfo(${recruitment.recruitmentID},${pagedata.pageNo},${pagedata.pageSize})">查看信息</button><button type="button" class="layui-btn" onclick="deleteInfo(${recruitment.recruitmentID},${pagedata.pageNo},${pagedata.pageSize})">撤回信息</button></td>
    </tr>
    
     </c:forEach>
  <tr>

   		<td colspan="6">
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
      	 <center><font size="30px" color="black">没有找到与您搜索相匹配的用户！</font></center>
</c:if>
</body>
<script type="text/javascript">
//传pageNo,pageSize是为了删除后回到当前界面



 //首页
  function toFirst(pageNo,pageSize){
  var firmID=<%=firmID%>
   if(pageNo<=1){
  	return;
  }
  location.href="RecruitmentInfo?option=queryByPage&pageNo=1&pageSize="+pageSize+"&url=recruitmentInfo.jsp&firmID="+firmID;
  }
  function prePage(pageNo,pageSize){
  var firmID=<%=firmID%>
  if(pageNo<=1){
  	alert("当前已是第一页");
  	return;
  }
  	location.href="RecruitmentInfo?option=queryByPage&pageNo="+(pageNo-1)+"&pageSize="+pageSize+"&url=recruitmentInfo.jsp&firmID="+firmID;
  }
  function nextPage(pageNo,pageSize,totalPage){
  var firmID=<%=firmID%>
    if(pageNo>=totalPage){
    	alert("当前已是最后一页");
  		return;
    }
  	location.href="RecruitmentInfo?option=queryByPage&pageNo="+(pageNo+1)+"&pageSize="+pageSize+"&url=recruitmentInfo.jsp&firmID="+firmID;
  }
  function toLast(pageNo,pageSize,totalPage){
  var firmID=<%=firmID%>
  if(pageNo>=totalPage){
  		return;
    }
  	location.href="RecruitmentInfo?option=queryByPage&pageNo="+totalPage+"&pageSize="+pageSize+"&url=recruitmentInfo.jsp&firmID="+firmID;
  }
  
  function deleteInfo(recruitmentID,pageNo,pageSize){
  var firmID=<%=firmID%>
	location.href="RecruitmentInfo?option=deleteInfo&recruitmentID="+recruitmentID+"&firmID="+firmID+"&pageNo="+pageNo+"&pageSize="+pageSize+"&url=recruitmentInfo.jsp";
}

 function lookInfo(recruitmentID,pageNo,pageSize){
 var firmID=<%=firmID%>
   location.href="RecruitmentInfo?option=lookInfo&recruitmentID="+recruitmentID+"&firmID="+firmID+"&pageNo="+pageNo+"&pageSize="+pageSize+"&url=displayRecruitmentInfo.jsp";
 }
  
  function search(){
  var firmID=<%=firmID%>
  var positionName = document.getElementById("btn_text").value;
  if(positionName==null||positionName==""){
  alert("请输入查询的内容！");
  return;
  }
  
  location.href="RecruitmentInfo?option=queryLikeName&positionName="+positionName+"&firmID="+firmID+"&url=recruitmentInfo.jsp";
  }
  
  function refresh(){
  var positionName = document.getElementById("btn_text").value;
  var firmID=<%=firmID%>
  location.href="RecruitmentInfo?option=queryByPage&firmID="+firmID+"&positionName="+positionName+"&url=recruitmentInfo.jsp";
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