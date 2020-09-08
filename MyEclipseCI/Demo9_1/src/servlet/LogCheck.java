package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * 处理登录请求的Servlet ---LogCheck
 */
public class LogCheck extends HttpServlet {
	
	public LogCheck() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		String usercheckcode = request.getParameter("checkcode");
		String info = "";
		HttpSession session = request.getSession();
		String servercheckcode = (String) session.getAttribute("checkCode");
		if (!servercheckcode.equalsIgnoreCase(usercheckcode)) {
			info = "验证码不正确，请重新输入";
		} else if ("张三".equals(userid) && "123".equals(userpwd)) {
			info = "登录成功";
		} else {
			info = "用户名或密码不正确";
		}
		/*
		 * 服务器端的重定向可以有两种方式，
		 * 一是使用HttpServletResponse的sendRedirect()方法，
		 * 一是使用RequestDispatcher的forward()方法.
		 */                                
		request.setAttribute("info", info);
		RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
		rd.forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
