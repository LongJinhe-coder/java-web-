package com.etc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.UserDao;

public class RegisterCheck extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public RegisterCheck() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		  //设置编码格式
		  //设置请求编码格式request
		     request.setCharacterEncoding("utf-8");
		     //设置响应编码格式response
		     response.setCharacterEncoding("utf-8"); 
		  PrintWriter out = response.getWriter();
		  //System.out.println("我来了");
		  //获取浏览器传递的用户名和密码
		  String username=request.getParameter("username");
		  String register = request.getParameter("register");
		  System.out.println("register:"+register);
		  UserDao userDao = new UserDao();
		  boolean flag = userDao.userQuery(username);
		  String reqname = "^[A-Za-z][A-Za-z0-9]+$";
		  String reqpwd = "^[0-9]{6,10}$";
		  
		  System.out.println("username="+username);
		  if(flag) {
			   out.print("用户名已存在，不能重复！");
		  }else if(username.length()<6) {
			   out.print("用户名长度不能小于6！");
		  }else if(!username.matches(reqname)) {
		   out.print("用户名格式错误！");
		  }else {
		   String userpwd=request.getParameter("password");
		   String userpwd2=request.getParameter("password2");
		   if(!"".equals(userpwd)) {
		    if(!userpwd.matches(reqpwd)) {
		     out.print("密码格式错误！");
		    } else if(!"".equals(userpwd2)) {
			    if(!userpwd2.matches(reqpwd)) {
				     out.print("确认密码格式错误！");
				    }else if(!userpwd.equals(userpwd2)){
				     out.print("两次输入的密码不一致！");
				    }else if(register.equals("yes")){
				    	
				    	 out.print("注册成功！");
					}
				   }else {
				    out.print("确认密码不能为空！");
				   }
		   }else{
		    out.print("密码不能为空！");
		   }
		  
		  }
		  out.flush();
		  out.close();
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
