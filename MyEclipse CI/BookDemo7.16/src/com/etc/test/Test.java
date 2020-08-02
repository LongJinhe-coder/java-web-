package com.etc.test;

import java.util.List;

import com.etc.dao.BookDao;
import com.etc.entity.Book1;
import com.etc.entity.PageData;

public class Test {
	
	public static void main(String[] args) {
		BookDao bookDao = new BookDao();
//		List<Book1> list = bookDao.queryAllBook();
//		for (Book1 book1 : list) {
//			System.out.println(book1);
//		}
		
		//查询第一页数据
		PageData pageData = bookDao.queryBooksByPage(1, 3);
		//获取图书列表信息
		List<Book1> data = pageData.getData();
		for (Book1 book1 : data) {
			System.out.println(book1);
		}
}
	
}
