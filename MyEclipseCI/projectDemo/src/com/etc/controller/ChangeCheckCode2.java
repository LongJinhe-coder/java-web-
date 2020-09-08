package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeCheckCode2 extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public ChangeCheckCode2() {
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
		String title = request.getParameter("title");
		String email = request.getParameter("email");
		String userpwd = request.getParameter("password");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		request.setAttribute("password", password);
		request.setAttribute("title", title);
		request.setAttribute("email", email);
		request.setAttribute("userpwd", userpwd);
		request.setAttribute("phone", phone);
		request.getRequestDispatcher("/personalregister.jsp").forward(request, response);
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
