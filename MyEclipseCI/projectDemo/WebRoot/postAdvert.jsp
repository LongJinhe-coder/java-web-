<%@ page pageEncoding="utf-8"%>
<html>
	<head>
	<script src="js/jquery-3.2.1.js"></script>
	<script>
		function f(){
			//获取文件完整路径
			var fullName=form1.avatar.value;
			//字符截取，截取路径获得文件名
			var fileName = fullName.substring(fullName.lastIndexOf("\\")+1);
			//获取-所在索引的值
			var pos1=fileName.indexOf("-");
			return true;
		}
		$(function(){
             $("#avatsel").click(function(){
                 $("input[type='file']").trigger('click');
             });
             $("#avatval").click(function(){
                 $("input[type='file']").trigger('click');
             });
             $("input[type='file']").change(function(){
                 $("#avatval").val($(this).val());
             });
         });
	</script>
	<style type="text/css">
		 a{
		 	text-decoration:none;
		 }
         a[class="button-selectimg"],input[type='submit']{
	         color:#00A2D4;
	         padding:4px 6px;
	         border:1px dashed #00A2D4;
	         border-radius:2px;
         }
         input[id="avatval"]{
	         padding:3px 6px;
	         padding-left:10px;
	         border:1px solid #E7EAEC;
	         width:230px;
	         height:25px;
	         line-height:25px;
	         border-left:3px solid #3FB7EB;
	         background:#FAFAFB;
	         border-radius:2px;
         }
         input[type='file']{
	         border:0px;
	         display:none;
         }
	</style>
	</head>
	
	<body>

		<div>
			<form method="post" action="UpLoad2" enctype="multipart/form-data" name="form1">
				<input type="text" id="avatval" placeholder="请选择文件···" readonly="readonly" style="vertical-align: middle;"/>
				<a href="javascript:void(0);" class="button-selectimg" id="avatsel">选择文件</a>
				<input type="file" id="avatar" name="avatar" contenteditable="false" onclick="info.innerHTML=''" /><br/>
				<input type="submit" value="上传" onclick="return f();" />
			</form>
		</div>
		<div id="info">
			${message}
		</div>

	</body>
</html>