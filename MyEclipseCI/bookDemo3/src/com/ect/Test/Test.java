package com.ect.Test;

import java.util.List;

//import com.etc.bookDemo3.Book;
import com.etc.dao.BookDao;
import com.etc.entity.Book;

public class Test {
	public static void main(String[] args) {
		
			BookDao bookdao = new BookDao();
			
			List<Book> list =bookdao.queryAllBookAndType();
//			List<Book> list =bookdao.queryMybook();
			
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
