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
		//图书的关联查询
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//设置标记，表明具体做什么操作
		String option = null;
		//http://localhost:9090/BookDemo7.15/BookServlet1?option=query
		//获取前台浏览器传递的option值
		option = request.getParameter("option");
		System.out.println("要做的操作 "+option);
		
		if (option.equals("queryAllBook")) {
			BookDao bookDao = new BookDao();
			
			PageData pageData = bookDao.queryAllBook();
			//将pageData保存在request属性中
			request.setAttribute("pagedata", pageData);
			//页面跳转
			request.getRequestDispatcher("book.jsp").forward(request, response);
		}else if (option.equals("queryByPage")) {
			BookDao bookDao = new BookDao();
			//设置默认显示第一页
			int pageNo = 1;
			int pageSize = 3;
//			PageData pageData = bookDao.queryBooksByPage(pageNo, pageSize);
//			//获取当前总页数
//			int totalPage = pageData.getTotalPage();
//			System.out.println("totalPage:"+totalPage);
			//获取浏览器传递的pageNo与pageSize
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
			//取出图书列表
			//List<Book1> list = pageData.getData();
			
			//将list保存在request属性中
//			request.setAttribute("booklist", list);
			request.setAttribute("pagedata", pageData);
			//页面跳转
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
