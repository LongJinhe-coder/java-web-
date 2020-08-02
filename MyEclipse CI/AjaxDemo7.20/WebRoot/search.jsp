<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'search.jsp' starting page</title>
    
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
  <script  type="text/javascript" src="js/ajax.js"></script>
  <script type="text/javascript">
        var trSrc;
  		function search(){
  			var inputWord = document.getElementById('inputWord').value;
  			var url="SearchList";
  			var params ='inputWord='+inputWord;
  			sendRequest(url, params, 'POST', display);
  		
  		}
  		function display(){
  			if(httpRequest.readyState == 4){
 				if(httpRequest.status ==200){
 					var xmlDoc = httpRequest.responseXML;
 					
 					//清除下拉提示框中已有的数据
 					clearDivData();
 					//将实际数据加入下拉列表框
 					changeDivData(xmlDoc);
 				}else{
 					alert("您请求的页面有异常");
 				}
 			}
  		}
  			//清除下拉提示框中已有的数据
  		function clearDivData(){
  			var tbody  =document.getElementById("wordsListTbody");
  			var trs = tbody.getElementsByTagName("tr");
  			for(var i=trs.length-1;i>=0;i--){
  				tbody.removeChild(trs[i]); //移除子项
  			}
  			
  			
  		}
  		//将实际数据加入下拉列表框
  		function changeDivData(xmlDoc){
  			var words = xmlDoc.getElementsByTagName("word");
  			//alert("字符的长度"+words.length);
  			var tbody  =document.getElementById("wordsListTbody");
  			for(i=0;i<words.length;i++){
  				var newTr = document.createElement("tr");//创建一行
  				var newCell  = document.createElement("td");//创建单元格
  				var wordText = words[i].firstChild.data;
  				var textNode  = document.createTextNode(wordText);
  				newCell.onmouseover=function(){
  					//设置用户选中条目的背景色
  					if(trSrc){
  						trSrc.style.backgroundColor="white";
  					}
  					trSrc=this;
  					trSrc.style.backgroundColor="gray";
  				}
  				
  				newCell.onclick = setText;
  				newCell.appendChild(textNode);
  				newTr.appendChild(newCell);
  				tbody.appendChild(newTr);
  			}
  			if(words.length>0){
  				document.getElementById("wordsListDiv").style.visibility="visible";
  			}else{
  				document.getElementById("wordsListDiv").style.visibility="hidden";
  			}
  		}
  		//将用户选中条目显示在文本框中
  		function setText(){
  			document.getElementById("inputWord").value = trSrc.firstChild.data;
  			document.getElementById("wordsListDiv").style.visibility="hidden";
  		}
  		//设置下拉提示框的位置
  		function seDivPosition(){
  			var input = document.getElementById("inputWord");
  			var listdiv = document.getElementById("wordsListDiv");
  			listdiv.style.left=(input.offsetLeft)+'px';
  			listdiv.style.border ="blue 1px solid";
  			listdiv.style.top=(input.offsetTop+input.offsetHeight)+"px";
  			listdiv.style.width=input.offsetWidth+"px";
  		}
  		
  		
  		
  
  
  </script>
  
  
   
  
  <body onload="seDivPosition()">
    <p>搜索字符串:<input type="text" id="inputWord"  onKeyUp="search()"/></p>
    <div id="wordsListDiv" style="position:absolute;visibility:hidden">
    	<table id="wordsListTable">
    		<tbody id="wordsListTbody">
    			<tr>
    				<td>test</td>
    			</tr>
    		</tbody>
    	</table>
    </div>
  </body>
</html>
