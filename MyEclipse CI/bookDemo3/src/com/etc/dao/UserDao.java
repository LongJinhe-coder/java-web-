package com.etc.dao;

import javax.sql.rowset.CachedRowSet;

import com.etc.util.DBUtil;

public class UserDao {
	//�����û��������ѯ�û���Ϣ
	DBUtil dbUtil = new DBUtil();
	//�û�У�鷽��
	public boolean checkLogin(String username, String userpass) {
		String sql = "select * from tbl_user where userName = ? and userPass = ?";
		//����������弯����
		CachedRowSet crs = null;
		crs = dbUtil.Query(sql, username,userpass);
		//��ƽ��result
		int result = 0;
		try {
			if (crs.next()) {
				result = crs.getInt("userId");//��ѯ�û�id
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result>0;
		
	}
}
