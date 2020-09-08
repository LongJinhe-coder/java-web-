package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.UserDao;
import com.etc.entity.User;
import com.etc.entity.PageData;

public class UserServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public UserServlet() {
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
		//ͼ��Ĺ�����ѯ
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//���ñ�ǣ�����������ʲô����
		String option = null;
		//http://localhost:9090/BookDemo7.15/BookServlet1?option=query
		//��ȡǰ̨��������ݵ�optionֵ
		option = request.getParameter("option");
		System.out.println("Ҫ���Ĳ��� "+option);
		
		if (option.equals("queryAllUser")) {
			UserDao userDao = new UserDao();
			
			PageData pageData = userDao.queryAllBook();
			//��pageData������request������
			request.setAttribute("pagedata", pageData);
			//ҳ����ת
			request.getRequestDispatcher("user.jsp").forward(request, response);
		}else if (option.equals("queryByPage")) {
			UserDao userDao = new UserDao();
			//����Ĭ����ʾ��һҳ
			int pageNo = 1;
			int pageSize = 3;
//			PageData pageData = bookDao.queryBooksByPage(pageNo, pageSize);
//			//��ȡ��ǰ��ҳ��
//			int totalPage = pageData.getTotalPage();
//			System.out.println("totalPage:"+totalPage);
			//��ȡ��������ݵ�pageNo��pageSize
//			pageNo = Integer.parseInt(request.getParameter("pageNo"));
//			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			if (request.getParameter("pageNo")!=null) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));
				if (pageNo<=0) {
					pageNo = 1;
				}
				if (request.getParameter("pageSize")!=null) {
					pageSize = Integer.parseInt(request.getParameter("pageSize"));
					if (pageSize<=0) {
						pageSize = 1;
					}
				}
				
			}
			
			PageData pageData = userDao.queryBooksByPage(pageNo, pageSize);
			
			request.setAttribute("pagedata", pageData);
			//ҳ����ת
			request.getRequestDispatcher("user.jsp").forward(request, response);
			
		}
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
