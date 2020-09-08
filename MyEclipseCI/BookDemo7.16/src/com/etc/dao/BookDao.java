package com.etc.dao;

import java.util.List;

import com.etc.entity.Book1;
import com.etc.entity.PageData;
import com.etc.util.BaseDBUtil;

public class BookDao {

	BaseDBUtil dbUtil = new BaseDBUtil();
	
	public PageData queryAllBook() {
		//sql语句
		String sql = "select * from tbl_book";
		
		List<Book1> list = (List<Book1>)dbUtil.Select(sql, Book1.class);
		System.out.println("list长度："+list.size());
		PageData pageData = new PageData(list, 1, list.size(), list.size());
		return pageData;

	}
	
	//分页查询
	/*
	 * pageNo 当前页
	 * pageSize 每页多少条记录
	 * 
	 */
	public PageData queryBooksByPage(int pageNo,int pageSize) {
		
		String sql = "select * from tbl_book";
		
		//调用dbutil的getpage方法
		PageData pageData = dbUtil.getpage(sql, pageNo, pageSize, Book1.class);
		return pageData;
		
	}
}
