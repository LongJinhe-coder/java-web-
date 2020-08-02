package com.etc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CityList extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public CityList() {
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

		doPost(request, response);
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

		  response.setContentType("text/html");
		  //设置编码格式
		  request.setCharacterEncoding("utf-8");
		  response.setCharacterEncoding("utf-8");
		  
		  PrintWriter out=response.getWriter();
		  
		  //创建一个Map对象
		  Map<String,String> pm=new HashMap<String,String>();
		  pm.put("山东", "济南,青岛,泰山,潍坊,烟台,聊城,枣庄,菏泽,莱芜,临沂");
		  pm.put("江苏", "南京,苏州,无锡,徐州,南通,连云港,镇江,常州,淮安,扬州");
		  pm.put("广东", "广州,深圳,珠海,汕头,佛山,东莞,湛江,江门,中山,惠州");
		     
		  //responseXML:服务器端返回的XML类型的响应
		  response.setContentType("text/xml;charset=UTF-8");
		  //获取浏览器传递的省份名称
		  String prov=request.getParameter("prov");
		  out.print(pm.get(prov));
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
