package com.etc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.etc.entity.Book;
import com.etc.entity.BookType;
import com.etc.util.DBUtil;

public class BookDao {
  //创建一个查询图书编号、图书名称、类型名称信息得方法
	DBUtil dbutil=new DBUtil();
 public List<Book> queryAllBookAndType(){
  
  List<Book> list =new ArrayList<Book>();
  
  //sql语句
  String sql = "select book.bid,book.bookname,booktype.typename from book,booktype" + 
  		" where book.typeid = booktype.typeid order by book.bid asc" ;
  
  CachedRowSet crs = dbutil.Query(sql);
	//读取crs中的数据
  
  try {
	while (crs.next()) {
		int bid = crs.getInt("bid");
		String bookname = crs.getString("bookname");
		//创建图书信息
		Book book = new Book(bid, bookname);
		String typename = crs.getString("typename");
		//将图书类型名称加入到book中
		//创建一个图书类型对象
		BookType bt = new BookType();
		bt.setTypename(typename);
		book.setBt(bt);
		//将图书添加到列表
		list.add(book);
	}
} catch (Exception e) {
	e.printStackTrace();
}
  return list;
  
 }
 
 
 	public boolean deleteBook(String bid) {
 		
 		String sql = "delete from book where bid = ?";
 		int result = dbutil.update(sql, bid);
 		//判断是否删除成功
		return result>0;
		
	}
 	
public boolean addBook(Book book) {
 		
 		String sql = "insert into book values(?,?,?)";
 		int result = dbutil.update(sql,null,book.getBookname(),book.getBt().getTypename());
 		//判断是否添加成功
		return result>0;
		
	}

public Book queryById(int id) {
	Book book = null;
	String sql = "select * from book where bid = ?";
	CachedRowSet crs = dbutil.Query(sql, id);
	System.out.println("crs长度"+crs.size());
	try {
		if (crs.next()) {
			//获取图书信息
			int bid = crs.getInt("bid");
			String bookname = crs.getString("bookname");
			int typeid = crs.getInt("typeid");
			BookType bt = new BookType();
			bt.setTypeid(typeid);
			book = new Book(bid,bookname,bt);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return book;
	
}

public boolean updateInfo(Book book) {
	int result = 0;
	String sql = "update book set bookname = ?, typeid =? where bid = ?";
	result = dbutil.update(sql, book.getBookname(),book.getBt().getTypeid(),book.getBid());
	return result>0;
	
}

//创建模糊查询的方法
public List<Book> queryBookLikeName(String bookname) {
		List<Book> list =new ArrayList<Book>();
	  
	  //sql语句
	  String sql = "select book.bid,book.bookname,booktype.typename from book,booktype" + 
	  		" where book.typeid = booktype.typeid and book.bookname like ? order by book.bid asc" ;
	  CachedRowSet crs = dbutil.Query(sql, "%"+bookname+"%");
	  

			  try {
				while (crs.next()) {
					int bid = crs.getInt("bid");
					String name = crs.getString("bookname");
					//创建图书信息
					Book book = new Book(bid, name);
					String typename = crs.getString("typename");
					//将图书类型名称加入到book中
					//创建一个图书类型对象
					BookType bt = new BookType();
					bt.setTypename(typename);
					book.setBt(bt);
					//将图书添加到列表
					list.add(book);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			  return list;
			  
}
}