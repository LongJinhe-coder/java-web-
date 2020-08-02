package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.MessageDao;
import com.etc.dao.ResumeDao;
import com.etc.entity.Message;

public class MessageServlet extends HttpServlet {
	public MessageServlet() {
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

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		MessageDao messageDao = new MessageDao();
		String option = null;
		option = (String)request.getParameter("option");
		System.out.println("将要进行的操作是"+option);
		if (option.equals("deleteMessage")) {
			System.out.println("deleting");
			int recruitmentID=Integer.parseInt(request.getParameter("recruitmentID"));
			System.out.println("recruitmentID="+recruitmentID);
			if (messageDao.deleteMessage(recruitmentID)) {
				System.out.println("删除消息成功");
				
			}
			request.getRequestDispatcher("personalCenter.jsp").forward(request, response);
		}
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
