<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- 
	<link rel="stylesheet" type="text/css" media="all" href="layui/css/layui.css"> -->
	
 <meta charset="utf-8">
  <title>Layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
  </head>

 
<ul class="layui-nav layui-bg-cyan">
  <li class="layui-nav-item layui-this"><a href="firmregister.jsp">企业注册</a></li>
  <li class="layui-nav-item"><a href="personalregister.jsp">应聘者注册</a></li>
</ul>
<br>
<form class="layui-form" action="" method="post" id="form" >
    <label class="layui-form-label">企业名称（全名）</label>
    <div class="layui-input-block">
      <input type="text" name="firmname" id="firmname" value="${firmname}" lay-verify="title" autocomplete="off" placeholder="请输入企业名称" class="layui-input">
    </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">注册号</label>
    <div class="layui-input-block">
      <input type="text" name="firmid" id="firmid" value="${firmid}" lay-verify="required" lay-reqtext="注册号是必填项，岂能为空？" placeholder="请输入注册号" autocomplete="off" class="layui-input">
    </div>
  </div>
  

    <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">邮箱</label>
      <div class="layui-input-inline">
        <input type="text" name="email" id="email" value="${email}" lay-verify="email" autocomplete="off" class="layui-input" placeholder="邮箱将用作您的用户名">
       </div>
      </div>
    </div>
     
     <div class="layui-form-item">
   <label class="layui-form-label">验证码</label>
    <div class="layui-input-inline">
      <input type="text" name="check" id="check" lay-verify="check" autocomplete="off" placeholder="请输入验证码" class="layui-input">
    </div>
    
    <div class="layui-col-md2">
        <img border="0" src="checkcode" />
	   <input class="layui-btn layui-btn-radius"  type="submit" value="换一张" onclick="document.getElementById('form').action='ChangeCheckCode3'"/>
    </div>
    </div>
  
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">手机号</label>
      <div class="layui-input-inline">
        <input type="tel" name="phone" id="phone" value="${phone}" lay-verify="required|phone" autocomplete="off" class="layui-input" placeholder="请输入企业常用的手机号">
      </div>
    </div>
    </div>
     <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">注册资金</label>
      <div class="layui-input-inline">
        <input type="tel" name="money" id="money" value="${money}" autocomplete="off" class="layui-input" placeholder="请输入企业注册资金">
      </div>
    </div>
    
    </div>
 
  <div class="layui-form-item">
    <label class="layui-form-label">密码</label>
    <div class="layui-input-inline">
      <input type="password" name="password" value="${password}" id="password" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
  </div>
 
  
 <div class="layui-form-item">
    <label class="layui-form-label">企业注册地</label>
    <div class="layui-input-block">
      <input type="text" name="registerplace" value="${registerplace}" id="registerplace" autocomplete="off" placeholder="xx省-xx市-xx区/县" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
  <div class="layui-inline">
      <label class="layui-form-label">注册日期</label>
      <div class="layui-input-inline">
        <input type="text" name="date" id="date" value="${date}" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">企业所在地</label>
    <div class="layui-input-block">
      <input type="text" name="place"  id="place" value="${place}" autocomplete="off" placeholder="请输入企业的详细所在地" class="layui-input">
    </div>
  </div>
  
   
  <div class="layui-form-item">
    <label class="layui-form-label">公司性质</label>
    <div class="layui-input-block">
      <select name="interest" lay-filter="aihao" id="firmnature">
        <option value=""></option>
        <option value="国有企业">国有企业</option>
        <option value="集体企业">集体企业</option>
        <option value="私营企业">私营企业</option>
        <option value="个体工商户">个体工商户</option>
        <option value="合伙企业">合伙企业</option>
        <option value="联营企业">联营企业</option>
        <option value="股份合作制企业">股份合作制企业</option>
        <option value="有限责任公司">有限责任公司</option>
        <option value="股份有限公司">股份有限公司</option>
      </select>
    </div>
  </div>
  
   <div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">联系人</label>
    <div class="layui-input-block">
      <input type="text" name="linkmanname" value="${linkmanname}" id="linkmanname" autocomplete="off" placeholder="请输入联系人姓名" class="layui-input">
    </div>
  </div>

    <div class="layui-inline">
      <label class="layui-form-label">手机号</label>
      <div class="layui-input-inline">
        <input type="tel" name="linkmanphone" value="${linkmanphone}" id="linkmanphone" lay-verify="required|phone" autocomplete="off" class="layui-input" placeholder="请输入联系人的手机号">
      </div>
    </div>
   </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">企业简介</label>
    <div class="layui-input-block">
      <input type="text" name="intro" id="intro" value="${intro}" autocomplete="off" placeholder="请输入企业简介：" class="layui-input">
    </div>
  </div>

 <div class="layui-inline">
    <label class="layui-form-label"></label>
    <div class="layui-input-block">
        <div class="layui-form-mid layui-word-aux">
        <a href="http://localhost:8080/projectDemo/agreement.jsp">我已阅读并同意相关服务条款和隐私政策（点击阅读）</a>
        </div>
    </div>
  </div>
<div class="layui-form-item">
  <div class="layui-inline">
    <label class="layui-form-label"></label>
    <div class="layui-input-block">
      <input type="radio" name="agree" value="1" title="是" checked="">
      <input type="radio" name="agree" value="0" title="否">
     <!--<input type="radio" name="sex" value="禁" title="禁用" disabled="">--> 
    </div>
  </div>
  </div>


  <div class="layui-form-item">
    <div class="layui-input-block">
     <button type="button" class="layui-btn"  onclick="register()">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
 
    
<script src="layui/layui.all.js" charset="utf-8"></script>
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
function refresh(){

  location.href="firmregister.jsp";
}
 function register(){ 
  var firmAccount = document.getElementById("email").value;
  var registerTime = document.getElementById("date").value;
  var password = document.getElementById("password").value;
  var firmName = document.getElementById("firmname").value;
  var registerArea = document.getElementById("registerplace").value;
  var firmNature = document.getElementById("firmnature").value;
  var registerFund = document.getElementById("money").value;
  var firmBrief = document.getElementById("intro").value;
  var linkMan = document.getElementById("linkmanname").value;
  var linkPhone = document.getElementById("linkmanphone").value;
  var firmArea = document.getElementById("place").value;
  var registerNum = document.getElementById("firmid").value;
  var firmEmail = document.getElementById("email").value;
  var check = document.getElementById("check").value;
    var radios = document.getElementsByName("agree");
        var radio = radios[0];
        if (!radio.checked) {           //判断是否选中
            alert("需同意服务条款和隐私政策");
            request.getRequestDispatcher("firmregister.jsp").forward(request, response);
        } 
  location.href="FirmServlet?option=addAccount&firmAccount="+firmAccount+"&registerTime="+registerTime+"&password="+password+"&firmName="+firmName+"&registerArea="+registerArea+"&firmNature="+firmNature+"&registerFund="+registerFund+"&firmBrief="+firmBrief+"&linkMan="+linkMan+"&linkPhone="+linkPhone+"&firmArea="+firmArea+"&registerNum="+registerNum+"&firmEmail="+firmEmail+"&check="+check+"";
  }
</script>
</body>
</html>
