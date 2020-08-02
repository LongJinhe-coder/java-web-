package com.etc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormCheck extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public FormCheck() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
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
		  System.out.println("username="+username);
		  if(!"张三".equals(username)) {
		   out.print("用户名不存在");
		  }else {
		   String userpwd=request.getParameter("password");
		   if(!"".equals(userpwd)) {
		    if("123".equals(userpwd)) {
		     out.print("欢迎登陆！");
		    }else {
		     out.print("密码错误！");
		    }
		   }else {
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
