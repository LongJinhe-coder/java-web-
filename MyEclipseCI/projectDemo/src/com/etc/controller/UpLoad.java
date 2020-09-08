package com.etc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.dao.updateDao;
import com.oreilly.servlet.MultipartRequest;

public class UpLoad extends HttpServlet {

	@Override
	public void init() throws ServletException {
		Map<String, String> m1 = new HashMap<String, String>();
		this.getServletContext().setAttribute("ipsno", m1);
	}

	public void destroy() {
		super.destroy();
	}
	
	//得到url的方法
	 
	
		public void getUrl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String url = request.getParameter("url");
			System.out.println("url ="+url);
			HttpSession session = request.getSession();
			session.setAttribute("url", url);
		}

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		

		HttpSession session = request.getSession();
		//获取IP地址
		String requestip = request.getRemoteAddr();
		//保存路径saveDirectory---this.getServletContext().getRealPath("")
		//获取当前项目的路径
		int firmID =Integer.parseInt(session.getAttribute("firmID").toString());
		String saveDirectory ="E:\\JavaWeb实训\\MyEclipseCI\\projectDemo\\WebRoot\\image\\firm\\"+ firmID;
		//在路径上创建文件
		File savedir = new File(saveDirectory);
		if (!savedir.exists()) {
			savedir.mkdirs();	//新建文件
		}
		//总上传大小限制：15M
		int maxPostSize = 3 * 5 * 1024 * 1024;
		//multipaetrequest对象获取上传文件的信息
		MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxPostSize, "utf-8");
		//枚举---获取多个文件名
		Enumeration<String> files = multi.getFileNames();
		String name = files.nextElement();
		//获取文件
		File f = multi.getFile(name);
		if (f != null) {
			String message = "";
			String fileName = f.getName();
			//trim()去掉前后空格
			String sno = fileName.trim().substring(0, fileName.indexOf("."));
			//获取初始化方法中的m1
			Map<String, String> m1 = (Map<String, String>) this.getServletContext().getAttribute("ipsno");

			String msno1 = m1.get(requestip);
			Cookie[] cs = request.getCookies();
			String msno2 = null;
			if (cs != null) {
				for (int i = 0; i < cs.length; i++) {
					if (cs[i].getName().equals("sno")) {
						//获得Cookie中的学号
						msno2 = cs[i].getValue();
					}
				}
				//键：requestip值：sno
				m1.put(requestip, sno);
				Cookie c = new Cookie("sno", sno);
				c.setMaxAge(3 * 3600);
				response.addCookie(c);
				//保存路径
				File sServerFile = new File(saveDirectory + "\\" + requestip + "-" + fileName);
				System.out.println("保存路径 = "+saveDirectory + "\\" + requestip + "-" + fileName);
				if (sServerFile.exists()) {
					sServerFile.delete();
				}
				//重命名文件
				f.renameTo(sServerFile);
				message = "文件上传成功！文件名为：" + fileName;
				String type = fileName.substring(fileName.indexOf(".")+1,fileName.length());
				String pname = fileName.substring(0, fileName.indexOf("."));
				updateDao updao = new updateDao();
				updao.insertFirmPhoto(firmID,pname, type);
				request.setAttribute("message", message);
			}
			getUrl(request,response);
			request.getRequestDispatcher("/firmhome.jsp").forward(request,response);
		}
	}
}