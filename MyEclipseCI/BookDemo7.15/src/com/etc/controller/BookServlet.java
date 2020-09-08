package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.BookDao;
import com.etc.entity.Book;

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
		
		String bookid = request.getParameter("bookid");
		
		//ʵ����һ��bookdao
		BookDao bookDao = new BookDao();
		//����bookdao����ɾ��ͼ��
		bookDao.deleteBook(bookid);
		
		//����bookdao������ѯͼ��
		List<Book> list = bookDao.queryAllBookAndType();
		//��list������request�У����ظ������
		request.setAttribute("booklist", list);
		request.getRequestDispatcher("book.jsp").forward(request, response);
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
