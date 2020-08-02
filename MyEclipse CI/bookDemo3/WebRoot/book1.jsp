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
  
  <body>
  
  <center>图书管理系统</center>
  <center>欢迎<%=request.getAttribute("name")%>登录系统</center>
  <center>欢迎<%=session.getAttribute("name")%>登录系统</center>
  
  <!-- application统计网站访问人数 -->
  <%
  	/*（1）application.getAttribute(String xxx)
         获得指定属性的值
      */
        int number=0;//定义一个保存网页访问人数的变量
        //当用户第一次访问
        if(application.getAttribute("number")==null){
                 number=1;    
        }else{
           //获取application属性中number变量的值 并转化为int数据类型
           number = Integer.parseInt(application.getAttribute("number").toString());
     		 number= number+1;    
        }
        
        //输出
        out.print("您是第"+number+"位访问者");
        /*
         （2）void setAttribute(String arriname,Object attrivalue)
        */
        application.setAttribute("number", number);
  %>
  
    <!-- 显示图书 -->
    <%
    	BookDao bookdao = new BookDao();
        	
        	List<Book> list =bookdao.queryAllBookAndType();
    %>
     <table border="1" align="center" width = "600px" height="400px">
			<tr>
				<th align="center">图书编号</th>
				<th align="center">图书名称</th>
				<th align="center">图书类型</th>
				<th align="center">操作</th>
			</tr>
	 <%
     for (Book book : list) {
      %>
      <tr>
      <td align="center"><%= book.getBid() %></td>
      <td align="center"><%=book.getBookname() %></td>
      <td align="center"><%=book.getBt().getTypename() %></td>
		<td align="center">
		<a href="deleteBook.jsp?bid=<%=book.getBid()%>">删除图书</a>
		<a href="addBook.jsp">插入图书</a>
		<a>修改图书</a>
		</td>
      </tr>
		
     
  	<%
  	}
  	 %>
  	 </table>
  	 <p align="center">1825122033龙金河<p/>
  </body>
</html>
