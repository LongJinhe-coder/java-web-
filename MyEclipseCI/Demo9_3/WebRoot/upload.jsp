<%@ page pageEncoding="utf-8"%>
<html>
	<head>
		<script>
function f(){
var fullName=form1.file1.value;
var fileName = fullName.substring(fullName.lastIndexOf("\\")+1);
var pos1=fileName.indexOf("-");
if(pos1!=8){
alert("学号必须为8位,后面跟短横线-而非下划线_");
return false;
}
else{

var mainName=fileName.substring(0,8);
var pno=fileName.substring(9,fileName.indexOf("."));
if(!confirm("请确认你的学号："+mainName+"，题号："+pno+"，确认要上传吗？"))
  return false;
}

}
</script>
	</head>
	<body>
		上传文件的主名要求：学号-题号，学号为8位。
		<form method="post" action="upload" enctype="multipart/form-data"
			name="form1">
			<input type="file" name="file1" contenteditable="false"
				onclick="info.innerHTML=''" />
			<br />
			<input type="submit" value="上传" onclick="return f();" />
		</form>
		<div id="info">
			${message}
		</div>

	</body>
</html>