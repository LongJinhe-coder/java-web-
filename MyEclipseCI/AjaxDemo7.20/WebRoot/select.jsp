<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'select.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
 <!-- Ajax技术 -->
  <script type="text/javascript" src="js/ajax.js"></script>
  <script type="text/javascript">
       function refresh(){
         //获取省份和城市的值
         var p=document.getElementById("prov").value;
         var city=document.getElementById("city").value;
         
         if(p==""){
           city.options.length=0;
           city.options.add(new Option("--请选择城市--"));
         }
         else{
           var url="CityList";
           var params="prov="+p;
           sendRequest(url,params,'POST',show);
         }
       }
       
       function show(){
          
           var city=document.getElementById("city");
           if(httpRequest.readyState==4){
             if(httpRequest.status==200){
               //获取服务器传递的城市信息值
               var citylist=httpRequest.responseText.split(",");
               var citynum=citylist.length;
            
               city.options.length=0;
               for(var i=0;i<citynum;i++){
                    city.options.add(new Option(citylist[i]))
               }
               
             }
          }
       }
  </script>
  <body>
    <select name="prov" id="prov" onchange="refresh()">
        <option value="">--请选择省份--</option>
        <option value="山东">山东</option>
        <option value="江苏">江苏</option>
        <option value="广东">广东</option>
    </select>
    <select name="city" id="city">
         <option value="">--请选择城市--</option>
    </select>
  </body>
</html>
