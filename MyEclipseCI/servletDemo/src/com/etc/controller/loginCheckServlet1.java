package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginCheckServlet1 extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public loginCheckServlet1() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("username");
	  	String password = request.getParameter("password");
	  	
	  	//创建一个登录信息
	  	String info="";
	  	if (name.equals("ljh")&&password.equals("123")) {
			info= "欢迎您"+name;
		}else {
			info = "用户名或密码错误";
		}
//	  	PrintWriter out = response.getWriter();//创建一个out对象
//	  	out.print(info);
//	  	out.flush();
//	  	out.close();
	  	//将info保存在request属性中
	  	request.setAttribute("info", info);
	  //将用户名保存在session中
	  	//创建session对象
	  	HttpSession session = request.getSession();
	  	session.setAttribute("name", name);
	  	request.getRequestDispatcher("info.jsp").forward(request, response);
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
