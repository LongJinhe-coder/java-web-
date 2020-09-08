<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.etc.entity.User" %>
<%@ page import="com.etc.dao.UserDao" %>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'book.jsp' starting page</title>
    
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
    <!-- 显示图书 -->
    <%
    	UserDao bookdao = new UserDao();
                                                                	
                                                                	List<User> list =bookdao.userQuery();
    %>
     <table border="1" align="center" width="400px">
			<tr>
				<th>id</th>
				<th>username</th>
				<th>password</th>
				<th>age</th>
			</tr>
	 <%
	 	for (User user : list) {
	 %>
      <tr>
      <th><%=user.getId() %></th>
      <th><%=user.getUsername() %></th>
      <th><%=user.getPassword() %></th>
      <th><%=user.getAge() %></th>
      </tr>
		
     
  	<%
  	}
  	 %>
  	 </table>
  	 <p align="center">1825122033龙金河<p/>
  </body>
</html>
