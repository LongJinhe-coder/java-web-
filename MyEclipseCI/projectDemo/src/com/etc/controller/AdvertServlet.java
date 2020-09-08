package com.etc.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.dao.AdminDao;
import com.etc.dao.AdvertDao;
import com.etc.dao.RecruitDao;
import com.etc.dao.ResumeDao;
import com.etc.entity.PageData;
import com.etc.entity.Resume;

public class AdvertServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public AdvertServlet() {
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
		AdvertDao adao=new AdvertDao();
		
	//获取当前登录的企业编号
				HttpSession session = request.getSession();
				
			    int firmID=Integer.parseInt(session.getAttribute("firmID").toString());
		
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
		PageData pageData = adao.queryByPage(pageNo, pageSize,firmID);
		request.setAttribute("pagedata", pageData);
		getUrl(request, response);
		request.getRequestDispatcher("firmhome.jsp").forward(request, response);
	}
	
	//管理员获取全部广告（根据审核状态）
	public void queryByPageAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdvertDao adao=new AdvertDao();

		//设置默认显示第一页
		int pageNo = 1;
		int pageSize = 8;
		String checkStatus = (String)request.getParameter("checkStatus");
		System.out.println("checkStatus->"+checkStatus);
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
		PageData pageData = adao.queryAllByPage(pageNo, pageSize,checkStatus);
		request.setAttribute("pagedata", pageData);
		getUrl(request, response);
		request.getRequestDispatcher("adminhome.jsp").forward(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	
		//得到firmID
//		HttpSession session = request.getSession();
//	    int firmID=Integer.parseInt(session.getAttribute("firmID").toString());
		//System.out.println("123456---------------------->firmID"+firmID);
		

		String option = null;
		option = (String)request.getParameter("option");
		System.out.println("将要进行的操作是"+option);
		
		
		if (option.equals("queryByPage")) {
			 queryByPage(request, response);
			
			}else if (option.equals("deleteInfo")) {
			
				//得到广告编号
			int advertID = Integer.parseInt(request.getParameter("advertID"));
			System.out.println("advertID="+advertID);
			//得到广告名称（文件名称）
			AdvertDao adao=new AdvertDao();
			String advertName=adao.getAdvertName(advertID);
			
			//得到firmID
			HttpSession session = request.getSession();
		    int firmID=Integer.parseInt(session.getAttribute("firmID").toString());

			
			if( adao.deleteAdvert(firmID,advertID)) {
				String path="F:\\web软件\\projectDemo\\projectDemo"+"\\WebRoot\\image\\ad";
				File folder = new File(path);
				File[] files = folder.listFiles();
				for(File file:files){
				if(file.getName().equals(advertName)){
				file.delete();
				System.out.println("广告信息删除成功");
				  }
				}
			}
			queryByPage(request, response);
		}else if (option.equals("queryLikeName")) {
			//得到firmID
			HttpSession session = request.getSession();
		    int firmID=Integer.parseInt(session.getAttribute("firmID").toString());
			//System.out.println("123456---------------------->firmID"+firmID);
		    
		    //得到广告编号
		    int advertID=Integer.parseInt(request.getParameter("advertID"));
			AdvertDao adao=new AdvertDao();
			PageData pageData = adao.queryLikeName(firmID,advertID);
			request.setAttribute("pagedata", pageData);
			getUrl(request, response);
			request.getRequestDispatcher("firmhome.jsp").forward(request, response);
		}else if(option.equals("postAdvert")) {
			
			getUrl(request,response);
			request.getRequestDispatcher("firmhome.jsp").forward(request, response);
		}else if (option.equals("queryByPageAdmin")) {
			queryByPageAdmin(request, response);
		}else if (option.equals("queryLikeNameAdmin")) {
			
		    //得到广告编号
		    int advertID=Integer.parseInt(request.getParameter("advertID"));
		    String checkStatus = (String)request.getParameter("checkStatus");
			AdvertDao adao=new AdvertDao();
			PageData pageData = adao.queryLikeNameAdmin(advertID,checkStatus);
			request.setAttribute("pagedata", pageData);
			getUrl(request, response);
			request.getRequestDispatcher("adminhome.jsp").forward(request, response);
		}else if (option.equals("changeCheckStatus")) {
			int advertID=Integer.parseInt(request.getParameter("advertID"));
		    String changedStatus = (String)request.getParameter("changedStatus");
		    AdvertDao adao=new AdvertDao();
		    if (adao.changeCheckStatus(advertID, changedStatus)) {
				System.out.println("广告审核状态改变成功！");
			}
		    HttpSession session = request.getSession();
		    String adminName = (String)session.getAttribute("adminname");
		    System.out.println("adminname="+adminName);
		    AdminDao adminDao = new AdminDao();
		    //得到审核人的id
		    int adminID = adminDao.getAdminID(adminName);
		    if (adao.setAdminID(advertID, adminID)) {
				System.out.println("记录审核人成功！");
			}
		    queryByPageAdmin(request, response);
		}else if (option.equals("deleteAdvertAdmin")) {
			int advertID=Integer.parseInt(request.getParameter("advertID"));
			
			//得到广告名称（文件名称）
			AdvertDao adao=new AdvertDao();
			String advertName=adao.getAdvertName(advertID);
			if (adao.deleteAdvertAdmin(advertID)) {
//				String path="E:\\JavaWeb实训\\MyEclipseCI\\projectDemo\\WebRoot\\image\\ad";
//				File folder = new File(path);
//				File[] files = folder.listFiles();
//				for(File file:files){
//				if(file.getName().equals(advertName)){
//				file.delete();
//				System.out.println("广告信息删除成功");
//				  }
//				}
			}
			queryByPageAdmin(request, response);
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
