package com.etc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class DBUtil {
    //1.���ز�ע����������
 public static final String DRIVER="com.mysql.jdbc.Driver";
 //URL USER PASSWORD
 public static final String URL="jdbc:mysql://localhost:3306/booktest?characterEncoding=UTF-8";
 public static final String USER="root";
 public static final String PASSWORD="jh2000";
    
 //2.����һ��Connection getCon��������
 public Connection getCon() {
  //����Connection����
  Connection con=null;
  try {
     Class.forName(DRIVER);
     con=DriverManager.getConnection(URL, USER, PASSWORD);
     System.out.println("���ݿ����ӳɹ�");
  }catch(Exception e) {
   e.printStackTrace();
  }
  return con;
  
 }
 
 //��ѯ����
 
 public CachedRowSet Query(String sql,Object ...param) {
  //�������ݿ�
  //����Connectiond����
  Connection conn=getCon();
  
  //����PreparedStatement
  PreparedStatement ps=null;
  //����Result����
  ResultSet rs=null;
  //CachedRowSet���漯
  CachedRowSet crs=null;
  
  try {
   //ʵ����PreparedStatement
   ps=conn.prepareStatement(sql);
   //forѭ������sql�ò���
   for(int i=0;i<param.length;i++) {
    ps.setObject(i+1,param[i]);
   }
   rs=ps.executeQuery();
   
   //ʵ�������漯
   crs=new CachedRowSetImpl();
   crs.populate(rs);
  }catch(Exception e) {

   e.printStackTrace();
  }
  
  
  
  return crs;
  
 }
 
 public int update(String sql, Object ...param) {
		//1.��ȡ����
		Connection conn = getCon();
		PreparedStatement ps = null;
		int result = 0;
		try {
			//2.Ԥ����sql��䣬����prepareStatementʵ��
			ps = conn.prepareStatement(sql);
			//3.ѭ����������sql
			for (int i = 0; i < param.length; i++) {
				ps.setObject(i+1, param[i]);
			}
			//4.ִ��
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5.��Դ�ر�
//			closeResource(conn, ps);
		}
		return result;
	}
}