package com.etc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.sql.rowset.CachedRowSet;

import com.etc.entity.PageData;
import com.sun.rowset.CachedRowSetImpl;
import java.lang.reflect.Field;

public class BaseDBUtil {
    //1.加载并注册驱动程序
 public static final String DRIVER="com.mysql.jdbc.Driver";
 //URL USER PASSWORD
 public static final String URL="jdbc:mysql://localhost:3306/booktest?characterEncoding=UTF-8";
 public static final String USER="root";
 public static final String PASSWORD="jh2000";
    
 //2.创建一个Connection getCon（）方法
 public static Connection getCon() {
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
 
 public static CachedRowSet Query(String sql,Object ...param) {
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
 
 
 //创建一个分页查询方法select
 /*
  * Class java反射
  */
 	public static Object Select(String sql,Class cla,Object ...param) {
 		
 		   CachedRowSet crs = Query(sql,param);
 		   
 		//创建一个列表对象
  		  List<Object> list = new ArrayList<Object>();
 		   //新增java反射机制
 		   //1.获取成员属性
 		   Field[] fs = cla.getDeclaredFields();
// 		  System.out.println("fs："+fs);
 		   Object obj = null;
 		   try {
			while (crs.next()) {
				//2.获取对象实例
				  obj = cla.newInstance();
				//3.for循环遍历每个属性
				 for (Field field : fs) {
					//4.开启访问属性的权限
					 field.setAccessible(true);
					 //5.获取属性名称
					 String key = field.getName();
//					 System.out.println("fs属性名："+key);
					 //6.获取属性值
					 Object val = crs.getObject(key);
//					 System.out.println("crs属性值："+val);
					 //7.为每个属性赋值
					 field.set(obj, val);
					 
				}
				 list.add(obj);	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
 		   
 		  return list;
	}
 
 	
 	public static PageData getpage(String sql,Integer pageNo, Integer pageSize,Class cla,Object ...param) {
		//select * from tbl_book;
 		//select count(*) from (select * from tbl_book) t
 		//查询数据库总记录数
 		String selsql = "select count(*) from ("+sql+") t";
 		Integer totalCount = getCount(selsql, param);
 		
 		//获取列表数据
 		//得到起始位置 0,3 3,3 6,3
 		int start = (pageNo-1)*pageSize;
 		//分页查询的sql语句
 		String limitsql = sql + " limit " + start + "," + pageSize;
 		List list = (List)Select(limitsql, cla, param);
 		//实例化pageData对象
 		PageData pageData = new PageData(list, pageNo, pageSize, totalCount);
 		
 		return pageData;
		
	}
 	
 	//创建查询数据的总记录数
 	public static int getCount(String sql,Object ...param) {
 		
 		CachedRowSet crs = Query(sql, param);
 		   
 		   try {
			if (crs.next()) {
				return crs.getInt(1);//索引从1开始
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		  
		return 0;
		
	}
 
 
}