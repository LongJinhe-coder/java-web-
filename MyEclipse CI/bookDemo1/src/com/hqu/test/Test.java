package com.hqu.test;

import java.util.List;

import com.hqu.bookDemo.Book;
import com.hqu.dao.BookDao;

public class Test {
	public static void main(String[] args) {
		
			BookDao bookdao = new BookDao();
			
//			List<Book> list =bookdao.queryAllBook();
			List<Book> list =bookdao.queryMybook();
			
			for (Book book : list) {
//				String bookname = book.getBookName();
//				System.out.println("Õº È√˚≥∆"+bookname);
				System.out.println(book);
			}
			for (int i = 0; i < list.size(); i++) {
				Book book = list.get(i);
				System.out.println(list.get(i));
//				System.out.println(book);
			}
	}
}
