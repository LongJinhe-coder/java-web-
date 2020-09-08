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
		
	//��ȡ��ǰ��¼����ҵ���
				HttpSession session = request.getSession();
				
			    int firmID=Integer.parseInt(session.getAttribute("firmID").toString());
		
		//����Ĭ����ʾ��һҳ
		int pageNo = 1;
		int pageSize = 8;
		//��ȡ��������ݵ�pageNo��pageSize
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
	
	//����Ա��ȡȫ����棨�������״̬��
	public void queryByPageAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdvertDao adao=new AdvertDao();

		//����Ĭ����ʾ��һҳ
		int pageNo = 1;
		int pageSize = 8;
		String checkStatus = (String)request.getParameter("checkStatus");
		System.out.println("checkStatus->"+checkStatus);
		//��ȡ��������ݵ�pageNo��pageSize
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
	
		//�õ�firmID
//		HttpSession session = request.getSession();
//	    int firmID=Integer.parseInt(session.getAttribute("firmID").toString());
		//System.out.println("123456---------------------->firmID"+firmID);
		

		String option = null;
		option = (String)request.getParameter("option");
		System.out.println("��Ҫ���еĲ�����"+option);
		
		
		if (option.equals("queryByPage")) {
			 queryByPage(request, response);
			
			}else if (option.equals("deleteInfo")) {
			
				//�õ������
			int advertID = Integer.parseInt(request.getParameter("advertID"));
			System.out.println("advertID="+advertID);
			//�õ�������ƣ��ļ����ƣ�
			AdvertDao adao=new AdvertDao();
			String advertName=adao.getAdvertName(advertID);
			
			//�õ�firmID
			HttpSession session = request.getSession();
		    int firmID=Integer.parseInt(session.getAttribute("firmID").toString());

			
			if( adao.deleteAdvert(firmID,advertID)) {
				String path="F:\\web���\\projectDemo\\projectDemo"+"\\WebRoot\\image\\ad";
				File folder = new File(path);
				File[] files = folder.listFiles();
				for(File file:files){
				if(file.getName().equals(advertName)){
				file.delete();
				System.out.println("�����Ϣɾ���ɹ�");
				  }
				}
			}
			queryByPage(request, response);
		}else if (option.equals("queryLikeName")) {
			//�õ�firmID
			HttpSession session = request.getSession();
		    int firmID=Integer.parseInt(session.getAttribute("firmID").toString());
			//System.out.println("123456---------------------->firmID"+firmID);
		    
		    //�õ������
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
			
		    //�õ������
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
				System.out.println("������״̬�ı�ɹ���");
			}
		    HttpSession session = request.getSession();
		    String adminName = (String)session.getAttribute("adminname");
		    System.out.println("adminname="+adminName);
		    AdminDao adminDao = new AdminDao();
		    //�õ�����˵�id
		    int adminID = adminDao.getAdminID(adminName);
		    if (adao.setAdminID(advertID, adminID)) {
				System.out.println("��¼����˳ɹ���");
			}
		    queryByPageAdmin(request, response);
		}else if (option.equals("deleteAdvertAdmin")) {
			int advertID=Integer.parseInt(request.getParameter("advertID"));
			
			//�õ�������ƣ��ļ����ƣ�
			AdvertDao adao=new AdvertDao();
			String advertName=adao.getAdvertName(advertID);
			if (adao.deleteAdvertAdmin(advertID)) {
//				String path="E:\\JavaWebʵѵ\\MyEclipseCI\\projectDemo\\WebRoot\\image\\ad";
//				File folder = new File(path);
//				File[] files = folder.listFiles();
//				for(File file:files){
//				if(file.getName().equals(advertName)){
//				file.delete();
//				System.out.println("�����Ϣɾ���ɹ�");
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
