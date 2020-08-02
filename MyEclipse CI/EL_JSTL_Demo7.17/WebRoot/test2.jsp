<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    
    <%
    String[] firstname = {"三","四","五"};
    
    ArrayList<String> lastname = new ArrayList<String>();
    lastname.add("张");
    lastname.add("李");
    lastname.add("王");
    //<!-- map -->
    
    HashMap<String,String> name = new HashMap<String,String>();
    	name.put("user1", "志愿者1");
    	name.put("user2", "志愿者2");
    	name.put("user3", "志愿者3");
    	
    	request.setAttribute("first", firstname);
    	request.setAttribute("last", lastname);
    	application.setAttribute("user", name);
     %>
     
     <h2>EL表达式访问集合</h2>
    <ol>
    	<li>${last[0]}${first[0]}是${user["user1"]}</li>
    	<li>${last[1]}${first[1]}是${user["user2"]}</li>
    	<li>${last[2]}${first[2]}是${user["user3"]}</li>
    	<!-- 指定范围寻找 -->
    	<li>${pageScope.first[0]}</li>
    	<li>${requestScope.first[0]}</li>
    	<li>${sessionScope.first[0]}</li>
    	<li>${sessionScope.last[0]}</li>
    	<li>${applicationScope.user["user1"]}</li>
    	<li>${user["user2"]}</li>
    </ol>
  </body>
</html>
