<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.etc.dao.UserDao" %>
<%@ page import="com.etc.entity.User" %>
<%@ page import="com.etc.dao.ResumeDao" %>
<%@ page import="com.etc.entity.Resume" %>
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
<%	System.out.println("okok1");
	String adminName = (String)session.getAttribute("adminname");
  System.out.println("用户名"+adminName);
		UserDao userdao  =  new UserDao();
		List<User> list1  =  userdao.queryAllUsers();
		int id=0;
		for(User user : list1) {
			if(adminName.equals(user.getUserName())){
			id=user.getUserID();
			System.out.println("okok2");
			System.out.println(id);
			}
		//	System.out.println(user);
		}
		ResumeDao resumeDao=new ResumeDao();
		List<Resume> list  =  resumeDao.queryAllResumes();
		Resume resume=new Resume();
		for(Resume re : list) {
		if(id==(re.getUser().getUserID())){
			resume=re;
			System.out.println(resume);
			System.out.println("okok3");
		}
		}
 %>
<form class="layui-form" action="">

<div class="layui-form-item">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-block">
      <input type="text" name="name" value=<%=resume.getName() %> readonly="readonly"  autocomplete="off" class="layui-input">
    </div>
  </div>

 <div class="layui-form-item">  
    <label class="layui-form-label">性别</label>  
    <div class="layui-input-inline">
      <input type="text" name="sex" value=<%=resume.getSex()%> readonly="readonly"  autocomplete="off" class="layui-input">
    </div>
      <label class="layui-form-label">出生日期</label>
      <div class="layui-input-inline">
        <input type="text" name="date" id="date" value=<%=resume.getBirthDate()%> readonly="readonly" class="layui-input">
      </div>
      
      <label class="layui-form-label">民族</label>
      <div class="layui-input-inline">
       <input type="text" name="nation"  value=<%=resume.getNation()%> readonly="readonly" class="layui-input">     
		</div>
    </div>
   
   <div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">婚姻状况</label>
    <div class="layui-input-block">
        <input type="text" name="marryStatus"  value=<%=resume.getMarriage()%> readonly="readonly" class="layui-input">
    </div>
  </div>
   </div>
   
   <div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">政治面貌</label>
    <div class="layui-input-block">
     <input type="text" name="politicsStatus"  value=<%=resume.getPoliticStatus()%> readonly="readonly" class="layui-input">  
    </div>
  </div>
   </div>
   
   <div class="layui-form-item">
   
    <label class="layui-form-label">毕业院校</label>
    <div class="layui-input-inline">
      <input type="text" name="school" value=<%=resume.getSchool()%> readonly="readonly"  class="layui-input">
    </div>
    <label class="layui-form-label">所学专业</label>
    <div class="layui-input-inline">
      <input type="text" name="major" value=<%=resume.getLearnMajor()%> readonly="readonly" class="layui-input">
    </div>
    <label class="layui-form-label">最高学历</label>
    <div class="layui-input-inline">
    <input type="text" name="major" value=<%=resume.getDegree()%> readonly="readonly" class="layui-input">
    </div>
  </div>
   
    <div class="layui-form-item">
    <label class="layui-form-label">现居住地</label>
    <div class="layui-input-block">
      <input type="text" name="residence" value=<%=resume.getLivingPlace()%> readonly="readonly" class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">籍贯</label>
    <div class="layui-input-block">
      <input type="text" name="nativePlace" value=<%=resume.getNativePlace()%> readonly="readonly" class="layui-input">
    </div>
  </div>
   
    <div class="layui-form-item">
    <div class="layui-inline">
    <label class="layui-form-label">求职状态</label>
    <div class="layui-input-inline">
    <input type="text" name="jobStatus" value=<%=resume.getWorkStatus()%> readonly="readonly" class="layui-input">
    </div>
      <label class="layui-form-label">期望薪资</label>
      <div class="layui-input-inline" >
        <input type="text" name="price" value=<%=resume.getExpectSalary()%> readonly="readonly" class="layui-input">
      </div>    
    </div>
  </div>
   
      <div class="layui-form-item">
    <label class="layui-form-label">技术特长</label>
    <div class="layui-input-block">
      <input type="text" name="technologySpecialty" value=<%=resume.getSkill()%> readonly="readonly" class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">工作经历</label>
    <div class="layui-input-block">
      <input type="text" name="workExperience" value=<%=resume.getWorkExper()%> readonly="readonly" class="layui-input">
    </div>
  </div>
   

  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">手机号</label>
      <div class="layui-input-inline">
        <input type="tel" name="phone"  value=<%=resume.getPhone()%> readonly="readonly" class="layui-input">
      </div>
    </div>
    
    </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">个人介绍</label>
    <div class="layui-input-block">
      <textarea name="personalIntroduction" readonly="readonly" class="layui-textarea" ><%=resume.getIntroduce()%>
      </textarea>
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