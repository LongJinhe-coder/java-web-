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
  <legend align="left" style="color:green;">修改企业信息</legend>
</fieldset>
<form class="layui-form" action="">

<div class="layui-form-item">
    <label class="layui-form-label">企业编号</label>
    <div class="layui-input-block">
      <input style="width:190px"type="text" name="firmID" value="350521"   autocomplete="off" class="layui-input">
    </div>
  </div>

 <div class="layui-form-item">  
    <label class="layui-form-label">管理员编号</label>  
    <div class="layui-input-inline">
      <input type="text" name="adminID" value="001"   autocomplete="off" class="layui-input">
    </div>
      <label class="layui-form-label">企业用户名</label>
      <div class="layui-input-inline">
        <input type="text" name="firmAccount" value="163@qq.com" class="layui-input">
      </div>
      
      <label class="layui-form-label">注册时间</label>
      <div class="layui-input-inline">
       <input type="text" name="registerTime"  value="2020-7-24"  class="layui-input">
        
		</div>
    </div>
   
   <div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">公司名称</label>
    <div class="layui-input-block">
        <input type="text" name="firmName"  value="Higher Brother"  class="layui-input">
    </div>
  </div>
   </div>
   
   <div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">注册地区</label>
    <div class="layui-input-block">
     <input type="text" name="registerArea"  value="xx省-xx市"  class="layui-input">  
    </div>
  </div>
   </div>
   
   <div class="layui-form-item">
   
    <label class="layui-form-label">公司性质</label>
    <div class="layui-input-inline">
      <input type="text" name="firmNature" value="电竞公司"   class="layui-input">
    </div>
    <label class="layui-form-label">注册资金</label>
    <div class="layui-input-inline">
      <input type="text" name="registerFund" value="999999.9" class="layui-input">
    </div>
    <label class="layui-form-label">公司简介</label>
    <div class="layui-input-inline">
    <input type="text" name="firmBrief" value="Very Nice"  class="layui-input">
    </div>
  </div>
   
    <div class="layui-form-item">
    <label class="layui-form-label">联系人</label>
    <div class="layui-input-block">
      <input type="text" name="linkMan" value="龙某河" class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">联系电话</label>
    <div class="layui-input-block">
      <input type="text" name="linkPhone" value="110"  class="layui-input">
    </div>
  </div>
   
    <div class="layui-form-item">
    <div class="layui-inline">
    <label class="layui-form-label">公司地址</label>
    <div class="layui-input-inline">
    <input type="text" name="firmArea" value="xx省--xx市" class="layui-input">
    </div>
      <label class="layui-form-label">注册号</label>
      <div class="layui-input-inline" style="width: 100px;">
        <input type="text" name="registerNum" value="12580"  class="layui-input">
      </div>
     
    </div>

  </div>
   <div class="layui-form-item">
   <div class="layui-inline">
    
  </div>
   </div>
   
      <div class="layui-form-item">
    <label class="layui-form-label">企业邮箱</label>
    <div class="layui-input-block">
      <input type="text" name="firmEmail" value="77456@qq.com"  class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">审核状态</label>
    <div class="layui-input-block">
      <input type="text" name="checkStatus" value="通过" class="layui-input">
    </div>
  </div>
   

  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">企业密码</label>
      <div class="layui-input-inline">
        <input type="text" name="frimpwd"  value="*******" class="layui-input">
      </div>
    </div>
    
    
     <div class="layui-form-item">

      <label class="layui-form-label">账号状态</label>
      <div class="layui-input-block">
        <input type="text" name="accountStatus"  value="已冻结" class="layui-input">
      </div>
    </div>
    
    <div class="layui-form-item">
        <div class="layui-input-inline">&nbsp;&nbsp;&nbsp;&nbsp;<button  class="layui-btn" type="submit">提交</button></div>
        <div class="layui-input-inline"><button  class="layui-btn" type="reset" >重置</button></div>
        <!-- 重置暂未实现 -->
    </div>
    </div>
  
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