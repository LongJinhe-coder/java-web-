package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	private static final String HttpServletRequest = null;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
			
		/*
		 * 判断时，从session中取出uname属性
		 * 若取值不为空就是登录用户，否则转入注册界面
		 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//创建一个request对象
		HttpServletRequest requ = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//创建session对象
		HttpSession session = requ.getSession();
		//获取session的值
		if(session.getAttribute("uname")==null) {
			//返回注册界面
			resp.sendRedirect("/FilterDemo7.21/register.jsp");
		}else {
			if (session.getAttribute("uname").equals("admin")) {
				//调用下一个过滤器
				filterchain.doFilter(request, response);
//				resp.sendRedirect("FilterDemo7.21/login.jsp");
			}else {
				resp.sendRedirect("/FilterDemo7.21/register.jsp");
			}
		}
	}

}
