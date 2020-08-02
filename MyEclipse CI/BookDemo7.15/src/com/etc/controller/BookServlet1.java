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
import com.etc.entity.BookType;

public class BookServlet1 extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public BookServlet1() {
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
	
	public void doQueryAllBookAndType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		//ͼ��Ĺ�����ѯ
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//ʵ����һ��bookdao
				BookDao bookDao = new BookDao();
		//����bookdao������ѯͼ��
		List<Book> list = bookDao.queryAllBookAndType();
				//��list������request�У����ظ������
		request.setAttribute("booklist", list);
		request.getRequestDispatcher("book.jsp").forward(request, response);
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
		if (option.equals("query")) {//��ѯͼ��
			doQueryAllBookAndType(request, response);
		}else if (option.equals("delete")) {//ɾ��ͼ��
			//��ȡbookid
			String bookid = request.getParameter("bookid");
			//ʵ����һ��bookdao
			BookDao bookDao = new BookDao();
			//����bookdao����ɾ��ͼ��
			bookDao.deleteBook(bookid);
			
			//����doQueryAllBookAndType����
			doQueryAllBookAndType(request, response);
			
		}else if (option.equals("add")) {//���ͼ��
			//���ͼ�����
			//��ȡͼ������������
			String bookname = request.getParameter("bookname");
			String booktypename = request.getParameter("bookTypeName");//������id1,2,3,4
			BookDao bookDao = new BookDao();
			//����ͼ�����
			Book book = new Book();
			book.setBookname(bookname);
			//����booktype����
			BookType bookType = new BookType();
			bookType.setTypename(booktypename);
			book.setBt(bookType);
			//����bookdao�����ͼ��ķ���
			bookDao.addBook(book);
			//����doQueryAllBookAndType����
			doQueryAllBookAndType(request, response);
		}else if (option.equals("queryById")) {
			//��ȡͼ����
			int bookid = Integer.parseInt(request.getParameter("bookid"));
			String bookname = request.getParameter("bookname");
			int typeid = Integer.parseInt(request.getParameter("typeid"));
			Book book = new Book(bookid,bookname);
			BookType bt = new BookType();
			bt.setTypeid(typeid);
			book.setBt(bt);
//			BookDao bookDao = new BookDao();
//			//����queryById
//			Book book = bookDao.queryById(Integer.parseInt(bookid));
			//��ͼ����Ϣ������request�����ظ������
			request.setAttribute("book", book);
			
			request.getRequestDispatcher("updateBook.jsp").forward(request, response);
		}else if (option.equals("update")) {
			//��ȡ��������ݵ�ͼ����Ϣ
			String bookid = request.getParameter("bookid");
			String bookname = request.getParameter("bookname");
			String typeid = request.getParameter("bookTypeName");
			BookType bt = new BookType();
			bt.setTypeid(Integer.parseInt(typeid));
			Book book = new Book();
			book.setBid(Integer.parseInt(bookid));
			book.setBookname(bookname);
			book.setBt(bt);
			
			BookDao bookDao = new BookDao();
			boolean flag = bookDao.updateInfo(book);
			if (flag) {
				System.out.println("���³ɹ�");
			}
			//����doQueryAllBookAndType����
			doQueryAllBookAndType(request, response);
		}else if (option.equals("queryLikeName")) {
			//��ȡ��������ݵ�ͼ������
			String bookname = request.getParameter("bookname");
			BookDao bookDao = new BookDao();
			
			List<Book> booklist = bookDao.queryBookLikeName(bookname);
			
			//��ͼ����Ϣ������request�����ظ������
			request.setAttribute("booklist", booklist);
			
			request.getRequestDispatcher("book.jsp").forward(request, response);
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
