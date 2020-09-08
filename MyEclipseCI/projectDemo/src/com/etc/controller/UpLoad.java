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
	
	//�õ�url�ķ���
	 
	
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
		//��ȡIP��ַ
		String requestip = request.getRemoteAddr();
		//����·��saveDirectory---this.getServletContext().getRealPath("")
		//��ȡ��ǰ��Ŀ��·��
		int firmID =Integer.parseInt(session.getAttribute("firmID").toString());
		String saveDirectory ="E:\\JavaWebʵѵ\\MyEclipseCI\\projectDemo\\WebRoot\\image\\firm\\"+ firmID;
		//��·���ϴ����ļ�
		File savedir = new File(saveDirectory);
		if (!savedir.exists()) {
			savedir.mkdirs();	//�½��ļ�
		}
		//���ϴ���С���ƣ�15M
		int maxPostSize = 3 * 5 * 1024 * 1024;
		//multipaetrequest�����ȡ�ϴ��ļ�����Ϣ
		MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxPostSize, "utf-8");
		//ö��---��ȡ����ļ���
		Enumeration<String> files = multi.getFileNames();
		String name = files.nextElement();
		//��ȡ�ļ�
		File f = multi.getFile(name);
		if (f != null) {
			String message = "";
			String fileName = f.getName();
			//trim()ȥ��ǰ��ո�
			String sno = fileName.trim().substring(0, fileName.indexOf("."));
			//��ȡ��ʼ�������е�m1
			Map<String, String> m1 = (Map<String, String>) this.getServletContext().getAttribute("ipsno");

			String msno1 = m1.get(requestip);
			Cookie[] cs = request.getCookies();
			String msno2 = null;
			if (cs != null) {
				for (int i = 0; i < cs.length; i++) {
					if (cs[i].getName().equals("sno")) {
						//���Cookie�е�ѧ��
						msno2 = cs[i].getValue();
					}
				}
				//����requestipֵ��sno
				m1.put(requestip, sno);
				Cookie c = new Cookie("sno", sno);
				c.setMaxAge(3 * 3600);
				response.addCookie(c);
				//����·��
				File sServerFile = new File(saveDirectory + "\\" + requestip + "-" + fileName);
				System.out.println("����·�� = "+saveDirectory + "\\" + requestip + "-" + fileName);
				if (sServerFile.exists()) {
					sServerFile.delete();
				}
				//�������ļ�
				f.renameTo(sServerFile);
				message = "�ļ��ϴ��ɹ����ļ���Ϊ��" + fileName;
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