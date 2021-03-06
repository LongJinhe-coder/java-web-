<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.etc.dao.UserDao" %>
<%@ page import="com.etc.entity.User" %>
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
<%	
	String adminName = (String)session.getAttribute("adminname");
  System.out.println("yonghuming"+adminName);
		UserDao userdao  =  new UserDao();
		List<User> list  =  userdao.queryAllUsers();
		User userRe=new User();
		for(User user : list) {
			if(adminName.equals(user.getUserName())){
			userRe.setEmail(user.getEmail());
			userRe.setUserPwd(user.getUserPwd());
			userRe.setAvatarName(user.getAvatarName());
			userRe.setUserID(user.getUserID());
			System.out.println("yes");
			}
			System.out.println(user);
		}
 %>

<form class="layui-form" action="" method="post" id="form">

<div class="layui-form-item">
    <label class="layui-form-label">用户名</label>
    <div class="layui-input-block">
      <input type="text" name="title" lay-verify="title" id="title" autocomplete="off" value=<%=userRe.getEmail() %> class="layui-input">
    </div>
  </div>

 <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">验证邮箱</label>
      <div class="layui-input-inline">
        <input type="text" name="email" lay-verify="email" id="email" autocomplete="off" class="layui-input" value=<%=userRe.getEmail() %>>
        </div>
    </div>
    </div>
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">手机号</label>
      <div class="layui-input-inline">
        <input type="tel" name="phone" lay-verify="required|phone" id="phone" autocomplete="off" class="layui-input" value=<%=userRe.getAvatarName() %>>
      </div>
    </div>
    
    </div>
 
  <div class="layui-form-item">
    <label class="layui-form-label">密码</label>
    <div class="layui-input-inline">
      <input type="password" name="password" lay-verify="pass" id="password" value=<%=userRe.getUserPwd() %> autocomplete="off" class="layui-input">
    </div>
    <div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
  </div>     

     <div class="layui-form-item">
   <label class="layui-form-label">验证码</label>
    <div class="layui-input-inline">
      <input type="text" name="check" lay-verify="check" autocomplete="off" id="check" placeholder="请输入验证码" class="layui-input">
    </div>
    
    <div class="layui-col-md2">
        <img border="0" src="checkcode"/>
	   <input class="layui-btn layui-btn-radius" type="submit" value="换一张" onclick="refresh()"/>
    </div>
    </div>
  
<div class="layui-form-item">
 <div class="layui-inline">
    <label class="layui-form-label"></label>
    <div class="layui-input-block">
        <div class="layui-form-mid layui-word-aux">我已阅读并同意相关服务条款和隐私政策</div>
    </div>
  </div>
    </div>
  
<div class="layui-form-item">
  <div class="layui-inline">
    <label class="layui-form-label"></label>
    <div class="layui-input-block">
      <input type="radio" name="sex" value="是" title="是" checked="">
      <input type="radio" name="sex" value="否" title="否">
     <!--<input type="radio" name="sex" value="禁" title="禁用" disabled="">--> 
    </div>
  </div>
  </div>


  <div class="layui-form-item">    <div class="layui-input-block">
      <button type="button" class="layui-btn"  lay-filter="demo1" onclick="register()">立即提交</button>
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
 function refresh(){

  location.href="personalCenter.jsp";
  }
 function register(){
  var name = document.getElementById("title").value;
  var email = document.getElementById("email").value;
  var password = document.getElementById("password").value;
  var phone = document.getElementById("phone").value;
  var check = document.getElementById("check").value;
  var id=<%=userRe.getUserID()%>;
  alert(id);
  location.href="UserServlet?option=changeAccount&name="+name+"&email="+email+"&password="+password+"&phone="+phone+"&check="+check+"&id="+id+"";
  }
</script>
  </body>
</html>
