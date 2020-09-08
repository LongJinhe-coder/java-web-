package com.etc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;


public class DBUtil {
	//注册加载驱动
	private static String DRIVER = "com.mysql.jdbc.Driver";
	
	private static String url = "jdbc:mysql://localhost:3306/booktest?characterEncoding=UTF-8";
	private static String user = "root";
	private static String password = "jh2000";
	
	//封装连接
	public Connection getConnect() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			//获取链接
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("数据库连接成功。");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	
	//封装关闭资源
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
	
	
	//封装增删改通用操作
	public void update(String sql, Object ...param) {
		//1.获取连接
		Connection conn = getConnect();
		PreparedStatement ps = null;
		try {
			//2.预编译sql语句，返回prepareStatement实例
			ps = conn.prepareStatement(sql);
			//3.循环遍历补充sql
			for (int i = 0; i < param.length; i++) {
				ps.setObject(i+1, param[i]);
			}
			//4.执行
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5.资源关闭
			closeResource(conn, ps);
		}
	}
	
	
	//封装查询通用操作
	public  CachedRowSet query(String sql, Object ...param) {
		//1.获取连接
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		CachedRowSet crs = null;
		try {
			//2.预编译sql语句，返回prepareStatement实例
			ps = conn.prepareStatement(sql);
			//3.for循环补充sql参数
			for (int i = 0; i < param.length; i++) {
				ps.setObject(i+1, param[i]);
			}
			//调用查询方法，将返回值赋值给rs
			rs = ps.executeQuery();
			//实例化CachedRowSet缓存集
 			crs = new CachedRowSetImpl();
 			//将rs与crs相关联
 			crs.populate(rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeResource(conn, ps, rs);
		}
		
		return crs;
	}
}
