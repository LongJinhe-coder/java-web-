package com.etc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.dao.AdminDao;
import com.etc.dao.FirmDao;
import com.etc.dao.UserDao;
/*
 * 处理登录请求的Servlet ---LogCheck
 */
public class LogCheck extends HttpServlet {
	
	public LogCheck() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String type = request.getParameter("type");
		String email = request.getParameter("email");
		String userpwd = request.getParameter("password");
		String info = "";
		if (type.equals("应聘者")) {
			System.out.println("用户登录");
			UserDao userDao = new UserDao();
			List<String> infolist = userDao.checkLogin(email, userpwd);
			String userName = infolist.get(0);//用户名
			String accountStatus = infolist.get(1);//账号状态
			String usercheckcode = request.getParameter("checkcode");
			System.out.println("usercheckcode="+usercheckcode);
			HttpSession session = request.getSession();
			String servercheckcode = (String) session.getAttribute("checkCode");
			if (!servercheckcode.equalsIgnoreCase(usercheckcode)) {
				info = "验证码不正确，请重新输入";
				request.setAttribute("info", info);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else if (userName!=null) {
				if (accountStatus.equals("正常")) {
					HttpSession session1 = request.getSession();
					session1.setAttribute("adminname", userName);
					//session1.setAttribute("url", "index.jsp");
					session1.setAttribute("loginname", userName);
					request.getRequestDispatcher("personalCenter.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("freezing.jsp").forward(request, response);
				}
			} else {
				info = "用户名或密码不正确";
				request.setAttribute("info", info);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}

		}else if (type.equals("企业")) {
			System.out.println("企业登录");
			FirmDao firmDao = new FirmDao();
			List<String> infolist = firmDao.checkLogin(email, userpwd);
			String firmName = infolist.get(0);//用户名
			String accountStatus = infolist.get(1);//账号状态
			String usercheckcode = request.getParameter("checkcode");
			System.out.println("usercheckcode="+usercheckcode);
			HttpSession session = request.getSession();
			String servercheckcode = (String) session.getAttribute("checkCode");
			if (!servercheckcode.equalsIgnoreCase(usercheckcode)) {
				info = "验证码不正确，请重新输入";
				request.setAttribute("info", info);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else if (firmName!=null) {
				if (accountStatus.equals("正常")) {
					HttpSession session1 = request.getSession();
					//session1.setAttribute("url", "index.jsp");
					session1.setAttribute("firmname", firmName);
					session1.setAttribute("loginname", firmName);
					request.getRequestDispatcher("firmhome.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("freezing.jsp").forward(request, response);
				}
			} else {
				info = "用户名或密码不正确";
				request.setAttribute("info", info);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}else if (type.equals("管理员")) {
			System.out.println("管理员登录");
			AdminDao adminDao = new AdminDao();
			String adminName = adminDao.checkLogin(email, userpwd);
			String usercheckcode = request.getParameter("checkcode");
			System.out.println("usercheckcode="+usercheckcode);
			HttpSession session = request.getSession();
			String servercheckcode = (String) session.getAttribute("checkCode");
			if (!servercheckcode.equalsIgnoreCase(usercheckcode)) {
				info = "验证码不正确，请重新输入";
				request.setAttribute("info", info);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else if (adminName!=null) {
				HttpSession session1 = request.getSession();
				session1.setAttribute("url", "index.jsp");
				session1.setAttribute("loginname", adminName);
				session1.setAttribute("adminname", adminName);
				request.getRequestDispatcher("adminhome.jsp").forward(request, response);
			} else {
				info = "用户名或密码不正确";
				request.setAttribute("info", info);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}else {
			info = "请选择您的身份!";
			request.setAttribute("info", info);
			//response.sendRedirect("/login.jsp");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
