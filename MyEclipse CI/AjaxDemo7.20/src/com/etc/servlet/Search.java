package com.etc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Search extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public Search() {
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

		response.setContentType("text/xml;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		HashMap map = new HashMap();
		map.put("a","<words><word>a</word><word>ab</word><word>abc</word><word>abcd</word><word>abcde</word></words>");
		map.put("ab","<words><word>ab</word><word>abc</word><word>abcd</word><word>abcde</word></words>");
		map.put("abc","<words><word>abc</word><word>abcd</word><word>abcde</word></words>");
		map.put("abcd", "<words><word>abcd</word><word>abcde</word></words>");
		map.put("abcde", "<words><word>abcde</word></words>");
		String inputWord = request.getParameter("inputWord");
		if (!map.containsKey(inputWord)) {
			out.print("<words></words>");
		}else {
			out.print(map.get(inputWord).toString());
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
