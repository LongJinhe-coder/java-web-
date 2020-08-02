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

<form class="layui-form" action="">

<div class="layui-form-item">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-block">
      <input type="text" name="name" value="hzj" readonly="readonly"  autocomplete="off" class="layui-input">
    </div>
  </div>

 <div class="layui-form-item">  
    <label class="layui-form-label">性别</label>  
    <div class="layui-input-inline">
      <input type="text" name="sex" value="男" readonly="readonly"  autocomplete="off" class="layui-input">
    </div>
      <label class="layui-form-label">出生日期</label>
      <div class="layui-input-inline">
        <input type="text" name="date" id="date" value="2020-07-24" readonly="readonly" class="layui-input">
      </div>
      
      <label class="layui-form-label">民族</label>
      <div class="layui-input-inline">
       <input type="text" name="nation"  value="汉" readonly="readonly" class="layui-input">
        
		</div>
    </div>
   
   <div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">婚姻状况</label>
    <div class="layui-input-block">
        <input type="text" name="marryStatus"  value="未婚" readonly="readonly" class="layui-input">
    </div>
  </div>
   </div>
   
   <div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">政治面貌</label>
    <div class="layui-input-block">
     <input type="text" name="politicsStatus"  value="共青团员" readonly="readonly" class="layui-input">  
    </div>
  </div>
   </div>
   
   <div class="layui-form-item">
   
    <label class="layui-form-label">毕业院校</label>
    <div class="layui-input-inline">
      <input type="text" name="school" value="华侨大学" readonly="readonly"  class="layui-input">
    </div>
    <label class="layui-form-label">所学专业</label>
    <div class="layui-input-inline">
      <input type="text" name="major" value="软件工程" readonly="readonly" class="layui-input">
    </div>
    <label class="layui-form-label">最高学历</label>
    <div class="layui-input-inline">
    <input type="text" name="major" value="硕士研究生" readonly="readonly" class="layui-input">
    </div>
  </div>
   
    <div class="layui-form-item">
    <label class="layui-form-label">现居住地</label>
    <div class="layui-input-block">
      <input type="text" name="residence" value="福建省泉州市惠安县xxxxxx" readonly="readonly" class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">籍贯</label>
    <div class="layui-input-block">
      <input type="text" name="nativePlace" value="福建-泉州" readonly="readonly" class="layui-input">
    </div>
  </div>
   
    <div class="layui-form-item">
    <div class="layui-inline">
    <label class="layui-form-label">求职状态</label>
    <div class="layui-input-inline">
    <input type="text" name="jobStatus" value="目前正在找工作" readonly="readonly" class="layui-input">
    </div>
      <label class="layui-form-label">期望薪资</label>
      <div class="layui-input-inline" style="width: 100px;">
        <input type="text" name="price_min" value="$20000" readonly="readonly" class="layui-input">
      </div>
      <div class="layui-form-mid">-</div>
      <div class="layui-input-inline" style="width: 100px;">
        <input type="text" name="price_max" value="$30000" readonly="readonly" class="layui-input">
      </div>
    </div>

  </div>
   <div class="layui-form-item">
   <div class="layui-inline">
    
  </div>
   </div>
   
      <div class="layui-form-item">
    <label class="layui-form-label">技术特长</label>
    <div class="layui-input-block">
      <input type="text" name="technologySpecialty" value="精通王者荣耀各英雄操作" readonly="readonly" class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">工作经历</label>
    <div class="layui-input-block">
      <input type="text" name="workExperience" value="网盒教育、中软海晟" readonly="readonly" class="layui-input">
    </div>
  </div>
   

  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">手机号</label>
      <div class="layui-input-inline">
        <input type="tel" name="phone"  value="12345678900" readonly="readonly" class="layui-input">
      </div>
    </div>
    
    </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">个人介绍</label>
    <div class="layui-input-block">
      <textarea name="personalIntroduction" readonly="readonly" class="layui-textarea" >我叫胡图图，今年三岁了，我爸爸叫胡英俊，我妈妈叫张小丽，我家住在翻斗花园二号楼一零零一室，妈妈做的炸小肉丸最好吃；我的猫咪叫小怪，他是一只会说话的猫咪呦，小怪和图图一样是个男孩子，图图最喜欢的好朋友是小美，图图的耳朵很大很神奇，你们看动耳神功。
      </textarea>
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