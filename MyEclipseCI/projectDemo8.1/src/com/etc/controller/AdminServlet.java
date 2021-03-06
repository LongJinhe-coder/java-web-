package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.etc.dao.AdminDao;
import com.etc.dao.FirmDao;
import com.etc.entity.PageData;

public class AdminServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public AdminServlet() {
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
	
	//得到url的方法
		public void getUrl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String url = request.getParameter("url");
			System.out.println("url ="+url);
			HttpSession session = request.getSession();
			session.setAttribute("url", url);
		}
		
		public void queryByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			AdminDao adminDao = new AdminDao();
			//设置默认显示第一页
			int pageNo = 1;
			int pageSize = 8;
			//获取浏览器传递的pageNo与pageSize
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
			PageData pageData = adminDao.queryByPage(pageNo, pageSize);
			request.setAttribute("pagedata", pageData);
			getUrl(request, response);
			request.getRequestDispatcher("adminhome.jsp").forward(request, response);
		}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String option = request.getParameter("option");
		System.out.println("你选择的操作是"+option);
		AdminDao adminDao = new AdminDao();
		if (option.equals("addAdmin")) {
			String adminName = request.getParameter("username");
			String adminPwd = request.getParameter("password");
			if (adminPwd.length()<6||adminPwd.length()>12) {
				JOptionPane.showMessageDialog(null, "密码长度不合格！");
			}else if (adminDao.queryName(adminName)) {
				JOptionPane.showMessageDialog(null, "管理员名字已存在，请更换名字！");
			}else if (adminDao.addAccount(adminName, adminPwd)) {
				System.out.println("添加管理员成功");
				JOptionPane.showMessageDialog(null, "添加管理员成功");
			}
			getUrl(request, response);
			request.getRequestDispatcher("adminhome.jsp").forward(request, response);
		}else if (option.equals("queryByPage")) {
			queryByPage(request, response);
		}else if (option.equals("deleteAdmin")) {
			String adminID = request.getParameter("adminID");
			System.out.println("删除的adminID="+adminID);
			if (adminDao.deleteAccount(Integer.parseInt(adminID))) {
				System.out.println("删除成功");
			}
			getUrl(request, response);
			request.getRequestDispatcher("adminhome.jsp").forward(request, response);
		}else if (option.equals("queryLikeName")) {
			String adminName = request.getParameter("adminName");
			PageData pageData = adminDao.queryLikeName(adminName);
			request.setAttribute("pagedata", pageData);
			getUrl(request, response);
			request.getRequestDispatcher("adminhome.jsp").forward(request, response);
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
