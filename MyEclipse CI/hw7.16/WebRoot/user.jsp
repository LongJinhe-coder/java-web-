<%@page import="com.etc.entity.PageData"%>
<%@page import="com.etc.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%--jsp指令 --%>

<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'book1.jsp' starting page</title>
    
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
  
   <center>图书管理系统</enter>
   <center>1825122033 龙金河</enter>
   
   <%
      	List<User> list = (List<User>)request.getAttribute("booklist");
                 //获取分页图书信息
          PageData pageData = (PageData)request.getAttribute("pagedata");
              //获取当前页
          int pageNo = pageData.getPageNo();
              //获取页面大小
          int pageSize = pageData.getPageSize();
                       //获取总页数
          int totalPage = pageData.getTotalPage();
      %>
   
   <!-- 显示4本图书的信息 -->
   <%
   	//java 脚本
      //1.实例化一个bookdao对象
   	//BookDao bookdao  =  new BookDao();
   	//2.调用bookdao中的方法queryAllBookAndType
   	//List<Book> list  =  bookdao.quertAllBookAndType();
   	//List<Book> list  = (List<Book>)request.getAttribute("BookList");
   %>
    <!-- HTML代码 -->
    <!-- 使用表格显示图书 -->
    <table border="1" align="center" width="400px" >
    	<tr>
    	   <td>用户编号：</td>
    	   <td>用户姓名：</td>
    	   <td>用户密码：</td>
    	   <td>用户年龄：</td>
    	</tr>
   
     
     <%
  	//增强for循环
        for(User user : ((List<User>)pageData.getData())){
             %>
        <!-- HTML代码 -->
        <!-- 基本元素  表达式 -->
        <tr>
        	<td><%=user.getId() %></td>
        	<td><%=user.getUsername()%></td>
            <td><%=user.getPassword()%></td>
            <td><%=user.getAge()%></td>           
        </tr>
         <%
      }
       %>
        <tr>
            <td>第<%=pageData.getPageNo() %>页共<%=pageData.getTotalPage() %>页</td>
            <td colspan="2">
              <a href="javascript:toFirst()">首页</a>
              <a href="javascript:toLastPage()">上一页</a>
              <a href="javascript:toNextPage()">下一页</a>
              <a href="javascript:toEnd()">尾页</a>
            </td>
        </tr>
       
      </table>
   
  </body>
  
  <script type="text/javascript">
	function toFirst(){
	location.href="UserServlet?option=queryByPage&pageNo=1&pageSize=<%=pageSize %>";
	}
	
	function toLastPage(){
	location.href="UserServlet?option=queryByPage&pageNo=<%=pageNo-1 %>&pageSize=<%=pageSize %>";
	}
	
	function toNextPage(){
	if(<%=pageNo %><<%=totalPage %>){
	location.href="UserServlet?option=queryByPage&pageNo=<%=pageNo+1 %>&pageSize=<%=pageSize %>";
	}
	}
	
	function toEnd(){
	location.href="UserServlet?option=queryByPage&pageNo=<%=totalPage %>&pageSize=<%=pageSize %>";
	}
</script>
</html>
