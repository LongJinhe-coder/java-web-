package com.etc.dao;

import java.util.List;

import com.etc.entity.Book1;
import com.etc.entity.PageData;
import com.etc.util.BaseDBUtil;

public class BookDao {

	BaseDBUtil dbUtil = new BaseDBUtil();
	
	public PageData queryAllBook() {
		//sql���
		String sql = "select * from tbl_book";
		
		List<Book1> list = (List<Book1>)dbUtil.Select(sql, Book1.class);
		System.out.println("list���ȣ�"+list.size());
		PageData pageData = new PageData(list, 1, list.size(), list.size());
		return pageData;

	}
	
	//��ҳ��ѯ
	/*
	 * pageNo ��ǰҳ
	 * pageSize ÿҳ��������¼
	 * 
	 */
	public PageData queryBooksByPage(int pageNo,int pageSize) {
		
		String sql = "select * from tbl_book";
		
		//����dbutil��getpage����
		PageData pageData = dbUtil.getpage(sql, pageNo, pageSize, Book1.class);
		return pageData;
		
	}
}
