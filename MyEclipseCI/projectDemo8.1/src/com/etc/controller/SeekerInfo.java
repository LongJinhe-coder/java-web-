package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.dao.RecruitDao;
import com.etc.dao.ResumeDao;
import com.etc.entity.PageData;
import com.etc.entity.RecruitmentInformation;
import com.etc.entity.Resume;

public class SeekerInfo extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public SeekerInfo() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void getUrl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = request.getParameter("url");
		System.out.println("url ="+url);
		HttpSession session = request.getSession();
		session.setAttribute("url", url);
	}
	
	//public void querySeekInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	RecruitDao rdao = new RecruitDao();
	//	List<RecruitmentInformation> list = rdao.queryAllRecruitmentAndPositionName();
	//	request.setAttribute("RecruitmentInfoList", list);
	//	getUrl(request, response);
	//	request.getRequestDispatcher("firmhome.jsp").forward(request, response);
	//}
	
	public void queryByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecruitDao rdao = new RecruitDao();
	
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
		PageData pageData = rdao.queryByPage2(pageNo, pageSize);
		request.setAttribute("pagedata", pageData);
		getUrl(request, response);
		request.getRequestDispatcher("firmhome.jsp").forward(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
				
		RecruitDao rdao = new RecruitDao();
		ResumeDao  rdao2= new ResumeDao();
		String option = null;
		option = (String)request.getParameter("option");
		System.out.println("将要进行的操作是"+option);
		
		
		if (option.equals("queryByPage")) {
			 queryByPage(request, response);
			
			}else if (option.equals("deleteInfo")) {
				System.out.println("000");
			int userInfoID = Integer.parseInt(request.getParameter("userInfoID"));
			System.out.println("userInfoID="+userInfoID);
			
			if( rdao.deleteResumeInfo(userInfoID)) {
		       System.out.println("应聘信息删除成功");
			}
			queryByPage(request, response);
		}
		
		else if (option.equals("queryLikeID")) {
			//获取浏览器传递的用户名称
			int userInfoID = Integer.parseInt(request.getParameter("userInfoID"));
			System.out.println("userInfoID------------------->"+userInfoID);
			PageData pageData = rdao.queryLikeID(userInfoID);
			request.setAttribute("pagedata", pageData);
			getUrl(request, response);
			request.getRequestDispatcher("firmhome.jsp").forward(request, response);
		}else if(option.equals("lookInfo")) {
			//int recruitmentID = Integer.parseInt(request.getParameter("recruitmentID"));
			//System.out.println("recruitmentID------------------>"+recruitmentID);
			int userInfoID = Integer.parseInt(request.getParameter("userInfoID"));
			System.out.println("userInfoID------------------->"+userInfoID);
			Resume resume=rdao2.queryResumesById(userInfoID);
			System.out.println("userinfoID----------------->"+resume.getUserInfoID());
		    request.setAttribute("Resume", resume);
		    getUrl(request,response);
		    request.getRequestDispatcher("firmhome.jsp").forward(request, response);
		}else if(option.equals("accept")) {
			int userInfoID = Integer.parseInt(request.getParameter("userInfoID"));
			System.out.println("userInfoID="+userInfoID);
			if (rdao.accept(userInfoID)) {
				System.out.println("应聘成功");
			}
			queryByPage(request, response);
		}else if(option.equals("reject")) {
			int userInfoID = Integer.parseInt(request.getParameter("userInfoID"));
			System.out.println("userInfoID="+userInfoID);
			if (rdao.reject(userInfoID)) {
				System.out.println("拒绝成功");
			}
			queryByPage(request, response);
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
