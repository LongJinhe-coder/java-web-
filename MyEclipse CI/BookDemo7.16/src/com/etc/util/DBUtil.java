package com.etc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class DBUtil {
    //1.加载并注册驱动程序
 public static final String DRIVER="com.mysql.jdbc.Driver";
 //URL USER PASSWORD
 public static final String URL="jdbc:mysql://localhost:3306/booktest?characterEncoding=UTF-8";
 public static final String USER="root";
 public static final String PASSWORD="jh2000";
    
 //2.创建一个Connection getCon（）方法
 public Connection getCon() {
  //创建Connection对象
  Connection con=null;
  try {
     Class.forName(DRIVER);
     con=DriverManager.getConnection(URL, USER, PASSWORD);
     System.out.println("数据库连接成功");
  }catch(Exception e) {
   e.printStackTrace();
  }
  return con;
  
 }
 
 //查询功能
 
 public CachedRowSet Query(String sql,Object ...param) {
  //连接数据库
  //创建Connectiond对象
  Connection conn=getCon();
  
  //创建PreparedStatement
  PreparedStatement ps=null;
  //创建Result对象
  ResultSet rs=null;
  //CachedRowSet缓存集
  CachedRowSet crs=null;
  
  try {
   //实例化PreparedStatement
   ps=conn.prepareStatement(sql);
   //for循环遍历sql得参数
   for(int i=0;i<param.length;i++) {
    ps.setObject(i+1,param[i]);
   }
   rs=ps.executeQuery();
   
   //实例化缓存集
   crs=new CachedRowSetImpl();
   crs.populate(rs);
  }catch(Exception e) {

   e.printStackTrace();
  }
  
  
  
  return crs;
  
 }
 
 public int update(String sql, Object ...param) {
		//1.获取连接
		Connection conn = getCon();
		PreparedStatement ps = null;
		int result = 0;
		try {
			//2.预编译sql语句，返回prepareStatement实例
			ps = conn.prepareStatement(sql);
			//3.循环遍历补充sql
			for (int i = 0; i < param.length; i++) {
				ps.setObject(i+1, param[i]);
			}
			//4.执行
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5.资源关闭
//			closeResource(conn, ps);
		}
		return result;
	}
}