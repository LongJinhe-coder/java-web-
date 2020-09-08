package com.etc.test;

import java.util.List;

import com.etc.entity.User;
import com.etc.util.DBUtil;

public class Test02 {
	public static void main(String[] args) {
		String userName = "Áú";
		 String sql = "select * from ÓÃ»§±í where userName like "+"'%"+userName+"%'";
		 System.out.println("sql="+sql);
		 DBUtil dbUtil = new DBUtil();
		 List<User> list = (List<User>) dbUtil.Select(sql, User.class);
		 System.out.println(list);
	}
}
