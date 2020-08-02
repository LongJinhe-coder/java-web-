package com.hqu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.hqu.bookDemo.Book;
import com.hqu.util.DBUtil;

public class BookDao {
//	图书查询
	public List<Book> queryAllBook() {
		//创建列表对象
		List<Book> list =new ArrayList<Book>();
		//实例化三本图书
		Book book1 = new Book(1001, "java开发程序");
		Book book2 = new Book(1002, "人工智能");
		Book book3 = new Book(1003, "javaweb开发");
		//将图书添加到lsit列表中
		
		list.add(book1);
		list.add(book2);
		list.add(book3);
		
		return list;
	}
	
	public List<Book> queryMybook() {
		//创建列表对象
		List<Book> list =new ArrayList<Book>();
		//实例化DBUtil对象
		DBUtil dbutil = new DBUtil();
		//调用DBUtil 的query()查询方法
		String sql = "select * from mybook";
		CachedRowSet crs = dbutil.Query(sql);
		//读取crs中的数据
		try {
			while (crs.next()) {//如果存在下一行返回true,否则返回false
				int bookid = crs.getInt("bookid");//列名称,获取图书编号
				String bookname = crs.getString("bookname");//获取图书名称
				//创建图书信息
				Book book = new Book(bookid, bookname);
				//将图书添加到列表
				list.add(book);
				
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
}
