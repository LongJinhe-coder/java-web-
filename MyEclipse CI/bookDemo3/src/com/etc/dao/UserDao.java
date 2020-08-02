package com.etc.dao;

import javax.sql.rowset.CachedRowSet;

import com.etc.util.DBUtil;

public class UserDao {
	//根据用户名密码查询用户信息
	DBUtil dbUtil = new DBUtil();
	//用户校验方法
	public boolean checkLogin(String username, String userpass) {
		String sql = "select * from tbl_user where userName = ? and userPass = ?";
		//创建结果缓冲集对象
		CachedRowSet crs = null;
		crs = dbUtil.Query(sql, username,userpass);
		//设计结果result
		int result = 0;
		try {
			if (crs.next()) {
				result = crs.getInt("userId");//查询用户id
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result>0;
		
	}
}
