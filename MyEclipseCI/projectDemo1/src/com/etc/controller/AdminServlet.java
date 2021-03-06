package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.etc.dao.AdminDao;

public class AdminServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public AdminServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String adminName = request.getParameter("username");
		String adminPwd = request.getParameter("password");
		AdminDao adminDao = new AdminDao();
		if (adminPwd.length()<6||adminPwd.length()>12) {
			JOptionPane.showMessageDialog(null, "密码长度不合格！");
		}else if (adminDao.addAccount(adminName, adminPwd)) {
			System.out.println("添加管理员成功");
			JOptionPane.showMessageDialog(null, "添加管理员成功");
		}
		HttpSession session = request.getSession();
		session.setAttribute("url", "addAdmin.jsp");
		request.getRequestDispatcher("adminhome.jsp").forward(request, response);
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
