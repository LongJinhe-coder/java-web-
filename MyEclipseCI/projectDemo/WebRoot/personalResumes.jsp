<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.etc.dao.UserDao" %>
<%@ page import="com.etc.entity.User" %>
<%@ page import="com.etc.dao.ResumeDao" %>
<%@ page import="com.etc.entity.Resume" %>
<%@page import="javax.swing.JOptionPane"%>
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
<%	String adminName = (String)session.getAttribute("adminname");
  System.out.println("yonghuming"+adminName);
		UserDao userdao  =  new UserDao();
		List<User> list  =  userdao.queryAllUsers();
		User userRe=new User();
		int id=0;
		for(User user : list) {
			if(adminName.equals(user.getUserName())){
			userRe.setEmail(user.getEmail());
			userRe.setUserPwd(user.getUserPwd());
			userRe.setAvatarName(user.getAvatarName());
			userRe.setUserID(user.getUserID());
			id=user.getUserID();
			System.out.println("yes");
			}
			//System.out.println(user);
		}
		ResumeDao resumeDao=new ResumeDao();
		List<Resume> list2  =  resumeDao.queryAllResumes();
		Resume resume=new Resume();
		String index="register()";
		for(Resume re : list2) {
		if(id==(re.getUser().getUserID())){
			resume=re;
			JOptionPane.showMessageDialog(null,"您已填写简历，若需修改请前往修改界面");
			System.out.println(resume);
			index="donothing()";
			//request.getRequestDispatcher("changePersonalResume.jsp").forward(request, response);
			//System.out.println("okok3");
		}
		}
 %>
<form class="layui-form" action="" method="post" id="form">

