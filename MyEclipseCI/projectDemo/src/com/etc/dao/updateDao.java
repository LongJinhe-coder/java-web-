package com.etc.dao;

import com.etc.util.DBUtil;

public class updateDao {
	DBUtil dbu = new DBUtil();
	public boolean insertFirmPhoto(int firmID,String photoName,String photoType) {
		String sql = "insert into 企业照片表(photoName,photoType,firmID) VALUE(?,?,?)";
		int flag =dbu.update(sql,photoName,photoType,firmID);
		return flag>0;
	}
	
	public boolean insertFirmAd(int firmID,String advertName,String launchTime) {
		String sql = "insert into 广告表(adminID,advertName,launchTime,checkStatus,firmID) VALUE(111,?,?,'未审核',?)";
		int flag =dbu.update(sql,advertName,launchTime,firmID);
		return flag>0;
	}
}
