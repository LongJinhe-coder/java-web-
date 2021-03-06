package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.etc.dao.UserDao;
import com.etc.entity.PageData;
import com.etc.entity.User;

public class UserServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public UserServlet() {
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
	
	public void queryAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao = new UserDao();
		List<User> list = userDao.queryAllUsers();
		request.setAttribute("userlist", list);
		getUrl(request, response);
		request.getRequestDispatcher("adminhome.jsp").forward(request, response);
	}
	
	public void queryByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao = new UserDao();
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
		PageData pageData = userDao.queryByPage(pageNo, pageSize);
		request.setAttribute("pagedata", pageData);
		getUrl(request, response);
		request.getRequestDispatcher("adminhome.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		 
		UserDao userDao = new UserDao();
		String option = null;
		option = (String)request.getParameter("option");
		System.out.println("将要进行的操作是"+option);
		if (option.equals("queryAllUsers")) {
			queryAllUsers(request, response);
		}else if (option.equals("queryByPage")) {
			queryByPage(request, response);
			
			}else if (option.equals("freezingAccount")) {
			int userID = Integer.parseInt(request.getParameter("userID"));
			System.err.println("userID="+userID);
			if (userDao.freezingAccount(userID)) {
				System.err.println("冻结账号成功");
			}
			queryByPage(request, response);
		}else if (option.equals("removeFreezing")) {
			int userID = Integer.parseInt(request.getParameter("userID"));
			System.err.println("userID="+userID);
			if (userDao.removeFreezing(userID)) {
				System.err.println("解除冻结成功");
			}
			queryByPage(request, response);
		}else if (option.equals("deleteAccount")) {
			int userID = Integer.parseInt(request.getParameter("userID"));
			if (userDao.deleteAccount(userID)) {
				System.err.println("删除账号成功");
			}
			queryByPage(request, response);
		}else if (option.equals("queryLikeName")) {
			//获取浏览器传递的用户名称
			String userName = request.getParameter("username");
			PageData pageData = userDao.queryLikeName(userName);
			request.setAttribute("pagedata", pageData);
			getUrl(request, response);
			request.getRequestDispatcher("adminhome.jsp").forward(request, response);
		}else if (option.equals("addAccount")) {
			String username=request.getParameter("name");
			String email=request.getParameter("email");
	    	String userpwd=request.getParameter("password");
	    	String avatarName=request.getParameter("phone");
	    	String usercheckcode = request.getParameter("check");
	    	String accountStatus="正常";
	    	HttpSession session = request.getSession();
			String servercheckcode = (String) session.getAttribute("checkCode");
			System.out.println(username);
			System.out.println(email);
			System.out.println(userpwd);
			System.out.println(avatarName);
			System.out.println(usercheckcode);
			 String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
			    Pattern regex = Pattern.compile(REGEX_EMAIL);  
			     Matcher matcher = regex.matcher(email);  
			     boolean isMatched = matcher.matches();  
			if (!servercheckcode.equalsIgnoreCase(usercheckcode)) {
				JOptionPane.showMessageDialog(null,"验证码不正确，请重新输入");
				request.getRequestDispatcher("personalregister.jsp").forward(request, response);
				
			}else if(username==null||username==""||userpwd==null||userpwd==""||avatarName==null||avatarName==""||usercheckcode==null||usercheckcode==""){
				JOptionPane.showMessageDialog(null, "必填项不得为空");
				request.getRequestDispatcher("personalregister.jsp").forward(request, response);
				 
//		    }else if(!(email==username)){
//		    	JOptionPane.showMessageDialog(null,"邮箱与用户名须一致");
//		    	System.out.println("3");
//		    	  
		    }else if(!isMatched){
		    		  JOptionPane.showMessageDialog(null,"邮箱格式不正确");
		    		  request.getRequestDispatcher("personalregister.jsp").forward(request, response);
		    	 
		    }else if(userpwd.length()<6||userpwd.length()>12){
		    		  JOptionPane.showMessageDialog(null,"密码必须6到12位，且不能出现空格");
		    		  request.getRequestDispatcher("personalregister.jsp").forward(request, response);
		        
		    }else {
				
			
	    	UserDao userdao = new UserDao();
	    	User user =new User();
	    	user.setUserName(username);
	    	user.setEmail(email);
	    	user.setAccountStatus(accountStatus);
	    	user.setAvatarName(avatarName);
	    	user.setUserPwd(userpwd);
	    	if(userdao.addUser(user)) {
	    		 System.out.println("添加账号成功");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			JOptionPane.showMessageDialog(null,"账号注册成功");
			//response.sendRedirect("login.jsp");
	    	}
	    	
		}
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
