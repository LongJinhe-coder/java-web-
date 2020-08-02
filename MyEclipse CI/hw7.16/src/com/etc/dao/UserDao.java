package com.etc.dao;

import java.util.List;

import com.etc.entity.User;
import com.etc.entity.PageData;
import com.etc.util.BaseDBUtil;

public class UserDao {

	BaseDBUtil dbUtil = new BaseDBUtil();
	
	public PageData queryAllBook() {
		//sql���
		String sql = "select * from user";
		
		List<User> list = (List<User>)dbUtil.Select(sql, User.class);
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
		
		String sql = "select * from user";
		
		//����dbutil��getpage����
		PageData pageData = dbUtil.getpage(sql, pageNo, pageSize, User.class);
		return pageData;
		
	}
}
