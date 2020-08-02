<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.etc.entity.Book" %>
<%@ page import="com.etc.dao.BookDao" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'deleteBook.jsp' starting page</title>
    
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
  Book book = (Book)request.getAttribute("book");
   %>
  更新图书操作
  <form action="BookServlet1?option=update" method="post">
  图书编号：<input type="text" name ="bookid" value="<%=book.getBid()%>" readonly="readonly"/>&nbsp;&nbsp;&nbsp;&nbsp;
     图书名称：<input type="text" name ="bookname" value="<%=book.getBookname()%>"/>&nbsp;&nbsp;&nbsp;&nbsp;
     图书类型：<select name ="bookTypeName">
     <option value="1">java技术</option>
      <option value="2">大数据</option>
       <option value="3">人工智能</option>
        <option value="4">web</option>
     </select>&nbsp;&nbsp;&nbsp;&nbsp;
     <input type="submit" name ="修改图书" value="修改图书"/>&nbsp;&nbsp;&nbsp;&nbsp;
   </form>
  </body>
</html>
