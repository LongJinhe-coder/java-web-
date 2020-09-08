package com.etc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.etc.entity.User;
import com.etc.util.DBUtil;

public class UserDao {

	//user查询方法
	public List<User> userQuery() {
		
		List<User> list = new ArrayList<User>();
		DBUtil util = new DBUtil();
		
		String sql = "SELECT * FROM user WHERE age>?";
		CachedRowSet crs = util.query(sql, 10);
		
		try {
			while (crs.next()) {
				int id = crs.getInt("id");
				String username = crs.getString("username");
				String password = crs.getString("password");
				int age = crs.getInt("age");
				User user = new User(id,username,password,age);
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	//增删改操作
	public void update() {
		DBUtil dbUtil = new DBUtil();
		String sql = "update user set age = 18 where id =?";
		dbUtil.update(sql, 1003);
	}
}
