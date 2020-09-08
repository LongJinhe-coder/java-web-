<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%--jsp指令 --%>
<%@ page import="com.etc.entity.*" %>
<!-- 引入核心标签库 -->
<!-- 核心库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
   
   <!-- 显示4本图书的信息 -->
   <%
   //java 脚本
	//List<Book1> list  = (List<Book1>)request.getAttribute("BookList");
	//获取分页图书信息
	PageData pagedata = (PageData)request.getAttribute("pagedata");
	//PageData pagedata =${pagedata};
	
    %>
    
    <!-- HTML代码 -->
    <!-- 使用表格显示图书 -->
    <table border="1" align="center" width="600px" heigth="400px">
    	<tr>
    	   <td>图书编号：</td>
    	   <td>图书名称：</td>
    	   <td>图书类型：</td>  	  
    	</tr>
    	
     <%
       //增强for循环
      // for(Book1 book : (List<Book1>)pagedata.getData()){
       
      %>
    
      <c:forEach var="book" items="${pagedata.data}">
      
      
      
     
      
      
        <!-- HTML代码 -->
        <!-- 基本元素  表达式 -->
        <tr>
<!-- EL表达式 -->
        	<td>${book.bid}</td>
        	<td>${book.bookname}</td>
            <td>${book.booktype}</td>   
                   
        </tr>
         </c:forEach>
          <%
        // }
       %>
        <tr>
            <td>第${pagedata.pageNo}页共${pagedata.totalPage}页</td>
            
            <td colspan="2">
              <a href="javaScript:toFirst()">首页</a>
              <a href="javaScript:prePage(${pagedata.pageNo})">上一页</a>
              <a href="javaScript:nextPage(${pagedata.pageNo})">下一页</a>
              <a href="javaScript:toLast(${pagedata.totalPage})">尾页</a>
            </td>
        </tr>
       
    
      </table>
   
  </body>
  
  <script type="text/javascript">
  //首页
  function toFirst(){
  //http://localhost:9090/20200716BookDemo/BookServlet?Option=queryByPage
  	location.href="BookServlet?option=queryByPage&pageNo=1&pageSize=3";
  }
  function prePage(pageNo){
  if(pageNo<=1){
  	alert("已经是第一页");
  	return;
  }
  	location.href="BookServlet?option=queryByPage&pageNo="+(pageNo-1)+"&pageSize=3";
  }
  function nextPage(pageNo){
  
    if(pageNo>=<%=pagedata.getTotalPage() %>){
    	alert("已经是最后一页");
  		return;
    }
  	location.href="BookServlet?option=queryByPage&pageNo="+(pageNo+1)+"&pageSize=3";
  }
  function toLast(pageNo){
  	location.href="BookServlet?option=queryByPage&pageNo="+pageNo+"&pageSize=3";
  }
  
  </script>
</html>
