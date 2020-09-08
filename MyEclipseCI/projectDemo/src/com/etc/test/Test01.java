package com.etc.test;

import java.util.List;

import com.etc.dao.UserDao;
import com.etc.entity.PageData;
import com.etc.entity.User;

public class Test01 {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		//List<User> list = (List<User>)userDao.queryAllUsers();
		PageData pageData = userDao.queryByPage(1, 3);
		System.out.println("pageData="+pageData);
//		for (User user : (User)pageData.getData()) {
//			System.out.println(user);
//		}
	}
}
