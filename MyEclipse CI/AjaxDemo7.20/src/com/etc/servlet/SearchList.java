package com.etc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchList extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public SearchList() {
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

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/xml;charset=UTF-8");
		//设置编码格式
		//设置请求编码格式request
		request.setCharacterEncoding("utf-8");
		//设置响应编码格式response
		response.setCharacterEncoding("utf-8");	
		PrintWriter out = response.getWriter();
		HashMap map = new HashMap();
		map.put("a","<words><word>a</word><word>ab</word><word>abc</word><word>abcd</word><word>abcde</word></words>");
		map.put("ab","<words><word>ab</word><word>abc</word><word>abcd</word><word>abcde</word></words>");
		map.put("abc","<words><word>abc</word><word>abcd</word><word>abcde</word></words>");
		map.put("abcd", "<words><word>abcd</word><word>abcde</word></words>");
		map.put("abcde", "<words><word>abcde</word></words>");
		//获取浏览器传递的数据inputWord
		String inputWord = request.getParameter("inputWord");
		System.out.println("inputWord的值"+inputWord);
		if(!map.containsKey(inputWord)) {
			out.println("<words></words>");
			System.out.println("map的长度为1");

		}else {
			out.println(map.get(inputWord).toString());
			System.out.println("map的长度"+map.size());
		}
		
		
		out.flush();
		out.close();
	
		/*
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HashMap map = new HashMap();
		map.put("a","<words><word>a</word><word>ab</word><word>abc</word><word>abcd</word><word>abcde</word></words>");
		map.put("ab","<words><word>ab</word><word>abc</word><word>abcd</word><word>abcde</word></words>");
		map.put("abc","<words><word>abc</word><word>abcd</word><word>abcde</word></words>");
		map.put("abcd", "<words><word>abcd</word><word>abcde</word></words>");
		map.put("abcde", "<words><word>abcde</word></words>");
		String inputWord = request.getParameter("inputWord");
		if (!map.containsKey(inputWord)) {
			out.println("<words></words>");
		} else {
			out.println(map.get(inputWord).toString());
		}	
		*/
		
		
		
		
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
