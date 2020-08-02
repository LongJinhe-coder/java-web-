package com.etc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.etc.entity.Message;
import com.etc.util.DBUtil;

public class MessageDao {
	DBUtil dbutil = new DBUtil();
	public List<Message> queryAllMessages(int userInfoID) {
		String sql = "select userInfoID,招聘信息表.recruitmentID,firmName,linkPhone,handleStatus,message from 招聘信息表,\r\n" + 
				"企业表,应聘表\r\n" + 
				"where 应聘表.recruitmentID=招聘信息表.recruitmentID  AND\r\n" + 
				"\r\n" + 
				"招聘信息表.firmID=企业表.firmID and userInfoID=?";
		CachedRowSet crs = dbutil.Query(sql,userInfoID);
		Message message = null;
		List<Message> list = new ArrayList<Message>();
		try {
			while (crs.next()) {
				int userinfoid = crs.getInt("userInfoID");
				int recruitmentID = crs.getInt("recruitmentID");
				String firmName = crs.getString("firmName");
				String linkPhone = crs.getString("linkPhone");
				String handleStatus = crs.getString("handleStatus");
				String theMessage = crs.getString("message");
				
				message = new Message(userinfoid,recruitmentID,firmName,linkPhone,handleStatus,theMessage);
				list.add(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean deleteMessage(int recruitmentID) {
		
		String sql  = "delete from 应聘表  where recruitmentID = ?";  
		
		int result  = dbutil.update(sql, recruitmentID);
		return result>0;
		
	}
}
