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
import com.etc.dao.UserDao;
import com.etc.entity.Firm;
import com.etc.entity.PageData;
import com.etc.entity.RecruitmentInformation;
import com.etc.entity.User;

public class RecruitmentInfo extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public RecruitmentInfo() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	
	//�õ�url�ķ���
	public void getUrl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = request.getParameter("url");
		System.out.println("url ="+url);
		HttpSession session = request.getSession();
		session.setAttribute("url", url);
	}
	
	public void queryAllAndPositionName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecruitDao rdao = new RecruitDao();
		List<RecruitmentInformation> list = rdao.queryAllRecruitmentAndPositionName();
		request.setAttribute("RecruitmentInfoList", list);
		getUrl(request, response);
		request.getRequestDispatcher("firmhome.jsp").forward(request, response);
	}
	
	public void queryByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecruitDao rdao = new RecruitDao();
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
		PageData pageData = rdao.queryByPage(pageNo, pageSize);
		request.setAttribute("pagedata", pageData);
		getUrl(request, response);
		request.getRequestDispatcher("firmhome.jsp").forward(request, response);
	}

	public void queryByPageAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecruitDao rdao = new RecruitDao();
		//����Ĭ����ʾ��һҳ
		int pageNo = 1;
		int pageSize = 8;
		String checkStatus = request.getParameter("checkStatus");
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
		PageData pageData = rdao.queryByPageAdmin(pageNo, pageSize, checkStatus);
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
		 
		RecruitDao rdao = new RecruitDao();
		String option = null;
		option = (String)request.getParameter("option");
		System.out.println("��Ҫ���еĲ�����"+option);
		
		
		if (option.equals("queryByPage")) {
			queryByPage(request, response);
			
			}else if (option.equals("deleteInfo")) {
			int recruitmentID = Integer.parseInt(request.getParameter("recruitmentID"));
			System.out.println("recruitmentID="+recruitmentID);
			
			if( rdao.deleteRecruitmentInfo(recruitmentID)) {
		       System.out.println("��Ƹ��Ϣɾ���ɹ�");
			}
			queryByPage(request, response);
		}
		else if (option.equals("queryLikeName")) {
			//��ȡ��������ݵ��û�����
			String positionName = request.getParameter("positionName");
			PageData pageData = rdao.queryLikeName(positionName);
			request.setAttribute("pagedata", pageData);
			getUrl(request, response);
			request.getRequestDispatcher("firmhome.jsp").forward(request, response);
		}else if(option.equals("lookInfo")) {
			int recruitmentID = Integer.parseInt(request.getParameter("recruitmentID"));
			//System.out.println("recruitmentID------------------>"+recruitmentID);
			
			RecruitmentInformation ri=rdao.queryRecruitmentInfoById(recruitmentID);
			//System.out.println("recruitmentID----------------->"+ri.getRecruitmentID());
		    request.setAttribute("recuritmentInfo", ri);
		    request.getRequestDispatcher("displayRecruitmentInfo.jsp").forward(request, response);
		}else if (option.equals("queryByPageAdmin")) {
			queryByPageAdmin(request, response);
		}else if (option.equals("queryLikeNameAdmin")) {
			//��ȡ��������ݵ��û�����
			String positionName = request.getParameter("positionName");
			String checkStatus = request.getParameter("checkStatus");
			System.out.println("checkStatus->"+checkStatus);
			PageData pageData = rdao.queryLikeNameAdmin(positionName,checkStatus);
			request.setAttribute("pagedata", pageData);
			getUrl(request, response);
			request.getRequestDispatcher("adminhome.jsp").forward(request, response);
		}else if (option.equals("queryByID")) {
			//��ȡ��������ݵ��û�����
			String recruitmentID = request.getParameter("recruitmentID");
			System.out.println("recruitmentID->"+recruitmentID);
			RecruitmentInformation recruitmentInformation = rdao.queryByID(Integer.parseInt(recruitmentID));
			request.setAttribute("recruitmentInformation", recruitmentInformation);
			getUrl(request, response);
			request.getRequestDispatcher("adminhome.jsp").forward(request, response);
		}else if (option.equals("boolPassCheck")) {
			String recruitmentID = request.getParameter("recruitmentID");
			String checkStatus = request.getParameter("checkstatus");
			if (rdao.changeCheckStatus(Integer.parseInt(recruitmentID), checkStatus)) {
				System.out.println("checkStatus�ı�ɹ���");
			}
			queryByPageAdmin(request, response);
		}else if (option.equals("deleteInfoAdmin")) {
			int recruitmentID = Integer.parseInt(request.getParameter("recruitmentID"));
			System.out.println("recruitmentID="+recruitmentID);
			
			if( rdao.deleteRecruitmentInfo(recruitmentID)) {
		       System.out.println("��Ϣɾ���ɹ�");
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