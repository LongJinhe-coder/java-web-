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
	
	//查询所有用户
	public List<User> queryAllUsers() {
		String sql = "select * from 用户表";
		List<User> list = (List<User>)dbUtil.Select(sql, User.class);
		System.out.println("用户表长度="+list.size());
		return list;
		
	}
	
	//分页查询
	/*
	 * pageNo 当前页
	 * pageSize 每页多少条记录 
	 */
	public PageData queryByPage(int pageNo,int pageSize) {
		
		String sql = "select * from 用户表";
		
		//调用dbutil的getpage方法
		PageData pageData = dbUtil.getpage(sql, pageNo, pageSize, User.class);
		return pageData;
		
	}
		
	//冻结用户账号
	public boolean freezingAccount(int userID) {
		int result = 0;
		String status = "冻结中";
		String sql = "update 用户表 set accountStatus = ? where userID = ?";
		result = dbUtil.update(sql,status,userID);
		return result>0;
		
	}
	
	//冻结用户账号
		public boolean removeFreezing(int userID) {
			int result = 0;
			String status = "正常";
			String sql = "update 用户表 set accountStatus = ? where userID = ?";
			result = dbUtil.update(sql,status,userID);
			return result>0;
			
		}

	//删除用户账号
	public boolean deleteAccount(int userID) {
		int result = 0;
		String sql = "delete from 用户表 where userID = ?";
		result = dbUtil.update(sql,userID);
		return result>0;
		
	}
	
	//模糊查询的方法
	public PageData queryLikeName(String userName) {
		  
		  //sql语句
		 String sql = "select * from 用户表 where userName like "+"'%"+userName+"%'";
		//调用dbutil的getpage方法
			List<User> list = (List<User>) dbUtil.Select(sql, User.class);
			PageData pageData = new PageData(list,1,list.size(),list.size());
			return pageData;
				  
	}
	
	public List<String> checkLogin(String email, String pwd) {
		String sql = "select * from 用户表 where email = ? and userPwd = ?";
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
	
	//添加
		public boolean addUser(User user) {
			//编写sql 语句  insert into 用户表 VALUES(null,"深度学习",1)
			String sql  = "insert into 用户表 values(null,?,?,?,?,?)";
			//初始化一个result变量
				int result =  0;
				//参数  名称  
				result  = dbUtil.update(sql, user.getUserName(),user.getUserPwd(),user.getAvatarName(),user.getEmail(),user.getAccountStatus());		
				return result>0;
					
			}
		
		public boolean updateUser(User user) {
			//编写sql语句
			String sql  = "update 用户表 set userName = ? ,userPwd= ? ,avatarName= ? , email= ? where userID= ? ";
			//初始化一个result变量
			int result =  0;
			result= dbUtil.update(sql, user.getUserName(),user.getUserPwd(),user.getAvatarName(),user.getEmail(),user.getUserID()
					);//参数顺序
			return result>0;
			
		}
}
