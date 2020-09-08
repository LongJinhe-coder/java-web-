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
 （1）注册驱动。
（2）建立连接(Connection)。 
（3）创建数据库操作对象用于执行SQL的语句。
（4）执行语句。
（5）处理执行结果(ResultSet)。 
（6）释放资源。
*/
public class DBUtil {
//1.注册加载驱动程序
 public static final String DRIVER="com.mysql.jdbc.Driver";
 
 public static final String URL="jdbc:mysql://localhost:3306/t_book?characterEncoding=UTF-8";
 public static final String USER="root";
 public static final String PASSWORD="jh2000";
 
//2创建方法
 public Connection getCon() {
  Connection con=null;
  try{
   Class.forName(DRIVER);
   con=DriverManager.getConnection(URL,USER,PASSWORD);
   System.out.println("数据库连接成功。");
  }catch(Exception e) {
   e.printStackTrace();
  }
  return con;
 }
 
 //查询方法
 	public CachedRowSet Query(String sql, Object ...param) {
 		//链接数据库
 		Connection con = getCon();
 		//创建Connection对象
 		PreparedStatement ps = null;
 		
 		ResultSet rs = null;
 		
 		CachedRowSet crs = null;
 		
 		try {
			//实例化prepareStatement
 			ps = con.prepareStatement(sql);
 			//for循环遍历sql参数
 			for (int i = 0; i < param.length; i++) {
 				//补充sql参数
				ps.setObject(i+1, param[i]);
			}
 			//调用查询方法，讲返回值赋值给rs
 			rs = ps.executeQuery();
 			//实例化CachedRowSet缓存集
 			crs = new CachedRowSetImpl();
 			//将rs与crs相关联
 			crs.populate(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return crs;
		
	}
 
 
}