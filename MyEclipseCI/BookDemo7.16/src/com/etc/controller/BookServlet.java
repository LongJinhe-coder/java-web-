package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.BookDao;
import com.etc.entity.Book1;
import com.etc.entity.PageData;

public class BookServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public BookServlet() {
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
		
		if (option.equals("queryAllBook")) {
			BookDao bookDao = new BookDao();
			
			PageData pageData = bookDao.queryAllBook();
			//��pageData������request������
			request.setAttribute("pagedata", pageData);
			//ҳ����ת
			request.getRequestDispatcher("book.jsp").forward(request, response);
		}else if (option.equals("queryByPage")) {
			BookDao bookDao = new BookDao();
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
			
			PageData pageData = bookDao.queryBooksByPage(pageNo, pageSize);
			//ȡ��ͼ���б�
			//List<Book1> list = pageData.getData();
			
			//��list������request������
//			request.setAttribute("booklist", list);
			request.setAttribute("pagedata", pageData);
			//ҳ����ת
			request.getRequestDispatcher("book2.jsp").forward(request, response);
			
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
