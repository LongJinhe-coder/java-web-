<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'personalzhuce.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
 <meta charset="utf-8">
  <title>Layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
  </head>
  
  <body>


 <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend align="left" style="color:green;">招聘信息填写</legend>
</fieldset>
<form class="layui-form" action="">
<div class="layui-form-item">
    <label class="layui-form-label">招聘编号</label>
    <div class="layui-input-inline">
      <input type="text" name="RecruitmentID"   autocomplete="off" class="layui-input">
    </div>
    
    <label class="layui-form-label">企业编号</label>
     <div class="layui-input-inline">
      <input type="text" name="firmID" "autocomplete="off" class="layui-input">
    </div>
  </div>

 <div class="layui-form-item">  
    <label class="layui-form-label">招聘岗位</label>  
    <div class="layui-input-inline">
      <input type="text" name="position"   autocomplete="off" class="layui-input">
    </div>
    
  </div>
  <div class="layui-form-item">
      <label class="layui-form-label">岗位描述</label>
      <div class="layui-input-inline">
        <input type="text" name="positionInfo"  class="layui-input">
      </div>
 </div>
 
<div class="layui-form-item">
      <label class="layui-form-label">招聘数量</label>
      <div class="layui-input-inline">
       <input type="text" name="number"   class="layui-input">
        
		</div>
		
    <label class="layui-form-label">员工薪资</label>
    <div class="layui-input-inline">
        <input type="text" name="salary" class="layui-input">
     </div> 
    
  </div>

   <div class="layui-form-item">
   
    <label class="layui-form-label">联系电话</label>
    <div class="layui-input-block" style="width:500px">
     <input type="text" name="phone"   class="layui-input">  
    </div>
  </div>
  
   <div class="layui-form-item">
   
    <label class="layui-form-label">工作地址</label>
    <div class="layui-input-block" style="width:500px">
     <input type="text" name="address"   class="layui-input">  
    </div>
  </div>
 
 <div class="layui-form-item">
   
    <label class="layui-form-label">截止日期</label>
    <div class="layui-input-block" style="width:250px">
     <input type="text"  id="date" name="date"   class="layui-input">  
    </div>
  </div>
  
  
  <div class="layui-form-item">    <div class="layui-input-block">
      <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div> 
  </form> 
 
 
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  //日期
  laydate.render({
    elem: '#date'
  });
  laydate.render({
    elem: '#date1'
  });
  
  //创建一个编辑器
  var editIndex = layedit.build('LAY_demo_editor');
 
  //自定义验证规则
  form.verify({
    title: function(value){
      if(value.length < 2){
        return '企业名至少得2个字符啊';
      }
    }
    ,pass: [
      /^[\S]{6,12}$/
      ,'密码必须6到12位，且不能出现空格'
    ]
    ,content: function(value){
      layedit.sync(editIndex);
    }
  });
  
  
  //监听提交
  form.on('submit(demo1)', function(data){
    layer.alert(JSON.stringify(data.field), {
      title: '最终的提交信息'
    })
    return false;
  });
 
  
  
  //表单取值
  layui.$('#LAY-component-form-getval').on('click', function(){
    var data = form.val('example');
    alert(JSON.stringify(data));
  });
  
});
  

</script>
  </body>
</html>