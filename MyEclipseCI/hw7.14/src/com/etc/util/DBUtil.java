package com.etc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;


public class DBUtil {
	//ע���������
	private static String DRIVER = "com.mysql.jdbc.Driver";
	
	private static String url = "jdbc:mysql://localhost:3306/booktest?characterEncoding=UTF-8";
	private static String user = "root";
	private static String password = "jh2000";
	
	//��װ����
	public Connection getConnect() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			//��ȡ����
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("���ݿ����ӳɹ���");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	
	//��װ�ر���Դ
	public void closeResource(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void closeResource(Connection conn, PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//��װ��ɾ��ͨ�ò���
	public void update(String sql, Object ...param) {
		//1.��ȡ����
		Connection conn = getConnect();
		PreparedStatement ps = null;
		try {
			//2.Ԥ����sql��䣬����prepareStatementʵ��
			ps = conn.prepareStatement(sql);
			//3.ѭ����������sql
			for (int i = 0; i < param.length; i++) {
				ps.setObject(i+1, param[i]);
			}
			//4.ִ��
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5.��Դ�ر�
			closeResource(conn, ps);
		}
	}
	
	
	//��װ��ѯͨ�ò���
	public  CachedRowSet query(String sql, Object ...param) {
		//1.��ȡ����
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		CachedRowSet crs = null;
		try {
			//2.Ԥ����sql��䣬����prepareStatementʵ��
			ps = conn.prepareStatement(sql);
			//3.forѭ������sql����
			for (int i = 0; i < param.length; i++) {
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
		}finally {
			closeResource(conn, ps, rs);
		}
		
		return crs;
	}
}
