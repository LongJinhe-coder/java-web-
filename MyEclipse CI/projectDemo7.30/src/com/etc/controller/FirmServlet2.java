package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.RecruitDao;
import com.etc.entity.Administrator;
import com.etc.entity.Firm;
import com.etc.entity.Position;
import com.etc.entity.RecruitmentInformation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
public class FirmServlet2 extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public FirmServlet2() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               doPost(request,response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("firmservlet");
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String recruitmentID=request.getParameter("recruitmentID");
		String firmID=request.getParameter("firmID");
		String position=request.getParameter("position");
		String positionID=request.getParameter("positionID");
		String adminID=request.getParameter("adminID");
		String positionDescribe=request.getParameter("positionDescribe");
		String dueDate=request.getParameter("dueDate");
		String salary=request.getParameter("salary");
		int count=Integer.parseInt(request.getParameter("count"));
		String age=request.getParameter("age");
		
	     RecruitDao rd=new RecruitDao();
	     RecruitmentInformation ri=new RecruitmentInformation();
	     ri.setRecruitmentID(Integer.parseInt(recruitmentID));
	     
	     Firm f=new Firm();
	     f.setFirmID(Integer.parseInt(firmID));
	     ri.setFirmID(f);
	     
	     Position pos=new Position();
	     pos.setPositionName(position);
	     pos.setPositionID(Integer.parseInt(positionID));
	     ri.setPositionID(pos);
	     
	     Administrator as=new Administrator();
	     as.setAdminID(Integer.parseInt(adminID));
	     ri.setAdminID(as);
	     
	     ri.setPositionDescribe(positionDescribe);
	     
	     SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	     try {
			Date duedate=format.parse(dueDate);
			
			 ri.setDueDate(duedate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	     
	     String status="Œ¥…Û∫À";
	     ri.setCheckStatus(status);
	     ri.setSalary(salary);
	     ri.setCount(count);
	     ri.setAge(age);
	     
	     rd.addRecruit(ri);
	     System.out.println("ÃÌº”≥…π¶£ªrid="+ri.toString());
	     request.getRequestDispatcher("sendRecruitment.jsp").forward(request, response);
	     
	
	
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
