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
	  
	  String sql = "select * from ���� where firmID=?";
		List<Advert> list = (List<Advert>)dbutil.Select(sql, Advert.class,firmID);
		System.out.println("������="+list.size());
	
	   return list;
  }
  
  public PageData queryByPage(int pageNo,int pageSize,int firmID) {
		
		String sql = "select *from ���� where firmID=?";
		
		//����dbutil��getpage����
		PageData pageData = dbutil.getpage(sql, pageNo, pageSize, Advert.class,firmID);
		return pageData;
		
	}
  
  public PageData queryLikeName(int firmID,int advertID) {
		
		String sql = "select *from ���� where firmID=? and advertID = ?";
		
		
		//����dbutil��getpage����
			List<Advert> list = (List<Advert>)dbutil.Select(sql, Advert.class,firmID,advertID);
			PageData pageData = new PageData(list,1,list.size(),list.size());
			return pageData;
		
}

//ɾ�����
	public boolean deleteAdvert(int firmID,int AdvertID) {
		int result = 0;
		String sql = "delete from ���� where firmID = ? and advertID= ?";
		result = dbutil.update(sql,firmID,AdvertID);
		return result>0;
		
	}
	
	public String getAdvertName(int AdvertID) {
		
		String sql = "SELECT * from ���� WHERE advertID=?";
		List<Advert> list =(List<Advert>) dbutil.Select(sql, Advert.class, AdvertID);
		System.out.println("List size===============>"+list.size());
		
		Advert ad=new Advert();
		ad=list.get(0);
		return ad.getAdvertName();
	}
  
  //�õ���淢���Ĺ�˾����
  public String getFirmName(int firmID) {
	  
	  String sql = "select *from ��ҵ�� where firmID=?";
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
  
  //����Ա�鿴���еĹ��(���ݹ�����״̬)
  public PageData queryAllByPage(int pageNo,int pageSize,String checkStatus) {
		
		String sql = "select *from ���� where checkStatus=?";
		
		//����dbutil��getpage����
		PageData pageData = dbutil.getpage(sql, pageNo, pageSize, Advert.class,checkStatus);
		return pageData;
		
	}
  
  public PageData queryLikeNameAdmin(int advertID,String checkStatus) {
		
		String sql = "select *from ���� where advertID = ? and checkStatus = ?";
		
		//����dbutil��getpage����
			List<Advert> list = (List<Advert>)dbutil.Select(sql, Advert.class,advertID,checkStatus);
			PageData pageData = new PageData(list,1,list.size(),list.size());
			return pageData;
		
}
  
  //�ı������״̬
  public boolean changeCheckStatus(int advertID,String changedStatus) {
	  String sql = "update ���� set checkStatus = ? where advertID = ?";
	  int result = 0;
	  result = dbutil.update(sql, changedStatus,advertID);
	  
	return result>0;
	
}
  
  //����Աɾ�����
  public boolean deleteAdvertAdmin(int advertID) {
	  String sql = "delete from ����  where advertID = ?";
	  int result = 0;
	  result = dbutil.update(sql,advertID);
	  
	return result>0;
	
}
  
  //����adminID
  public boolean setAdminID(int advertID, int adminID) {
	String sql = "update ���� set adminID = ? where advertID = ?";
	int result = 0;
	result = dbutil.update(sql, adminID,advertID);
	return result>0;
	
}

}
