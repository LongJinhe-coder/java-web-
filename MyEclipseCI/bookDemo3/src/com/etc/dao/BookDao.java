package com.etc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.etc.entity.Book;
import com.etc.entity.BookType;
import com.etc.util.DBUtil;

public class BookDao {
  //����һ����ѯͼ���š�ͼ�����ơ�����������Ϣ�÷���
	DBUtil dbutil=new DBUtil();
 public List<Book> queryAllBookAndType(){
  
  List<Book> list =new ArrayList<Book>();
  
  //sql���
  String sql = "select book.bid,book.bookname,booktype.typename from book,booktype" + 
  		" where book.typeid = booktype.typeid";
  
  CachedRowSet crs = dbutil.Query(sql);
	//��ȡcrs�е�����
  
  try {
	while (crs.next()) {
		int bid = crs.getInt("bid");
		String bookname = crs.getString("bookname");
		//����ͼ����Ϣ
		Book book = new Book(bid, bookname);
		String typename = crs.getString("typename");
		//��ͼ���������Ƽ��뵽book��
		//����һ��ͼ�����Ͷ���
		BookType bt = new BookType();
		bt.setTypename(typename);
		book.setBt(bt);
		//��ͼ����ӵ��б�
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
 		//�ж��Ƿ�ɾ���ɹ�
		return result>0;
		
	}
 	
public boolean addBook(Book book) {
 		
 		String sql = "insert into book values(?,?,?)";
 		int result = dbutil.update(sql,null,book.getBookname(),book.getBt().getTypename());
 		//�ж��Ƿ���ӳɹ�
		return result>0;
		
	}
}