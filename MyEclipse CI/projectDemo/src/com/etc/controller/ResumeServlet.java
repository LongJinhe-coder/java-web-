package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;


import com.etc.dao.ResumeDao;
import com.etc.entity.Administrator;

import com.etc.entity.Resume;
import com.etc.entity.User;


public class ResumeServlet extends HttpServlet {

	public ResumeServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ResumeDao resumeDao = new ResumeDao();
		String option = null;
		option = (String)request.getParameter("option");
		System.out.println("将要进行的操作是"+option);
		if (option.equals("addAccount")) {
			int id=Integer.parseInt(request.getParameter("id"));
			String sex=request.getParameter("sex");
	    	String introduce=request.getParameter("introduce");
	    	String phone=request.getParameter("phone");
	    	String workExper = request.getParameter("workExper");
	    	String skill = request.getParameter("skill");
	    	String workStatus = request.getParameter("workStatus");
	    	String expectSalary = request.getParameter("expectSalary");
	    	String nativePlace = request.getParameter("nativePlace");
	    	String livingPlace = request.getParameter("livingPlace");
	    	String degree = request.getParameter("degree");
	    	String learnMajor = request.getParameter("learnMajor");
	    	String school = request.getParameter("school");
	    	String politicStatus = request.getParameter("politicStatus");
	    	String marriage = request.getParameter("marriage");
	    	String nation = request.getParameter("nation");
	    	String name = request.getParameter("name");
	    	String birthDate = request.getParameter("birthDate");
	    	User user =new User();
	    	user.setUserID(id);
	    	
	    	HttpSession session = request.getSession();
			System.out.println(user.getUserID());
			System.out.println(sex);
			System.out.println(introduce);
			System.out.println(phone);
			System.out.println(workExper);
			System.out.println(skill);
			System.out.println(workStatus);
			System.out.println(expectSalary);
			System.out.println(nativePlace);
			System.out.println(livingPlace);
			System.out.println(degree);
			System.out.println(learnMajor);
			System.out.println(school);
			System.out.println(politicStatus);
			System.out.println(marriage);
			System.out.println(nation);
			System.out.println(name);
			System.out.println(birthDate);

			 String REGEX_EMAIL = "^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|          (?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$";
		    Pattern regex = Pattern.compile(REGEX_EMAIL);  
		     Matcher matcher = regex.matcher(birthDate);  
		     boolean isMatched = matcher.matches(); 
			if(sex==null||sex==""||introduce==null||introduce==""||phone==null||phone==""||workExper==null||workExper==""||skill==null||skill==""||workStatus==null||workStatus==""||expectSalary==null||expectSalary==""||nativePlace==null||nativePlace==""||livingPlace==null||livingPlace==""||degree==null||degree==""||learnMajor==null||learnMajor==""||school==null||school==""||politicStatus==null||politicStatus==""||marriage==null||marriage==""||nation==null||nation==""||name==null||name==""||birthDate==null||birthDate==""){
				JOptionPane.showMessageDialog(null, "必填项不得为空");
				System.out.println("1");
				request.getRequestDispatcher("personalCenter.jsp").forward(request, response);
			}else if(phone.length()!=11){
		    	 JOptionPane.showMessageDialog(null,"手机号格式不正确");
	    		  System.out.println("2");
	    		  request.getRequestDispatcher("personalCenter.jsp").forward(request, response);
			}else if(!isMatched){
		    		  JOptionPane.showMessageDialog(null,"日期格式不正确");
		    		  System.out.println("3");
		    	  request.getRequestDispatcher("personalCenter.jsp").forward(request, response);
			}
            else {
	    	Resume resume =new Resume();
	    	
	    	ResumeDao resumedao=new ResumeDao();
	    	resume.setBirthDate(birthDate);
	    	resume.setDegree(degree);
	    	resume.setExpectSalary(expectSalary);
	    	resume.setIntroduce(introduce);
	    	resume.setLearnMajor(learnMajor);
	    	resume.setLivingPlace(livingPlace);
	    	resume.setMarriage(marriage);
	    	resume.setName(name);
	    	resume.setNation(nation);
	    	resume.setNativePlace(nativePlace);
	    	resume.setPhone(phone);
	    	resume.setPoliticStatus(politicStatus);
	    	resume.setSchool(school);
	    	resume.setSex(sex);
	    	resume.setSkill(skill);
	    	resume.setUser(user);
	    	resume.setWorkExper(workExper);
	    	resume.setWorkStatus(workStatus);
	    	
	    	if(resumedao.addResume(resume)) {
	    		 
			request.getRequestDispatcher("personalCenter.jsp").forward(request, response);
			JOptionPane.showMessageDialog(null,"添加简历成功");
	    	}
           }
		}else if(option.equals("changeAccount")){
			int id=Integer.parseInt(request.getParameter("id"));
			int userInfoID=Integer.parseInt(request.getParameter("userInfoID"));
			String sex=request.getParameter("sex");
	    	String introduce=request.getParameter("introduce");
	    	String phone=request.getParameter("phone");
	    	String workExper = request.getParameter("workExper");
	    	String skill = request.getParameter("skill");
	    	String workStatus = request.getParameter("workStatus");
	    	String expectSalary = request.getParameter("expectSalary");
	    	String nativePlace = request.getParameter("nativePlace");
	    	String livingPlace = request.getParameter("livingPlace");
	    	String degree = request.getParameter("degree");
	    	String learnMajor = request.getParameter("learnMajor");
	    	String school = request.getParameter("school");
	    	String politicStatus = request.getParameter("politicStatus");
	    	String marriage = request.getParameter("marriage");
	    	String nation = request.getParameter("nation");
	    	String name = request.getParameter("name");
	    	String birthDate = request.getParameter("birthDate");
	    	User user =new User();
	    	user.setUserID(id);
	    	
	    	HttpSession session = request.getSession();
			System.out.println(user.getUserID());
			System.out.println(userInfoID);
			System.out.println(sex);
			System.out.println(introduce);
			System.out.println(phone);
			System.out.println(workExper);
			System.out.println(skill);
			System.out.println(workStatus);
			System.out.println(expectSalary);
			System.out.println(nativePlace);
			System.out.println(livingPlace);
			System.out.println(degree);
			System.out.println(learnMajor);
			System.out.println(school);
			System.out.println(politicStatus);
			System.out.println(marriage);
			System.out.println(nation);
			System.out.println(name);
			System.out.println(birthDate);

			 String REGEX_EMAIL = "^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|          (?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$";
			    Pattern regex = Pattern.compile(REGEX_EMAIL);  
			     Matcher matcher = regex.matcher(birthDate);  
			     boolean isMatched = matcher.matches(); 
				if(sex==null||sex==""||introduce==null||introduce==""||phone==null||phone==""||workExper==null||workExper==""||skill==null||skill==""||workStatus==null||workStatus==""||expectSalary==null||expectSalary==""||nativePlace==null||nativePlace==""||livingPlace==null||livingPlace==""||degree==null||degree==""||learnMajor==null||learnMajor==""||school==null||school==""||politicStatus==null||politicStatus==""||marriage==null||marriage==""||nation==null||nation==""||name==null||name==""||birthDate==null||birthDate==""){
					JOptionPane.showMessageDialog(null, "必填项不得为空");
					System.out.println("1");
					request.getRequestDispatcher("personalCenter.jsp").forward(request, response);
				}else if(phone.length()!=11){
			    	 JOptionPane.showMessageDialog(null,"手机号格式不正确");
		    		  System.out.println("2");
		    		  request.getRequestDispatcher("personalCenter.jsp").forward(request, response);
				}else if(!isMatched){
			    		  JOptionPane.showMessageDialog(null,"日期格式不正确");
			    		  System.out.println("3");
			    	  request.getRequestDispatcher("personalCenter.jsp").forward(request, response);
				}
	            else {
			
	    	Resume resume =new Resume();
	    	
	    	ResumeDao resumedao=new ResumeDao();
	    	resume.setBirthDate(birthDate);
	    	resume.setDegree(degree);
	    	resume.setExpectSalary(expectSalary);
	    	resume.setIntroduce(introduce);
	    	resume.setLearnMajor(learnMajor);
	    	resume.setLivingPlace(livingPlace);
	    	resume.setMarriage(marriage);
	    	resume.setName(name);
	    	resume.setNation(nation);
	    	resume.setNativePlace(nativePlace);
	    	resume.setPhone(phone);
	    	resume.setPoliticStatus(politicStatus);
	    	resume.setSchool(school);
	    	resume.setSex(sex);
	    	resume.setSkill(skill);
	    	resume.setUser(user);
	    	resume.setWorkExper(workExper);
	    	resume.setWorkStatus(workStatus);
	    	resume.setUserInfoID(userInfoID);
	    	if(resumedao.updateResume(resume)) {
	    		 
			request.getRequestDispatcher("personalCenter.jsp").forward(request, response);
			JOptionPane.showMessageDialog(null,"修改简历成功");
	    	}
		}
	}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
