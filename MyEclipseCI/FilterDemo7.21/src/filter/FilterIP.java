package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FilterIP
 */
//@WebFilter("/FilterIP")
public class FilterIP implements Filter {

    /**
     * Default constructor. 
     */
	private String FilterIP;
	
	public void init(FilterConfig fConfig) throws ServletException {
		// 初始化
		FilterIP = fConfig.getInitParameter("IP");
		System.out.println("FilterIP:"+FilterIP);
		if (FilterIP==null) {
			FilterIP = "";
		}
	}
	
    public FilterIP() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//创建一个request对象
		HttpServletRequest requ = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//获取项目运行IP地址
		String remoteIP = request.getRemoteAddr();
		System.out.println("remoteIP:"+remoteIP);
		if (remoteIP.equals(FilterIP)) {
			//跳转到错误界面
			//resp.sendRedirect("/FilterDemo7.21/errorinfo.jsp");
			requ.getRequestDispatcher("errorinfo.jsp").forward(requ, resp);
		}else {
			chain.doFilter(request, response);
		}
		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	

}