<div class="layui-form-item">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-block">
      <input type="text" name="name" id="name" lay-verify="title" autocomplete="off" placeholder="请输入姓名" class="layui-input">
    </div>
  </div>

 <div class="layui-form-item">  
 <div class="layui-inline">
    <label class="layui-form-label">性别</label>  
      
   <div class="layui-input-inline">

      <select name="sex" id="sex" lay-filter="aihao">
        <option value="男" selected="selected">男</option>
        <option value="女">女</option>
      </select>
  </div>
   </div>
      <label class="layui-form-label">出生日期</label>
      <div class="layui-input-inline">
        <input type="text" name="date" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
      </div>
    </div>
   
   
   <div class="layui-form-item">
   <div class="layui-inline">
      <label class="layui-form-label">民族</label>
      <div class="layui-input-inline">
        <select name="nation" id="nation" lay-verify="required" lay-search="">
          <option value="">直接选择或搜索选择</option>
          <option value="汉族">汉族</option>
          <option value="蒙古族">蒙古族</option>
          <option value="回族">回族</option>
          <option value="藏族">藏族</option>
          <option value="维吾尔族">维吾尔族</option>
          <option value="苗族">苗族</option>
          <option value="彝族">彝族</option>
          <option value="壮族">壮族</option>
          <option value="布依族">布依族</option>
          <option value="朝鲜族">朝鲜族</option>
          <option value="满族">满族</option>
          <option value="侗族">侗族</option>
          <option value="瑶族">瑶族</option>
          <option value="白族">白族</option>
          <option value="土家族">土家族</option>
          <option value="哈尼族">哈尼族</option>
          <option value="哈萨克族">哈萨克族</option>
          <option value="傣族">傣族</option>
          <option value="黎族">黎族</option>
          <option value="僳僳族">僳僳族</option>
          <option value="佤族">佤族</option>
          <option value="畲族">畲族</option>
          <option value="高山族">高山族</option>
		  <option value="拉祜族">拉祜族</option>
          <option value="水族">水族</option>
          <option value="东乡族">东乡族</option>
          <option value="纳西族">纳西族</option>
          <option value="景颇族">景颇族</option>
          <option value="柯尔克孜族">柯尔克孜族</option>
          <option value="土族">土族</option>
          <option value="达斡尔族">达斡尔族</option>
          <option value="仫佬族">仫佬族</option>
          <option value="羌族">羌族</option>
          <option value="布朗族">布朗族</option>
          <option value="撒拉族">撒拉族</option>
          <option value="毛南族">毛南族</option>
          <option value="仡佬族">仡佬族</option>
          <option value="锡伯族">锡伯族</option>
          <option value="阿昌族">阿昌族</option>
          <option value="普米族">普米族</option>
		  <option value="塔吉克族">塔吉克族</option>
		  <option value="怒族">怒族</option>
		  <option value="乌孜别克族">乌孜别克族</option>
		  <option value="俄罗斯族">俄罗斯族</option>
		  <option value="鄂温克族">鄂温克族</option>
		  <option value="德昂族">德昂族</option>
		  <option value="保安族">保安族</option>
		  <option value="裕固族">裕固族</option>
		  <option value="京族">京族</option>
		  <option value="塔塔尔">塔塔尔族</option>
		  <option value="独龙族">独龙族</option>
		  <option value="鄂伦春族">鄂伦春族</option>
		  <option value="赫哲族">赫哲族</option>
		  <option value="门巴族">门巴族</option>
		  <option value="珞巴族">珞巴族</option>
		  <option value="基诺族">基诺族</option>
        </select>
      </div>
    </div>
  </div>
   
   <div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">婚姻状况</label>
    <div class="layui-input-block">
      <select name="marryStatus" id="marryStatus" lay-filter="aihao">
        <option value=""  selected=""></option>
        <option value="未婚">未婚</option>
        <option value="已婚">已婚</option>
        <option value="离婚">离婚</option>
        <option value="丧偶">丧偶</option>

      </select>
    </div>
  </div>
   </div>
   <div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">政治面貌</label>
    <div class="layui-input-block">
      <select name="politicsStatus" id="politicsStatus" lay-filter="aihao">
        <option value="" selected=""></option>
        <option value="中共党员">中共党员 </option>
        <option value="中共预备党员">中共预备党员</option>
        <option value="共青团员">共青团员</option>
        <option value="民革党员">民革党员</option>
        <option value="民盟盟员">民盟盟员 </option>
        <option value="民建会员">民建会员</option>
        <option value="民进会员">民进会员 </option>
        <option value="农工党党员">农工党党员</option>
        <option value="致公党党员">致公党党员 </option>
        <option value="九三学社社员">九三学社社员</option>
        <option value="台盟盟员">台盟盟员 </option>
        <option value="无党派民主人士">无党派民主人士 </option>
        <option value="群众">群众</option>
      </select>
    </div>
  </div>
   </div>
   
   <div class="layui-form-item">
    <label class="layui-form-label">毕业院校</label>
    <div class="layui-input-block">
      <input type="text" name="school" id="school" lay-verify="title" autocomplete="off" placeholder="请输入毕业院校" class="layui-input">
    </div>
  </div>
  
    <div class="layui-form-item">
    <label class="layui-form-label">所学专业</label>
    <div class="layui-input-block">
      <input type="text" name="major" id="major" lay-verify="title" autocomplete="off" placeholder="请输入您的专业" class="layui-input">
    </div>
  </div>
   
   <div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">最高学历</label>
    <div class="layui-input-block">
      <select name="qualification" id="qualification" lay-filter="aihao">
        <option value="" selected=""></option>
        <option value="小学">小学</option>
        <option value="初中">初中</option>
        <option value="高中/职高/技校">高中/职高/技校</option>
        <option value="专科">专科</option>
        <option value="本科">本科</option>
        <option value="硕士研究生">硕士研究生</option>
        <option value="博士研究生">博士研究生</option>
      </select>
    </div>
  </div>
   </div>
   
    <div class="layui-form-item">
    <label class="layui-form-label">现居住地</label>
    <div class="layui-input-block">
      <input type="text" name="residence" id="residence" lay-verify="title" autocomplete="off" placeholder="请输入现居住地" class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">籍贯</label>
    <div class="layui-input-block">
      <input type="text" name="nativePlace" id="nativePlace" lay-verify="title" autocomplete="off" placeholder="请输入籍贯" class="layui-input">
    </div>
  </div>
   
    <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">期望薪资</label>
      <div class="layui-input-inline" style="width: 100px;">
        <input type="text" name="price_min" id="price_min" placeholder="￥" autocomplete="off" class="layui-input">
      </div>
      <div class="layui-form-mid">-</div>
      <div class="layui-input-inline" style="width: 100px;">
        <input type="text" name="price_max" id="price_max" placeholder="￥" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
   <div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">求职状态</label>
    <div class="layui-input-block">
      <select name="jobStatus" id="jobStatus" lay-filter="aihao">
        <option value="" selected=""></option>
        <option value="目前正在找工作">目前正在找工作</option>
        <option value="目前正在找工作">半年内无换工作计划</option>
        <option value="一年内无换工作计划">一年内无换工作计划</option>
        <option value="观望有好的机会再考虑">观望有好的机会再考虑</option>
        <option value="我暂时不想找工作">我暂时不想找工作</option>
      </select>
    </div>
  </div>
   </div>
   
      <div class="layui-form-item">
    <label class="layui-form-label">技术特长</label>
    <div class="layui-input-block">
      <input type="text" name="technologySpecialty" id="technologySpecialty" lay-verify="title" autocomplete="off" placeholder="请输入技术特长" class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">工作经历</label>
    <div class="layui-input-block">
      <input type="text" name="workExperience" id="workExperience" lay-verify="title" autocomplete="off" placeholder="请输入您的工作经历" class="layui-input">
    </div>
  </div>
   

  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">手机号</label>
      <div class="layui-input-inline">
        <input type="tel" name="phone" id="phone" lay-verify="required|phone" autocomplete="off" class="layui-input" placeholder="请输入常用的手机号">
      </div>
    </div>
    
    </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">个人介绍</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入内容" class="layui-textarea" id="personalIntroduction" name="personalIntroduction"></textarea>
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
      <input type="radio" name="agree" value="1" title="是" checked="">
      <input type="radio" name="agree" value="0" title="否">
     <!--<input type="radio" name="sex" value="禁" title="禁用" disabled="">--> 
    </div>
  </div>
  </div>


  <div class="layui-form-item">    <div class="layui-input-block">
      <button type="button" class="layui-btn"lay-filter="demo1" onclick="<%=index%>">立即提交</button>
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
function donothing(){
alert("请勿重复填写简历");
}
function register(){ 
  var id=<%=userRe.getUserID()%>;
  var birthDate = document.getElementById("date").value;
  var name = document.getElementById("name").value;
  var nation = document.getElementById("nation").value;
  var marriage = document.getElementById("marryStatus").value;
  var politicStatus = document.getElementById("politicsStatus").value;
  var school = document.getElementById("school").value;
  var learnMajor = document.getElementById("major").value;
  var degree = document.getElementById("qualification").value;
  var livingPlace = document.getElementById("residence").value;
  var nativePlace = document.getElementById("nativePlace").value;
  //alert("!!");
  var expectSalary = document.getElementById("price_min").value+"-"+document.getElementById("price_max").value;
  var workStatus = document.getElementById("jobStatus").value;
  var skill = document.getElementById("technologySpecialty").value;
  var workExper = document.getElementById("workExperience").value;
  var phone = document.getElementById("phone").value;
  var introduce = document.getElementById("personalIntroduction").value;
  //alert(id);
  var sex = document.getElementById("sex").value;
   var radios = document.getElementsByName("agree");
        var radio = radios[0];
        if (!radio.checked) {           //判断是否选中
            alert("需同意服务条款和隐私政策");
            request.getRequestDispatcher("personalCenter.jsp").forward(request, response);
        }   
  //alert(sex);
  location.href="ResumeServlet?option=addAccount&id="+id+"&sex="+sex+"&introduce="+introduce+"&phone="+phone+"&workExper="+workExper+"&skill="+skill+"&workStatus="+workStatus+"&expectSalary="+expectSalary+"&nativePlace="+nativePlace+"&livingPlace="+livingPlace+"&degree="+degree+"&learnMajor="+learnMajor+"&school="+school+"&politicStatus="+politicStatus+"&marriage="+marriage+"&nation="+nation+"&name="+name+"&birthDate="+birthDate+"";
  }
</script>
  </body>
</html>