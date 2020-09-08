<%@page import="com.etc.dao.AdvertDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.etc.entity.*" %>
<%@ page import="java.io.File"%>

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
	<style type="text/css">
    *{
      margin:0;
      padding:0;
    }
     
    h1{
      text-align: center;
      margin:20px 0;
    }
 
    #imgdiv{
      width: 200px;
      margin:10px auto;
    }
 
    #imgdiv img{
      width: 300px;
      margin:0 100px;
    }
 
    #bigimg{
      width: 100%;
      height: 100%;
      position: fixed;
      background: rgba(0,0,0,.3);
      top: 0;
      display: none;
    }
 
    #bigimg img{
      width: 1000px;
      margin:auto;
      position: fixed;
      left:0;
      right:0;
      top: 80px;
      cursor: pointer;
    }
  </style>
</head>

<%
	PageData pagedata = (PageData)request.getAttribute("pagedata");
     File file=new File("E:\\JavaWeb实训\\MyEclipseCI\\projectDemo\\WebRoot\\image\\ad");
		String[]ss=file.list();//获得目录下所有的文件名
	int count=0;
	 AdvertDao adao=new AdvertDao();
 %>

<body>
 <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend align="left" style="color:green;">广告信息/未审核</legend>
</fieldset>
 <form class="layui-form"  action="">
  <div class="layui-form-item">
    <div class="layui-inline">
      <div class="layui-input-inline" style="margin-left:400px">
        <input onkeydown="show();" type="text" name="positionName" autocomplete="off"  id="btn_text" class="layui-input" placeholder="请输入要搜索的广告编号">
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
    <col width="150">
  </colgroup>
  <thead>
    <tr>
      <th>广告编号</th>
      <th>公司名称</th>
      <th>广告内容</th>
      <th>审核状态</th>
      <th>操作</th>
    </tr> 
  </thead>
  <tbody>
  
  <c:forEach  var="advert" items="${pagedata.data}">
  <tr>
  	<c:set var="firmID" value="${advert.firmID.firmID}" scope="request"></c:set>
  	<c:set var="advertName" value="${advert.advertName}" scope="request"></c:set>
      <td>${advert.advertID}</td>
      <td ><%=adao.getFirmName((int)request.getAttribute("firmID")) %></td>
      <td id="imgdiv" onclick="imgbig('${advert.advertName}');"><img src="<%="image\\\\ad\\\\"+(String)request.getAttribute("advertName") %>" id="imgsrc"/></td>
      	 <td><font color="red">${advert.checkStatus}</font></td>

      <td><button type="button" class="layui-btn" onclick="passCheck(${advert.advertID})">通过审核</button>
      <button type="button" class="layui-btn layui-btn-danger" onclick="noPassCheck(${advert.advertID})">不通过审核</button></td>
    </tr>
     </c:forEach>
  <tr>
   		<td colspan="7">
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
 <div id="bigimg" onclick="closeimg();"></div>
<c:if test="${pagedata.totalPage == 0}">
      	 <center><font size="30px" color="black">暂时没有需要审核的广告！</font></center>
</c:if>

<script  type="text/javascript">
//首页
  function toFirst(pageNo,pageSize){
   if(pageNo<=1){
  	return;
  }
  location.href="AdvertServlet?option=queryByPageAdmin&pageNo=1&pageSize="+pageSize+"&url=checkAdvert.jsp&checkStatus=未审核";
  }
  function prePage(pageNo,pageSize){

  if(pageNo<=1){
  	alert("当前已是第一页");
  	return;
  }
  	location.href="AdvertServlet?option=queryByPageAdmin&pageNo="+(pageNo-1)+"&pageSize="+pageSize+"&url=checkAdvert.jsp&checkStatus=未审核";
  }
  function nextPage(pageNo,pageSize,totalPage){

    if(pageNo>=totalPage){
    	alert("当前已是最后一页");
  		return;
    }
  	location.href="AdvertServlet?option=queryByPageAdmin&pageNo="+(pageNo+1)+"&pageSize="+pageSize+"&url=checkAdvert.jsp&checkStatus=未审核";
  }
  function toLast(pageNo,pageSize,totalPage){

  if(pageNo>=totalPage){
  		return;
    }
  	location.href="AdvertServlet?option=queryByPageAdmin&pageNo="+totalPage+"&pageSize="+pageSize+"&url=checkAdvert.jsp&checkStatus=未审核";
  }
  function search(){
  var advertID = document.getElementById("btn_text").value;
  if(advertID==null||advertID==""){
  alert("请输入查询的内容！");
  return;
  }
  
  location.href="AdvertServlet?option=queryLikeNameAdmin&checkStatus=未审核&url=checkAdvert.jsp&advertID="+advertID;
  }
  
  function refresh(){
  var positionName = document.getElementById("btn_text").value;
  location.href="AdvertServlet?option=queryByPageAdmin&&url=checkAdvert.jsp&checkStatus=未审核";
  }
   function show () {
      var e=window.event||arguments.callee.caller.arguments[0];
      if(e.keyCode==13){
         event.keyCode = 0;//屏蔽回车键
          event.returnValue = false;
          alert("请点击查询按钮！");
      }
    }
    
    function passCheck(advertID){
        location.href="AdvertServlet?option=changeCheckStatus&changedStatus=已审核&url=checkAdvert.jsp&checkStatus=未审核&advertID="+advertID;
    }
    
     function noPassCheck(advertID){
        location.href="AdvertServlet?option=changeCheckStatus&changedStatus=不通过&url=checkAdvert.jsp&checkStatus=未审核&advertID="+advertID;
    }
    </script>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.1.1/jquery.js"></script>
<script>
function imgbig(imageName) {
  //var imgsrc = $('#imgsrc').attr('src');
  var imgsrc = "image\\\\ad\\\\"+imageName;
  //alert(imgsrc);
  $("#bigimg").css("display","block");
  $("#bigimg").html("<img src="+imgsrc+" />");
}
 
function closeimg() {
  $("#bigimg").css("display","none");
}
</script>

</body>

</html>
   