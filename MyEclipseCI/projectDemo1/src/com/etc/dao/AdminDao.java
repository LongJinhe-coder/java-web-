package com.etc.dao;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import com.etc.entity.Administrator;
import com.etc.util.DBUtil;

public class AdminDao {
	DBUtil dbUtil =  new DBUtil();
	public String checkLogin(String email, String pwd) {
		String sql = "select * from 管理员 where adminName = ? and adminPwd = ?";
		CachedRowSet crs = dbUtil.Query(sql, email,pwd);
		try {
			if (crs.next()) {
				String userName = crs.getString("adminName");
				return userName;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	public boolean addAccount(String adminName, String adminPwd) {
		String sql = "insert into 管理员(adminName,adminPwd) values(?,?)";
		int result = 0; 
		result = dbUtil.update(sql, adminName,adminPwd);
		
		return result > 0;
		
	}
}
