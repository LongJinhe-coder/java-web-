package com.etc.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.etc.entity.Advert;
import com.etc.entity.PageData;
import com.etc.entity.RecruitmentInformation;
import com.etc.util.DBUtil;

public class AdvertDao {
	DBUtil dbutil=new DBUtil();
  public List<Advert> queryAllAdvert(int firmID){
	  
	  String sql = "select * from 广告表 where firmID=?";
		List<Advert> list = (List<Advert>)dbutil.Select(sql, Advert.class,firmID);
		System.out.println("广告表长度="+list.size());
	
	   return list;
  }
  
  public PageData queryByPage(int pageNo,int pageSize,int firmID) {
		
		String sql = "select *from 广告表 where firmID=?";
		
		//调用dbutil的getpage方法
		PageData pageData = dbutil.getpage(sql, pageNo, pageSize, Advert.class,firmID);
		return pageData;
		
	}
  
  public PageData queryLikeName(int firmID,int advertID) {
		
		String sql = "select *from 广告表 where firmID=? and advertID = ?";
		
		
		//调用dbutil的getpage方法
			List<Advert> list = (List<Advert>)dbutil.Select(sql, Advert.class,firmID,advertID);
			PageData pageData = new PageData(list,1,list.size(),list.size());
			return pageData;
		
}

//删除广告
	public boolean deleteAdvert(int firmID,int AdvertID) {
		int result = 0;
		String sql = "delete from 广告表 where firmID = ? and advertID= ?";
		result = dbutil.update(sql,firmID,AdvertID);
		return result>0;
		
	}
	
	public String getAdvertName(int AdvertID) {
		
		String sql = "SELECT * from 广告表 WHERE advertID=?";
		List<Advert> list =(List<Advert>) dbutil.Select(sql, Advert.class, AdvertID);
		System.out.println("List size===============>"+list.size());
		
		Advert ad=new Advert();
		ad=list.get(0);
		return ad.getAdvertName();
	}
  
  //拿到广告发布的公司名称
  public String getFirmName(int firmID) {
	  
	  String sql = "select *from 企业表 where firmID=?";
	  CachedRowSet crs = dbutil.Query(sql, firmID);
	  try {
		if (crs.next()) {
			String firmName = crs.getString("firmName");
			return firmName;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
}
  
  //管理员查看所有的广告(根据广告审核状态)
  public PageData queryAllByPage(int pageNo,int pageSize,String checkStatus) {
		
		String sql = "select *from 广告表 where checkStatus=?";
		
		//调用dbutil的getpage方法
		PageData pageData = dbutil.getpage(sql, pageNo, pageSize, Advert.class,checkStatus);
		return pageData;
		
	}
  
  public PageData queryLikeNameAdmin(int advertID,String checkStatus) {
		
		String sql = "select *from 广告表 where advertID = ? and checkStatus = ?";
		
		//调用dbutil的getpage方法
			List<Advert> list = (List<Advert>)dbutil.Select(sql, Advert.class,advertID,checkStatus);
			PageData pageData = new PageData(list,1,list.size(),list.size());
			return pageData;
		
}
  
  //改变广告审核状态
  public boolean changeCheckStatus(int advertID,String changedStatus) {
	  String sql = "update 广告表 set checkStatus = ? where advertID = ?";
	  int result = 0;
	  result = dbutil.update(sql, changedStatus,advertID);
	  
	return result>0;
	
}
  
  //管理员删除广告
  public boolean deleteAdvertAdmin(int advertID) {
	  String sql = "delete from 广告表  where advertID = ?";
	  int result = 0;
	  result = dbutil.update(sql,advertID);
	  
	return result>0;
	
}
  
  //设置adminID
  public boolean setAdminID(int advertID, int adminID) {
	String sql = "update 广告表 set adminID = ? where advertID = ?";
	int result = 0;
	result = dbutil.update(sql, adminID,advertID);
	return result>0;
	
}

}
