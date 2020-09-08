package com.hqu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.hqu.bookDemo.Book;
import com.hqu.util.DBUtil;

public class BookDao {
//	ͼ���ѯ
	public List<Book> queryAllBook() {
		//�����б����
		List<Book> list =new ArrayList<Book>();
		//ʵ��������ͼ��
		Book book1 = new Book(1001, "java��������");
		Book book2 = new Book(1002, "�˹�����");
		Book book3 = new Book(1003, "javaweb����");
		//��ͼ����ӵ�lsit�б���
		
		list.add(book1);
		list.add(book2);
		list.add(book3);
		
		return list;
	}
	
	public List<Book> queryMybook() {
		//�����б����
		List<Book> list =new ArrayList<Book>();
		//ʵ����DBUtil����
		DBUtil dbutil = new DBUtil();
		//����DBUtil ��query()��ѯ����
		String sql = "select * from mybook";
		CachedRowSet crs = dbutil.Query(sql);
		//��ȡcrs�е�����
		try {
			while (crs.next()) {//���������һ�з���true,���򷵻�false
				int bookid = crs.getInt("bookid");//������,��ȡͼ����
				String bookname = crs.getString("bookname");//��ȡͼ������
				//����ͼ����Ϣ
				Book book = new Book(bookid, bookname);
				//��ͼ����ӵ��б�
				list.add(book);
				
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
}
