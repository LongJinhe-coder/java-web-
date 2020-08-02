<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    
    <title>My JSP 'forEach.jsp' starting page</title>
    
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
    <h4>forEach 案例</h4>
    <h4>循环次数控制</h4>
    <c:forEach var="item" begin="1" end="10" step="2">
    	${item}
    </c:forEach>
    <h4>枚举元素Vector</h4>
    <%
		Vector v = new Vector();
		v.add("张三");
		v.add("李四");
		v.add("王五");
		v.add("赵六");
		request.setAttribute("vector", v);
     %>
     <c:forEach items="${vector}" var="item">
     ${item}
     </c:forEach>
     <h4>逗号分隔的字符串</h4>
     <c:forEach var="color" items="红,白,黑,蓝,绿,黄,紫"  begin="0" step="1">
     	<c:out value="${color}"></c:out>
     </c:forEach>
     <h4>状态变量的使用</h4>
     <c:forEach var="i" begin="10" end="50" step="5" varStatus="status">
     	<c:if test="${status.first }">
     		begin:<c:out value="${status.begin }"></c:out>
     		end:<c:out value="${status.end }"></c:out>
     		step:<c:out value="${status.step }"></c:out><br/>
     		<c:out value="输出的元素"></c:out>
     	</c:if>
     	<c:out value="${i}"></c:out>
     	<c:if test="${status.last}">
     	<br/>总输出：<c:out value="${status.count }"></c:out>
     	</c:if>
     </c:forEach>
  </body>
</html>
