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
  		" where book.typeid = booktype.typeid order by book.bid asc" ;
  
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

public Book queryById(int id) {
	Book book = null;
	String sql = "select * from book where bid = ?";
	CachedRowSet crs = dbutil.Query(sql, id);
	System.out.println("crs����"+crs.size());
	try {
		if (crs.next()) {
			//��ȡͼ����Ϣ
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

//����ģ����ѯ�ķ���
public List<Book> queryBookLikeName(String bookname) {
		List<Book> list =new ArrayList<Book>();
	  
	  //sql���
	  String sql = "select book.bid,book.bookname,booktype.typename from book,booktype" + 
	  		" where book.typeid = booktype.typeid and book.bookname like ? order by book.bid asc" ;
	  CachedRowSet crs = dbutil.Query(sql, "%"+bookname+"%");
	  

			  try {
				while (crs.next()) {
					int bid = crs.getInt("bid");
					String name = crs.getString("bookname");
					//����ͼ����Ϣ
					Book book = new Book(bid, name);
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
}