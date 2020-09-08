package com.etc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.etc.entity.User;
import com.etc.util.DBUtil;

public class UserDao {

	//user查询方法
	public boolean userQuery(String username, String password) {
		
		User user = new User();
		DBUtil util = new DBUtil();
		
		String sql = "SELECT username,password FROM user WHERE username=? and password=?";
		CachedRowSet crs = util.query(sql, username,password);
		boolean flag = false;
		try {
			if (crs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
		
	}
	
	//增删改操作
	public void update() {
		DBUtil dbUtil = new DBUtil();
		String sql = "update user set age = 18 where id =?";
		dbUtil.update(sql, 1003);
	}
}
