package com.etc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import com.etc.entity.PageData;
import com.etc.entity.User;
import com.etc.util.DBUtil;

public class UserDao {
	DBUtil dbUtil =  new DBUtil();
	
	//��ѯ�����û�
	public List<User> queryAllUsers() {
		String sql = "select * from �û���";
		List<User> list = (List<User>)dbUtil.Select(sql, User.class);
		System.out.println("�û�������="+list.size());
		return list;
		
	}
	
	//��ҳ��ѯ
	/*
	 * pageNo ��ǰҳ
	 * pageSize ÿҳ��������¼ 
	 */
	public PageData queryByPage(int pageNo,int pageSize) {
		
		String sql = "select * from �û���";
		
		//����dbutil��getpage����
		PageData pageData = dbUtil.getpage(sql, pageNo, pageSize, User.class);
		return pageData;
		
	}
		
	//�����û��˺�
	public boolean freezingAccount(int userID) {
		int result = 0;
		String status = "������";
		String sql = "update �û��� set accountStatus = ? where userID = ?";
		result = dbUtil.update(sql,status,userID);
		return result>0;
		
	}
	
	//�����û��˺�
		public boolean removeFreezing(int userID) {
			int result = 0;
			String status = "����";
			String sql = "update �û��� set accountStatus = ? where userID = ?";
			result = dbUtil.update(sql,status,userID);
			return result>0;
			
		}

	//ɾ���û��˺�
	public boolean deleteAccount(int userID) {
		int result = 0;
		String sql = "delete from �û��� where userID = ?";
		result = dbUtil.update(sql,userID);
		return result>0;
		
	}
	
	//ģ����ѯ�ķ���
	public PageData queryLikeName(String userName) {
		  
		  //sql���
		 String sql = "select * from �û��� where userName like "+"'%"+userName+"%'";
		//����dbutil��getpage����
			List<User> list = (List<User>) dbUtil.Select(sql, User.class);
			PageData pageData = new PageData(list,1,list.size(),list.size());
			return pageData;
				  
	}
	
	public List<String> checkLogin(String email, String pwd) {
		String sql = "select * from �û��� where email = ? and userPwd = ?";
		CachedRowSet crs = dbUtil.Query(sql, email,pwd);
		try {
			if (crs.next()) {
				List<String> list = new ArrayList<String>();
				String userName = crs.getString("userName");
				String accountSatus = crs.getString("accountStatus");
				list.add(userName);
				list.add(accountSatus);
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	//����
		public boolean addUser(User user) {
			//��дsql ���  insert into �û��� VALUES(null,"���ѧϰ",1)
			String sql  = "insert into �û��� values(null,?,?,?,?,?)";
			//��ʼ��һ��result����
				int result =  0;
				//����  ����  
				result  = dbUtil.update(sql, user.getUserName(),user.getUserPwd(),user.getAvatarName(),user.getEmail(),user.getAccountStatus());		
				return result>0;
					
			}
		
		public boolean updateUser(User user) {
			//��дsql���
			String sql  = "update �û��� set userName = ? ,userPwd= ? ,avatarName= ? , email= ? where userID= ? ";
			//��ʼ��һ��result����
			int result =  0;
			result= dbUtil.update(sql, user.getUserName(),user.getUserPwd(),user.getAvatarName(),user.getEmail(),user.getUserID()
					);//����˳��
			return result>0;
			
		}
}