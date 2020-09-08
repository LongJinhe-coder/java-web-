package com.etc.test;


import java.util.List;

import com.etc.entity.User;
import com.etc.dao.UserDao;
import com.etc.util.DBUtil;

public class Test2 {

	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		List<User> list = userDao.userQuery();
		for (User user : list) {
			System.out.println(user);
		}
		
		userDao.update();
		System.out.println("更新成功");
		List<User> list2 = userDao.userQuery();
		for (User user : list2) {
			System.out.println(user);
		}
	}
}
