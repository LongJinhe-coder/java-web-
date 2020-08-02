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
 * ������¼�����Servlet ---LogCheck
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
		if (type.equals("ӦƸ��")) {
			System.out.println("�û���¼");
			UserDao userDao = new UserDao();
			List<String> infolist = userDao.checkLogin(email, userpwd);
			String userName = infolist.get(0);//�û���
			String accountStatus = infolist.get(1);//�˺�״̬
			String usercheckcode = request.getParameter("checkcode");
			System.out.println("usercheckcode="+usercheckcode);
			HttpSession session = request.getSession();
			String servercheckcode = (String) session.getAttribute("checkCode");
			if (!servercheckcode.equalsIgnoreCase(usercheckcode)) {
				info = "��֤�벻��ȷ������������";
				request.setAttribute("info", info);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else if (userName!=null) {
				if (accountStatus.equals("����")) {
					HttpSession session1 = request.getSession();
					session1.setAttribute("adminname", userName);
					//session1.setAttribute("url", "index.jsp");
					session1.setAttribute("loginname", userName);
					request.getRequestDispatcher("personalCenter.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("freezing.jsp").forward(request, response);
				}
			} else {
				info = "�û��������벻��ȷ";
				request.setAttribute("info", info);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}

		}else if (type.equals("��ҵ")) {
			System.out.println("��ҵ��¼");
			FirmDao firmDao = new FirmDao();
			List<String> infolist = firmDao.checkLogin(email, userpwd);
			String firmName = infolist.get(0);//�û���
			String accountStatus = infolist.get(1);//�˺�״̬
			String usercheckcode = request.getParameter("checkcode");
			System.out.println("usercheckcode="+usercheckcode);
			HttpSession session = request.getSession();
			String servercheckcode = (String) session.getAttribute("checkCode");
			if (!servercheckcode.equalsIgnoreCase(usercheckcode)) {
				info = "��֤�벻��ȷ������������";
				request.setAttribute("info", info);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else if (firmName!=null) {
				if (accountStatus.equals("����")) {
					HttpSession session1 = request.getSession();
					//session1.setAttribute("url", "index.jsp");
					session1.setAttribute("firmname", firmName);
					session1.setAttribute("loginname", firmName);
					request.getRequestDispatcher("firmhome.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("freezing.jsp").forward(request, response);
				}
			} else {
				info = "�û��������벻��ȷ";
				request.setAttribute("info", info);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}else if (type.equals("����Ա")) {
			System.out.println("����Ա��¼");
			AdminDao adminDao = new AdminDao();
			String adminName = adminDao.checkLogin(email, userpwd);
			String usercheckcode = request.getParameter("checkcode");
			System.out.println("usercheckcode="+usercheckcode);
			HttpSession session = request.getSession();
			String servercheckcode = (String) session.getAttribute("checkCode");
			if (!servercheckcode.equalsIgnoreCase(usercheckcode)) {
				info = "��֤�벻��ȷ������������";
				request.setAttribute("info", info);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else if (adminName!=null) {
				HttpSession session1 = request.getSession();
				session1.setAttribute("url", "index.jsp");
				session1.setAttribute("loginname", adminName);
				session1.setAttribute("adminname", adminName);
				request.getRequestDispatcher("adminhome.jsp").forward(request, response);
			} else {
				info = "�û��������벻��ȷ";
				request.setAttribute("info", info);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}else {
			info = "��ѡ����������!";
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