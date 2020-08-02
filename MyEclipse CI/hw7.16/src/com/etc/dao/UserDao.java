package com.etc.dao;

import java.util.List;

import com.etc.entity.User;
import com.etc.entity.PageData;
import com.etc.util.BaseDBUtil;

public class UserDao {

	BaseDBUtil dbUtil = new BaseDBUtil();
	
	public PageData queryAllBook() {
		//sql语句
		String sql = "select * from user";
		
		List<User> list = (List<User>)dbUtil.Select(sql, User.class);
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
		
		String sql = "select * from user";
		
		//调用dbutil的getpage方法
		PageData pageData = dbUtil.getpage(sql, pageNo, pageSize, User.class);
		return pageData;
		
	}
}
