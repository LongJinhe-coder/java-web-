<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	//System.out.println("jobSeeker.jsp-userlist="+pagedata.getData());
 %>
 <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend align="left" style="color:green;">用户管理/企业</legend>
</fieldset>


 <form class="layui-form"  action="">
  <div class="layui-form-item">
    <div class="layui-inline">
      <div class="layui-input-inline" style="margin-left:400px">
        <input onkeydown="show();" type="text" name="username" autocomplete="off"  id="btn_text" class="layui-input" placeholder="请输入要搜索的企业名">
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
    <col width="150">
    <col width="150">
  </colgroup>
  <thead>
    <tr>
      <th>账号</th>
      <th>企业名</th>
      <th>注册时间</th>
      <th>账号状态</th>
      <th>审核状态</th>
      <th>操作</th>
    </tr> 
  </thead>
   <tbody>
  <c:forEach var="firm" items="${pagedata.data}">
  <c:if test="${firm.checkStatus eq '审核通过' ||firm.checkStatus eq '待审核' }">
      <tr>
      <td>${firm.firmAccount}</td>
      <td>${firm.firmName}</td>
      <td>${firm.registerTime}</td>
      <c:if test="${firm.accountStatus eq '正常'}">
      	 <td><font color="green">${firm.accountStatus}</font></td>
      </c:if>
      <c:if test="${firm.accountStatus eq '冻结中'}">
      	 <td><font color="red">${firm.accountStatus}</font></td>
      </c:if>
      <c:if test="${firm.checkStatus eq '审核通过'}">
      	 <td><font color="green">${firm.checkStatus}</font></td>
      </c:if>
      <c:if test="${firm.checkStatus eq '待审核'}">
      	 <td><font color="red">${firm.checkStatus}</font></td>
      </c:if>
      <c:if test="${firm.accountStatus eq '正常'}">
      	 <td>
      	 <c:if test="${firm.checkStatus eq '待审核'}">
      	 <button type="button" class="layui-btn layui-btn-normal" onclick="checkStatus(${firm.firmID})">进入审核</button>
      </c:if>
      <c:if test="${firm.checkStatus eq '审核通过'}">
      	 <button type="button" class="layui-btn" onclick="checkInfo(${firm.firmID})">查看详情</button>
      	<button type="button" class="layui-btn layui-btn-warm" onclick="freezingAct(${firm.firmID},${pagedata.pageNo},${pagedata.pageSize})">冻结账号</button>
      		<button type="button" class="layui-btn layui-btn-danger" onclick="deleteAct(${firm.firmID},${pagedata.pageNo},${pagedata.pageSize})">删除账号</button></td>
      </c:if>
      
      </c:if>
     <c:if test="${firm.accountStatus eq '冻结中'}">
      	 <td><c:if test="${firm.checkStatus eq '待审核'}">
      	 <button type="button" class="layui-btn layui-btn-normal" onclick="checkStatus(${firm.firmID})">进入审核</button>
      </c:if>
      <c:if test="${firm.checkStatus eq '审核通过'}">
      	 <button type="button" class="layui-btn" onclick="checkInfo(${firm.firmID})">查看详情</button>
      	<button type="button" class="layui-btn layui-btn-normal" onclick="removeFreezing(${firm.firmID},${pagedata.pageNo},${pagedata.pageSize})">解除冻结</button>
      	<button type="button" class="layui-btn layui-btn-danger" onclick="deleteAct(${firm.firmID},${pagedata.pageNo},${pagedata.pageSize})">删除账号</button></td>
      </c:if>
      	 	
      </c:if>
    </tr>	
   </c:if>
   </c:forEach>
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
      	 <center><font size="30px" color="black">没有找到与您搜索相匹配的企业！</font></center>
</c:if>
</body>
<script type="text/javascript">
function checkInfo(firmID){

	location.href="FirmServlet?option=queryByID&firmID="+firmID+"&url=displayFirmResume.jsp";
}

function checkStatus(firmID){

	location.href="FirmServlet?option=queryByID&firmID="+firmID+"&url=firmRegisterInfo.jsp";
}

//传pageNo,pageSize是为了删除后回到当前界面
function freezingAct(firmID,pageNo,pageSize){
	location.href="FirmServlet?option=freezingAccount&firmID="+firmID+"&pageNo="+pageNo+"&pageSize="+pageSize+"&url=firmAccount.jsp";
	//alert("账号冻结成功！");
}
function removeFreezing(firmID,pageNo,pageSize){
	location.href="FirmServlet?option=removeFreezing&firmID="+firmID+"&pageNo="+pageNo+"&pageSize="+pageSize+"&url=firmAccount.jsp";
	//alert("解除冻结成功！");
}
function deleteAct(firmID,pageNo,pageSize){
var message = "确认删除?删除后无法恢复！"
	if(confirm(message)){
		location.href="FirmServlet?option=deleteAccount&firmID="+firmID+"&pageNo="+pageNo+"&pageSize="+pageSize+"&url=firmAccount.jsp";
	}else{
	return;
	}
}

 //首页
  function toFirst(pageNo,pageSize){
   if(pageNo<=1){
  	return;
  }
  location.href="FirmServlet?option=queryByPage&pageNo=1&pageSize="+pageSize+"&url=firmAccount.jsp";
  }
  function prePage(pageNo,pageSize){
  if(pageNo<=1){
  	alert("当前已是第一页");
  	return;
  }
  	location.href="FirmServlet?option=queryByPage&pageNo="+(pageNo-1)+"&pageSize="+pageSize+"&url=firmAccount.jsp";
  }
  function nextPage(pageNo,pageSize,totalPage){
  
    if(pageNo>=totalPage){
    	alert("当前已是最后一页");
  		return;
    }
  	location.href="FirmServlet?option=queryByPage&pageNo="+(pageNo+1)+"&pageSize="+pageSize+"&url=firmAccount.jsp";
  }
  function toLast(pageNo,pageSize,totalPage){
  if(pageNo>=totalPage){
  		return;
    }
  	location.href="FirmServlet?option=queryByPage&pageNo="+totalPage+"&pageSize="+pageSize+"&url=firmAccount.jsp";
  }
  
  function search(){
  var firmname = document.getElementById("btn_text").value;
  if(firmname==null||firmname==""){
  alert("请输入查询的内容！");
  return;
  }
  location.href="FirmServlet?option=queryLikeName&firmname="+firmname+"&url=firmAccount.jsp";
  }
  
  function refresh(){
  location.href="FirmServlet?option=queryByPage&url=firmAccount.jsp";
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
