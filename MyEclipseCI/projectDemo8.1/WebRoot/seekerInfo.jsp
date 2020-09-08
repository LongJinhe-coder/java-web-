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
	
	 
	// int firmID=Integer.parseInt(session.getAttribute("firmID").toString());
	// System.out.println("我拿到firmID------------->"+firmID);
	  RecruitDao rdao=new RecruitDao();
 %>
<body>
 <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend align="left" style="color:green;">查看应聘信息</legend>
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
      <th>简历编号</th>
      <th>处理状态</th>
      <th>操作</th>
    </tr> 
  </thead>
  <tbody>
  
  <c:forEach  var="recruitment" items="${pagedata.data}">
  <tr>
     
      <td>${recruitment.userInfoID.userInfoID}</td>
       <c:if test="${recruitment.handleStatus eq '已应聘'}">
      	 <td><font color="green">${recruitment.handleStatus}</font></td>
      </c:if>
     <c:if test="${recruitment.handleStatus eq '未应聘'}">
      	 <td><font color="red">${recruitment.handleStatus}</font></td>
      </c:if>
    
      <td>
      <button type="button" class="layui-btn" onclick="lookInfo(${recruitment.userInfoID.userInfoID},${pagedata.pageNo},${pagedata.pageSize})">查看简历</button>
      <button type="button" class="layui-btn layui-btn-danger" onclick="deleteInfo(${recruitment.userInfoID.userInfoID},${pagedata.pageNo},${pagedata.pageSize})">删除简历</button>
        
        <c:if test="${recruitment.handleStatus eq '未应聘'}">	
       <button type="button" class="layui-btn layui-btn-normal" onclick="doAccept(${recruitment.userInfoID.userInfoID},${pagedata.pageNo},${pagedata.pageSize})">同意应聘</button>
       </c:if>
       
       <c:if test="${recruitment.handleStatus eq '已应聘'}">	
       <button type="button" class="layui-btn layui-btn-warm" onclick="doReject(${recruitment.userInfoID.userInfoID},${pagedata.pageNo},${pagedata.pageSize})">取消应聘</button>
       </c:if>
      </td>
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
   if(pageNo<=1){
  	return;
  }
  location.href="SeekerInfo?option=queryByPage&pageNo=1&pageSize="+pageSize+"&url=seekerInfo.jsp";
  }
  function prePage(pageNo,pageSize){
  if(pageNo<=1){
  	alert("当前已是第一页");
  	return;
  }
  	location.href="SeekerInfo?option=queryByPage&pageNo="+(pageNo-1)+"&pageSize="+pageSize+"&url=seekerInfo.jsp";
  }
  function nextPage(pageNo,pageSize,totalPage){
  
    if(pageNo>=totalPage){
    	alert("当前已是最后一页");
  		return;
    }
  	location.href="SeekerInfo?option=queryByPage&pageNo="+(pageNo+1)+"&pageSize="+pageSize+"&url=seekerInfo.jsp";
  }
  function toLast(pageNo,pageSize,totalPage){
  if(pageNo>=totalPage){
  		return;
    }
  	location.href="SeekerInfo?option=queryByPage&pageNo="+totalPage+"&pageSize="+pageSize+"&url=seekerInfo.jsp";
  }
  
  function deleteInfo(userInfoID,pageNo,pageSize){
	location.href="SeekerInfo?option=deleteInfo&userInfoID="+userInfoID+"&pageNo="+pageNo+"&pageSize="+pageSize+"&url=seekerInfo.jsp";
}

 function lookInfo(userInfoID,pageNo,pageSize){
   location.href="SeekerInfo?option=lookInfo&userInfoID="+userInfoID+"&pageNo="+pageNo+"&pageSize="+pageSize+"&url=displayPersonalResume2.jsp";
  }
  
  function search(){
  
  var userInfoID = document.getElementById("btn_text").value;
  if(userInfoID==null||userInfoID==""){
  alert("请输入查询的内容！");
  return;
  }
  location.href="SeekerInfo?option=queryLikeID&userInfoID="+userInfoID+"&url=seekerInfo.jsp";
  }
  
  function refresh(){
  
  location.href="SeekerInfo?option=queryByPage&url=seekerInfo.jsp&firmID="+firmID;
  }
   function show () {
      var e=window.event||arguments.callee.caller.arguments[0];
      if(e.keyCode==13){
         event.keyCode = 0;//屏蔽回车键
          event.returnValue = false;
          alert("请点击查询按钮！");
      }
    }
    
  
    function doAccept(userInfoID,pageNo,pageSize){
    //alert("accept");
       location.href="SeekerInfo?option=accept&userInfoID="+userInfoID+"&pageNo="+pageNo+"&pageSize="+pageSize+"&url=seekerInfo.jsp";
    }
    
    function doReject(userInfoID,pageNo,pageSize){
    location.href="SeekerInfo?option=reject&userInfoID="+userInfoID+"&pageNo="+pageNo+"&pageSize="+pageSize+"&url=seekerInfo.jsp";
    }
   

</script>
</html>        
