<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'form.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <script type="text/javascript" src="js/ajax.js"></script>
  <script type="text/javascript">
  	function formcheck(){
  	
  		var url = "RegisterCheck";//servlet名称
  		var username = document.getElementById("username").value;
  		var password = document.getElementById("password").value;
  		var password2 = document.getElementById("password2").value;
  		var params = "username=" + username + "&password=" + password+ "&password2=" + password2+ "&register=" + "no";
  		console.log("params",params);
  		sendRequest(url,params,"POST",showresult);
  	}

	function register(){
  	
  		var url = "RegisterCheck";//servlet名称
  		var username = document.getElementById("username").value;
  		var password = document.getElementById("password").value;
  		var password2 = document.getElementById("password2").value;
  		var params = "username=" + username + "&password=" + password+ "&password2=" + password2+ "&register=" + "yes";
  		console.log("params",params);
  		sendRequest(url,params,"POST",showresult);
  	}
  	
  	function showresult(){
  		if(httpRequest.readyState == 4){
  			if(httpRequest.status == 200){
  				//获取RigisterCheck返回的消息
  				var res = httpRequest.responseText;
  				document.getElementById("result").innerHTML=res;
  				
  			}
  		}
  	}
  </script>
  
  <body>
    	输入用户名：<input type="text" name="username" id="username" onblur="formcheck()"></input><br/>
    	输入密码：<input type="password" name="password" id="password" onblur="formcheck()"></input><br/>
    	确认密码：<input type="password" name="password2" id="password2" onblur="formcheck()"></input><br/>
    	<input type="button" value="注册" onclick="register()"></input>
    	<div id="result"></div>
  </body>
</html>
