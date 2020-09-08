package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.dao.UserDao;
import com.etc.entity.User;

public class loginCheckServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public loginCheckServlet() {
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
//		PrintWriter out = response.getWriter();
//		out.flush();
//		out.close();
		//���ñ����ʽ
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				
				String name = request.getParameter("username");
			  	String password = request.getParameter("password");
			  	
			  	UserDao userDao = new UserDao();
			  	boolean flag = userDao.userQuery(name, password);
			  	
			  	//����һ����¼��Ϣ
			  	String info="";
			  	if (flag) {
					info= "��ӭ��"+name;
				}else {
					info = "�û������������";
				}
			  	
			  //��info������request������
			  	request.setAttribute("info", info);
			  //���û���������session��
			  	//����session����
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
