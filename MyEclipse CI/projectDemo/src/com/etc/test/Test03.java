package com.etc.test;

import java.util.List;

import com.etc.dao.FirmDao;
import com.etc.entity.Firm;
import com.etc.entity.PageData;

public class Test03 {
	public static void main(String[] args) {
		FirmDao firmDao = new FirmDao();
		//设置默认显示第一页
		int pageNo = 1;
		int pageSize = 8;
		//获取浏览器传递的pageNo与pageSize
//		if (request.getParameter("pageNo")!=null) {
//			pageNo = Integer.parseInt(request.getParameter("pageNo"));
//			if (pageNo<=0) {
//				pageNo = 1;
//			}
//			if (request.getParameter("pageSize")!=null) {
//				pageSize = Integer.parseInt(request.getParameter("pageSize"));
//				if (pageSize<=0) {
//					pageSize = 1;
//				}
//			}
//		}
		PageData pageData = firmDao.queryByPage(pageNo, pageSize);
		List<Firm> list = pageData.getData();
		for (Firm firm : list) {
			System.out.println(list);
		}
//		request.setAttribute("pagedata", pageData);
//		getUrl(request, response);
//		request.getRequestDispatcher("adminhome.jsp").forward(request, response);
	}
}
