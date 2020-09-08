package com.etc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.UserDao;

public class RegisterCheck extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public RegisterCheck() {
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
		  //���ñ����ʽ
		  //������������ʽrequest
		     request.setCharacterEncoding("utf-8");
		     //������Ӧ�����ʽresponse
		     response.setCharacterEncoding("utf-8"); 
		  PrintWriter out = response.getWriter();
		  //System.out.println("������");
		  //��ȡ��������ݵ��û���������
		  String username=request.getParameter("username");
		  String register = request.getParameter("register");
		  System.out.println("register:"+register);
		  UserDao userDao = new UserDao();
		  boolean flag = userDao.userQuery(username);
		  String reqname = "^[A-Za-z][A-Za-z0-9]+$";
		  String reqpwd = "^[0-9]{6,10}$";
		  
		  System.out.println("username="+username);
		  if(flag) {
			   out.print("�û����Ѵ��ڣ������ظ���");
		  }else if(username.length()<6) {
			   out.print("�û������Ȳ���С��6��");
		  }else if(!username.matches(reqname)) {
		   out.print("�û�����ʽ����");
		  }else {
		   String userpwd=request.getParameter("password");
		   String userpwd2=request.getParameter("password2");
		   if(!"".equals(userpwd)) {
		    if(!userpwd.matches(reqpwd)) {
		     out.print("�����ʽ����");
		    } else if(!"".equals(userpwd2)) {
			    if(!userpwd2.matches(reqpwd)) {
				     out.print("ȷ�������ʽ����");
				    }else if(!userpwd.equals(userpwd2)){
				     out.print("������������벻һ�£�");
				    }else if(register.equals("yes")){
				    	
				    	 out.print("ע��ɹ���");
					}
				   }else {
				    out.print("ȷ�����벻��Ϊ�գ�");
				   }
		   }else{
		    out.print("���벻��Ϊ�գ�");
		   }
		  
		  }
		  out.flush();
		  out.close();
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
