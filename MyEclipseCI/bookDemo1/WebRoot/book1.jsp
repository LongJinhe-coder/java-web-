<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.hqu.bookDemo.Book" %>
<%@ page import="com.hqu.dao.BookDao" %>
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
    BookDao bookdao = new BookDao();
			
	List<Book> list =bookdao.queryMybook();
     %>
     <table border="1" align="center">
			<tr>
				<th>图书编号</th>
				<th>图书名称</th>
			</tr>
	 <%
     for (Book book : list) {
      %>
      <tr>
      <th><%= book.getBookId() %></th>
      <th><%=book.getBookName() %></th>
      </tr>
		
     
  	<%
  	}
  	 %>
  	 </table>
  	 <p align="center">1825122033龙金河<p/>
  </body>
</html>
