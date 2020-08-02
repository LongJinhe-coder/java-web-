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
    //1.���ز�ע����������
 public static final String DRIVER="com.mysql.jdbc.Driver";
 //URL USER PASSWORD
 public static final String URL="jdbc:mysql://localhost:3306/booktest?characterEncoding=UTF-8";
 public static final String USER="root";
 public static final String PASSWORD="jh2000";
    
 //2.����һ��Connection getCon��������
 public static Connection getCon() {
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
 
 public static CachedRowSet Query(String sql,Object ...param) {
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
 
 
 //����һ����ҳ��ѯ����select
 /*
  * Class java����
  */
 	public static Object Select(String sql,Class cla,Object ...param) {
 		
 		   CachedRowSet crs = Query(sql,param);
 		   
 		//����һ���б����
  		  List<Object> list = new ArrayList<Object>();
 		   //����java�������
 		   //1.��ȡ��Ա����
 		   Field[] fs = cla.getDeclaredFields();
// 		  System.out.println("fs��"+fs);
 		   Object obj = null;
 		   try {
			while (crs.next()) {
				//2.��ȡ����ʵ��
				  obj = cla.newInstance();
				//3.forѭ������ÿ������
				 for (Field field : fs) {
					//4.�����������Ե�Ȩ��
					 field.setAccessible(true);
					 //5.��ȡ��������
					 String key = field.getName();
//					 System.out.println("fs��������"+key);
					 //6.��ȡ����ֵ
					 Object val = crs.getObject(key);
//					 System.out.println("crs����ֵ��"+val);
					 //7.Ϊÿ�����Ը�ֵ
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
 		//��ѯ���ݿ��ܼ�¼��
 		String selsql = "select count(*) from ("+sql+") t";
 		Integer totalCount = getCount(selsql, param);
 		
 		//��ȡ�б�����
 		//�õ���ʼλ�� 0,3 3,3 6,3
 		int start = (pageNo-1)*pageSize;
 		//��ҳ��ѯ��sql���
 		String limitsql = sql + " limit " + start + "," + pageSize;
 		List list = (List)Select(limitsql, cla, param);
 		//ʵ����pageData����
 		PageData pageData = new PageData(list, pageNo, pageSize, totalCount);
 		
 		return pageData;
		
	}
 	
 	//������ѯ���ݵ��ܼ�¼��
 	public static int getCount(String sql,Object ...param) {
 		
 		CachedRowSet crs = Query(sql, param);
 		   
 		   try {
			if (crs.next()) {
				return crs.getInt(1);//������1��ʼ
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		  
		return 0;
		
	}
 
 
}