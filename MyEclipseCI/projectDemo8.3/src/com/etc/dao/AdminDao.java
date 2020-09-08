package com.etc.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.etc.entity.Administrator;
import com.etc.entity.Firm;
import com.etc.entity.PageData;
import com.etc.util.DBUtil;

public class AdminDao {
	DBUtil dbUtil =  new DBUtil();
	public String checkLogin(String email, String pwd) {
		String sql = "select * from ����Ա where adminName = ? and adminPwd = ?";
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
		String sql = "insert into ����Ա(adminName,adminPwd) values(?,?)";
		int result = 0; 
		result = dbUtil.update(sql, adminName,adminPwd);
		
		return result > 0;
		
	}
	
	public boolean queryName(String adminName) {
		String sql = "select adminName from ����Ա where adminName = ?";
		CachedRowSet crs = dbUtil.Query(sql, adminName);
		try {
			if (crs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public PageData queryByPage(int pageNo,int pageSize) {
		
		String sql = "select * from ����Ա";
		
		//����dbutil��getpage����
		PageData pageData = dbUtil.getpage(sql, pageNo, pageSize, Administrator.class);
		return pageData;
		
	}
	
	//ɾ������Ա�˺�
	public boolean deleteAccount(int adminID) {
		int result = 0;
		String sql = "delete from ����Ա where adminID = ?";
		result = dbUtil.update(sql,adminID);
		return result>0;
		
	}
	
	//ģ����ѯ�ķ���
	public PageData queryLikeName(String adminName) {
		  
		  //sql���
		 String sql = "select * from ����Ա where adminName like "+"'%"+adminName+"%'";
		 System.out.println(sql);
		//����dbutil��getpage����
			List<Administrator> list = (List<Administrator>) dbUtil.Select(sql, Administrator.class);
			PageData pageData = new PageData(list,1,list.size(),list.size());
			return pageData;
				  
	}
	
	//����adminName��ȡadminID
	public int getAdminID(String adminName) {
		String sql ="select * from ����Ա where adminName = ?";
		CachedRowSet crs = dbUtil.Query(sql, adminName);
		try {
			if (crs.next()) {
				int adminID = crs.getInt("adminID");
				return adminID;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public String getAdminName(int adminID) {
		
		String sql ="select * from ����Ա where adminID = ?";
		CachedRowSet crs = dbUtil.Query(sql, adminID);
		try {
			if (crs.next()) {
				String adminName = crs.getString("adminName");
				return adminName;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	

}