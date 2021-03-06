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
 %>
 <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend align="left" style="color:green;">管理员信息/管理员账号</legend>
</fieldset>


 <form class="layui-form"  action="">
  <div class="layui-form-item">
    <div class="layui-inline">
      <div class="layui-input-inline" style="margin-left:400px">
        <input onkeydown="show();" type="text" name="username" autocomplete="off"  id="btn_text" class="layui-input" placeholder="请输入要搜索的管理员名称">
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
  </colgroup>
  <thead>
    <tr>
      <th>管理员编号</th>
      <th>账号</th>
      <th>密码</th>
      <th></th>
    </tr> 
  </thead>
  <tbody>
  
  <c:forEach  var="admin" items="${pagedata.data}">
  <tr>
      
      <td>${admin.adminID}</td>
      <td>${admin.adminName}</td>
      <td>${admin.adminPwd}</td>
      <!--  <td><button type="button" class="layui-btn layui-btn-danger" onclick="deleteAdmin(${admin.adminID})">删除账号</button></td>-->
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
      	 <center><font size="30px" color="black">暂时没有管理员！</font></center>
</c:if>
</body>
<script type="text/javascript">

function deleteAdmin(adminID){

	location.href="AdminServlet?option=deleteAdmin&adminID="+adminID+"&url=checkAdmin.jsp";
}

function comfirmDelete(adminID){
	if(confirm("确认删除")){
	deleteAdmin(function() {
		location.href="AdminServlet?option=deleteAdmin&adminID="+adminID+"&url=checkAdmin.jsp";
	})
	}else{
	return;
	}
}

 //首页
  function toFirst(pageNo,pageSize){
   if(pageNo<=1){
  	return;
  }
  location.href="AdminServlet?option=queryByPage&pageNo=1&pageSize="+pageSize+"&url=checkAdmin.jsp";
  }
  function prePage(pageNo,pageSize){
  if(pageNo<=1){
  	alert("当前已是第一页");
  	return;
  }
  	location.href="AdminServlet?option=queryByPage&pageNo="+(pageNo-1)+"&pageSize="+pageSize+"&url=checkAdmin.jsp";
  }
  function nextPage(pageNo,pageSize,totalPage){
  
    if(pageNo>=totalPage){
    	alert("当前已是最后一页");
  		return;
    }
  	location.href="AdminServlet?option=queryByPage&pageNo="+(pageNo+1)+"&pageSize="+pageSize+"&url=checkAdmin.jsp";
  }
  function toLast(pageNo,pageSize,totalPage){
  if(pageNo>=totalPage){
  		return;
    }
  	location.href="AdminServlet?option=queryByPage&pageNo="+totalPage+"&pageSize="+pageSize+"&url=checkAdmin.jsp";
  }
  
  function search(){
 var adminName = document.getElementById("btn_text").value;
  if(adminName==null||adminName==""){
  alert("请输入查询的内容！");
  return;
  }
  location.href="AdminServlet?option=queryLikeName&adminName="+adminName+"&url=checkAdmin.jsp";
  }
  
  function refresh(){
  location.href="AdminServlet?option=queryByPage&url=checkAdmin.jsp";
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
