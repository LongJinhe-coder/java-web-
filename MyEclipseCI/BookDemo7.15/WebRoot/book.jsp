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
   <!-- 导入jquery库 -->
  <script src="js/jquery-3.2.1.js"></script>
  <script type="text/javascript">
  		$(function(){
  			$("#like_btn").click(function(){
  			       location.href="BookServlet1?option=queryLikeName&bookname="+$("#bn_text").val();
  			});
  		});
  
  </script>

  <body>
  
  <center>图书管理系统</center>
  <center>1825122033 龙金河</center>
  <center>
   请输入图书名称：<input type="text" name="bookname" value="" id="bn_text"/>&nbsp;&nbsp;&nbsp;&nbsp;
   <input type="button" name="" value="模糊查询" id="like_btn"/>&nbsp;&nbsp;&nbsp;&nbsp;
   <a href="BookServlet1?option=queryLikeName&bookname=o">模糊查询</a>
   </center>
    <!-- 显示图书 -->
    <%
    //BookDao bookdao = new BookDao();		
	//List<Book> list =bookdao.queryAllBookAndType();
	List<Book> list = (List<Book>)request.getAttribute("booklist");
	
     %>
     <table border="1" align="center" width = "600px" >
			<tr>
				<th align="center">图书编号</th>
				<th align="center">图书名称</th>
				<th align="center">图书类型</th>
				<th align="center">图书操作</th>
			</tr>
	 <%
     for (Book book : list) {
      %>
      <tr>
      <td align="center"><%= book.getBid() %></td>
      <td align="center"><%=book.getBookname() %></td>
      <td align="center"><%=book.getBt().getTypename() %></td>
		<td align="center">
		<a href="BookServlet1?option=delete&bookid=<%=book.getBid()%>">删除图书</a>
		<a href="addBook.jsp">插入图书</a>
		<!-- <a href="BookServlet1?option=queryById&bookid=<%=book.getBid()%>">修改图书</a> -->
		<a href="BookServlet1?option=queryById&bookid=<%=book.getBid()%>&bookname=<%=book.getBookname()%>&typeid=<%=book.getBt().getTypeid()%>">修改图书</a>
		</td>
      </tr>
		
     
  	<%
  	}
  	 %>
  	 </table>
  	
  </body>
</html>
