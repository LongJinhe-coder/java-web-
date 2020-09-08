<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.etc.entity.*" %>
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
  添加图书具体操作
  <%
    	request.setCharacterEncoding("UTF-8");
          response.setCharacterEncoding("UTF-8");
          
          String bookname = request.getParameter("bookname");
          String booktypename = request.getParameter("bookTypeName");//传的是id1,2,3,4
          
          BookDao bookdao = new BookDao();
          
          Book book = new Book();
          
          book.setBookname(bookname);
          
          BookType bt = new BookType();
          
          bt.setTypename(booktypename);
          
          book.setBt(bt);
          
          bookdao.addBook(book);
          
           request.getRequestDispatcher("book1.jsp").forward(request, response);
           //response.sendRedirect("book1.jsp");
    %>
  </body>
</html>
