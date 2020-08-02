package com.hqu.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

//import javax.sql.rowset.CachedRowSet;
//
//import com.sun.rowset.*;


/*JDBC
 ��1��ע��������
��2����������(Connection)�� 
��3���������ݿ������������ִ��SQL����䡣
��4��ִ����䡣
��5������ִ�н��(ResultSet)�� 
��6���ͷ���Դ��
*/
public class DBUtil {
//1.ע�������������
 public static final String DRIVER="com.mysql.jdbc.Driver";
 
 public static final String URL="jdbc:mysql://localhost:3306/t_book?characterEncoding=UTF-8";
 public static final String USER="root";
 public static final String PASSWORD="jh2000";
 
//2��������
 public Connection getCon() {
  Connection con=null;
  try{
   Class.forName(DRIVER);
   con=DriverManager.getConnection(URL,USER,PASSWORD);
   System.out.println("���ݿ����ӳɹ���");
  }catch(Exception e) {
   e.printStackTrace();
  }
  return con;
 }
 
 //��ѯ����
 	public CachedRowSet Query(String sql, Object ...param) {
 		//�������ݿ�
 		Connection con = getCon();
 		//����Connection����
 		PreparedStatement ps = null;
 		
 		ResultSet rs = null;
 		
 		CachedRowSet crs = null;
 		
 		try {
			//ʵ����prepareStatement
 			ps = con.prepareStatement(sql);
 			//forѭ������sql����
 			for (int i = 0; i < param.length; i++) {
 				//����sql����
				ps.setObject(i+1, param[i]);
			}
 			//���ò�ѯ������������ֵ��ֵ��rs
 			rs = ps.executeQuery();
 			//ʵ����CachedRowSet���漯
 			crs = new CachedRowSetImpl();
 			//��rs��crs�����
 			crs.populate(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return crs;
		
	}
 
 
}