package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeCheckCode3 extends HttpServlet {

	public ChangeCheckCode3() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firmname = request.getParameter("firmname");
		String firmid = request.getParameter("firmid");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String money = request.getParameter("money");
		String password = request.getParameter("password");
		String registerplace = request.getParameter("registerplace");
		String date = request.getParameter("date");
		String firmnature = request.getParameter("firmnature");
		String linkmanname = request.getParameter("linkmanname");
		String linkmanphone = request.getParameter("linkmanphone");
		String place = request.getParameter("place");
		String intro = request.getParameter("intro");
		
		request.setAttribute("intro", intro);
		request.setAttribute("place", place);
		request.setAttribute("linkmanphone", linkmanphone);
		request.setAttribute("linkmanname", linkmanname);
		request.setAttribute("firmnature", firmnature);
		request.setAttribute("money", money);
		request.setAttribute("date", date);
		request.setAttribute("registerplace", registerplace);
		request.setAttribute("password", password);
		request.setAttribute("firmname", firmname);
		request.setAttribute("firmid", firmid);
		request.setAttribute("email", email);
		request.setAttribute("phone", phone);
		request.getRequestDispatcher("/firmregister.jsp").forward(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
