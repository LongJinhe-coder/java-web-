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
		//图书的关联查询
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//实例化一个bookdao
				BookDao bookDao = new BookDao();
		//调用bookdao方法查询图书
		List<Book> list = bookDao.queryAllBookAndType();
				//将list保存在request中，返回给浏览器
		request.setAttribute("booklist", list);
		request.getRequestDispatcher("book.jsp").forward(request, response);
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		//图书的关联查询
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//设置标记，表明具体做什么操作
		String option = null;
		//http://localhost:9090/BookDemo7.15/BookServlet1?option=query
		//获取前台浏览器传递的option值
		option = request.getParameter("option");
		System.out.println("要做的操作 "+option);
		if (option.equals("query")) {//查询图书
			doQueryAllBookAndType(request, response);
		}else if (option.equals("delete")) {//删除图书
			//获取bookid
			String bookid = request.getParameter("bookid");
			//实例化一个bookdao
			BookDao bookDao = new BookDao();
			//调用bookdao方法删除图书
			bookDao.deleteBook(bookid);
			
			//调用doQueryAllBookAndType方法
			doQueryAllBookAndType(request, response);
			
		}else if (option.equals("add")) {//添加图书
			//添加图书操作
			//获取图书名称与类型
			String bookname = request.getParameter("bookname");
			String booktypename = request.getParameter("bookTypeName");//传的是id1,2,3,4
			BookDao bookDao = new BookDao();
			//创建图书对象
			Book book = new Book();
			book.setBookname(bookname);
			//创建booktype对象
			BookType bookType = new BookType();
			bookType.setTypename(booktypename);
			book.setBt(bookType);
			//调用bookdao中添加图书的方法
			bookDao.addBook(book);
			//调用doQueryAllBookAndType方法
			doQueryAllBookAndType(request, response);
		}else if (option.equals("queryById")) {
			//获取图书编号
			int bookid = Integer.parseInt(request.getParameter("bookid"));
			String bookname = request.getParameter("bookname");
			int typeid = Integer.parseInt(request.getParameter("typeid"));
			Book book = new Book(bookid,bookname);
			BookType bt = new BookType();
			bt.setTypeid(typeid);
			book.setBt(bt);
//			BookDao bookDao = new BookDao();
//			//调用queryById
//			Book book = bookDao.queryById(Integer.parseInt(bookid));
			//将图书信息保存至request，返回给浏览器
			request.setAttribute("book", book);
			
			request.getRequestDispatcher("updateBook.jsp").forward(request, response);
		}else if (option.equals("update")) {
			//获取浏览器传递的图书信息
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
				System.out.println("更新成功");
			}
			//调用doQueryAllBookAndType方法
			doQueryAllBookAndType(request, response);
		}else if (option.equals("queryLikeName")) {
			//获取浏览器传递的图书名称
			String bookname = request.getParameter("bookname");
			BookDao bookDao = new BookDao();
			
			List<Book> booklist = bookDao.queryBookLikeName(bookname);
			
			//将图书信息保存至request，返回给浏览器
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
