package com.etc.controller;

import java.io.IOException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.etc.dao.AdminDao;
import com.etc.dao.FirmDao;
import com.etc.dao.UserDao;
import com.etc.entity.Administrator;
import com.etc.entity.Firm;
import com.etc.entity.PageData;

public class FirmServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public FirmServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		 
		FirmDao firmDao = new FirmDao();
		String option = null;
		option = (String)request.getParameter("option");
		System.out.println("��Ҫ���еĲ�����"+option);
		if (option.equals("queryAllFirms")) {
			queryAllFirms(request, response);
		}else if (option.equals("addAccount")) {
			String firmAccount=request.getParameter("firmAccount");
			String registerTime=request.getParameter("registerTime");
	    	String password=request.getParameter("password");
	    	String firmName=request.getParameter("firmName");
	    	String registerArea = request.getParameter("registerArea");
	    	String firmNature = request.getParameter("firmNature");
	    	String registerFund = request.getParameter("registerFund");
	    	String firmBrief = request.getParameter("firmBrief");
	    	String linkMan = request.getParameter("linkMan");
	    	String linkPhone = request.getParameter("linkPhone");
	    	String firmArea = request.getParameter("firmArea");
	    	String registerNum = request.getParameter("registerNum");
	    	String firmEmail = request.getParameter("firmEmail");
	    	String usercheckcode = request.getParameter("check");
	    	String checkStatus="�����";
	    	Administrator admin=new Administrator();
	    	admin.setAdminID(1243);
	    	
	    	String accountStatus="����";
	    	HttpSession session = request.getSession();
			String servercheckcode = (String) session.getAttribute("checkCode");
			System.out.println(admin.getAdminID());
			System.out.println(firmAccount);
			System.out.println(registerTime);
			System.out.println(password);
			System.out.println(firmName);
			System.out.println(registerArea);
			System.out.println(firmNature);
			System.out.println(registerFund);
			System.out.println(firmBrief);
			System.out.println(linkMan);
			System.out.println(linkPhone);
			System.out.println(firmArea);
			System.out.println(registerNum);
			System.out.println(firmEmail);
			System.out.println(usercheckcode);
			 String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
			    Pattern regex = Pattern.compile(REGEX_EMAIL);  
			     Matcher matcher = regex.matcher(firmEmail);  
			     boolean isMatched = matcher.matches();  
			if (!servercheckcode.equalsIgnoreCase(usercheckcode)) {
				JOptionPane.showMessageDialog(null,"��֤�벻��ȷ������������");
				System.out.println("1");
				request.getRequestDispatcher("firmregister.jsp").forward(request, response);
			}else if(usercheckcode==null||usercheckcode==""||firmEmail==null||firmEmail==""||registerNum==null||registerNum==""||firmArea==null||firmArea==""||linkPhone==null||linkPhone==""||linkMan==null||linkMan==""||firmBrief==null||firmBrief==""||registerFund==null||registerFund==""||firmNature==null||firmNature==""||registerArea==null||registerArea==""||firmName==null||firmName==""||password==null||password==""||registerTime==null||registerTime==""||firmAccount==null||firmAccount==""){
				JOptionPane.showMessageDialog(null, "�������Ϊ��");
				System.out.println("2");
				 
//		    }else if(!(email==username)){
//		    	JOptionPane.showMessageDialog(null,"�������û�����һ��");
//		    	System.out.println("3");
//		    	  
		    }else if(linkPhone.length()!=11){
		    	 JOptionPane.showMessageDialog(null,"��ϵ���ֻ��Ÿ�ʽ����ȷ");
	    		  System.out.println("3");
	    		  request.getRequestDispatcher("firmregister.jsp").forward(request, response);
			}
			
			else if(!isMatched){
		    		  JOptionPane.showMessageDialog(null,"�����ʽ����ȷ");
		    		  System.out.println("4");
		    		  request.getRequestDispatcher("firmregister.jsp").forward(request, response);
		    }else if(password.length()<6||password.length()>12){
		    		  JOptionPane.showMessageDialog(null,"�������6��12λ���Ҳ��ܳ��ֿո�");
		    		  System.out.println("5");
		    		  request.getRequestDispatcher("firmregister.jsp").forward(request, response);
		    }else {
	    	Firm firm =new Firm();
	    	firm.setAccountStatus(accountStatus);
	    	FirmDao firmdao=new FirmDao();
	    	firm.setAdmin(admin);
	    	firm.setCheckStatus(checkStatus);
	    	firm.setFirmAccount(firmAccount);
	    	firm.setFirmArea(firmArea);
	    	firm.setFirmBrief(firmBrief);
	    	firm.setFirmEmail(firmEmail);
	    	firm.setFirmName(firmName);
	    	firm.setFirmNature(firmNature);
	    	firm.setFirmPwd(password);
	    	firm.setLinkMan(linkMan);
	    	firm.setLinkPhone(linkPhone);
	    	firm.setRegisterArea(registerArea);
	    	firm.setRegisterFund(registerFund);
	    	firm.setRegisterNum(registerNum);
	    	firm.setRegisterTime(registerTime);
	    	
	    	if(firmdao.addFirm(firm)) {
	    		 
			request.getRequestDispatcher("login.jsp").forward(request, response);
			JOptionPane.showMessageDialog(null,"�����˺ųɹ�");
	    	}
	    	
		}
		}else if (option.equals("queryByPage")) {
			queryByPage(request, response);
			
			}else if (option.equals("freezingAccount")) {
			int firmID = Integer.parseInt(request.getParameter("firmID"));
			System.err.println("firmID="+firmID);
			if (firmDao.freezingAccount(firmID)) {
				System.err.println("�����˺ųɹ�");
			}
			queryByPage(request, response);
		}else if (option.equals("removeFreezing")) {
			int firmID = Integer.parseInt(request.getParameter("firmID"));
			System.err.println("userID="+firmID);
			if (firmDao.removeFreezing(firmID)) {
				System.err.println("�������ɹ�");
			}
			queryByPage(request, response);
		}else if (option.equals("deleteAccount")) {
			int firmID = Integer.parseInt(request.getParameter("firmID"));
			if (firmDao.deleteAccount(firmID)) {
				System.err.println("ɾ���˺ųɹ�");
			}
			queryByPage(request, response);
		}else if (option.equals("queryLikeName")) {
			//��ȡ��������ݵ��û�����
			String firmName = request.getParameter("firmname");
			PageData pageData = firmDao.queryLikeName(firmName);
			request.setAttribute("pagedata", pageData);
			getUrl(request, response);
			request.getRequestDispatcher("adminhome.jsp").forward(request, response);
		}else if (option.equals("queryByID")) {
			//��ȡ��������ݵ��û�����
			String firmID = request.getParameter("firmID");
			System.out.println("firmID->"+firmID);
			Firm firm = firmDao.queryByID(Integer.parseInt(firmID));
			AdminDao adminDao = new AdminDao();
			String checkMan = adminDao.getAdminName(firm.getAdmin().getAdminID());
			request.setAttribute("firm", firm);
			request.setAttribute("checkMan", checkMan);
			getUrl(request, response);
			request.getRequestDispatcher("adminhome.jsp").forward(request, response);
		}else if (option.equals("boolPassCheck")) {
			String firmID = request.getParameter("firmID");
			String checkStatus = request.getParameter("checkstatus");
			HttpSession session = request.getSession();
			String adminName = (String) session.getAttribute("adminname");
			//String adminName = request.getParameter("adminname");//��¼��˭��˵�
			System.out.println("adminName===="+adminName);
			AdminDao adminDao = new AdminDao();
			int adminID = adminDao.getAdminID(adminName);
			System.out.println("adminID="+adminID);
			if (firmDao.setAdminID(Integer.parseInt(firmID), adminID)) {
				System.out.println("��¼adminID�ɹ�");
			}
			
			if (firmDao.changeCheckStatus(Integer.parseInt(firmID), checkStatus)) {
				System.out.println("checkStatus�ı�ɹ���");
			}
			queryByPage(request, response);
		}else if(option.equals("updateFirmResume")) {
			int firmID=Integer.parseInt(request.getParameter("firmID"));
			String firmAccount=request.getParameter("firmAccount");
			String registerTime=request.getParameter("registerTime");
			String firmName=request.getParameter("firmName");
			String registerArea=request.getParameter("registerArea");
			String firmNature=request.getParameter("firmNature");
			String registerFund=request.getParameter("registerFund");
			String firmBrief=request.getParameter("firmBrief");
			String linkMan=request.getParameter("linkMan");
			String linkPhone=request.getParameter("linkPhone");
			String firmArea=request.getParameter("firmArea");
			String registerNum=request.getParameter("registerNum");
			String firmEmail=request.getParameter("firmEmail");
			String checkStatus=request.getParameter("checkStatus");
			String firmPwd=request.getParameter("firmPwd");
			String accountStatus=request.getParameter("accountStatus");
			
			//Ĭ�Ϲ���ԱΪ1243(boss)
			Administrator admin=new Administrator();
			admin.setAdminID(1243);
			Firm firm=new Firm(firmID, admin, firmAccount, registerTime, firmName, registerArea, firmNature, registerFund, firmBrief, linkMan, linkPhone, firmArea, registerNum, firmEmail, checkStatus, firmPwd, accountStatus);
			if(firmDao.updateFirm(firm)) {
			System.out.println("upadate--------------------->sucessful");
			getUrl(request,response);
			request.getRequestDispatcher("firmhome.jsp").forward(request, response);
			}
		}
	
	
	}
	//�õ�url�ķ���
	public void getUrl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = request.getParameter("url");
		System.out.println("url ="+url);
		HttpSession session = request.getSession();
		session.setAttribute("url", url);
	}
	public void queryAllFirms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FirmDao firmDao = new FirmDao();
		List<Firm> list = firmDao.queryAllFirms();
		request.setAttribute("firmlist", list);
		getUrl(request, response);
		request.getRequestDispatcher("adminhome.jsp").forward(request, response);
	}
	
	public void queryByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FirmDao firmDao = new FirmDao();
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
		PageData pageData = firmDao.queryByPage(pageNo, pageSize);
		request.setAttribute("pagedata", pageData);
		getUrl(request, response);
		request.getRequestDispatcher("adminhome.jsp").forward(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}