package com.etc.dao;
import javax.sql.rowset.CachedRowSet;

import com.etc.util.DBUtil;

public class UserDao {

	//user≤È—Ø∑Ω∑®
	public boolean userQuery(String username) {
		
		
		DBUtil util = new DBUtil();
		
		String sql = "SELECT username,password FROM user WHERE username=?";
		CachedRowSet crs = util.query(sql, username);
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
	
}
