package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * ˢ����֤���Servlet---changecheckcode
 */
public class ChangeCheckCode extends HttpServlet {

	public ChangeCheckCode() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		String email = request.getParameter("email");
		String userpwd = request.getParameter("password");
		request.setAttribute("type", type);
		request.setAttribute("email", email);
		request.setAttribute("userpwd", userpwd);
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
