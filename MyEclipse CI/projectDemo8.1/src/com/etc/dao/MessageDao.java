package com.etc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.etc.entity.Message;
import com.etc.util.DBUtil;

public class MessageDao {
	DBUtil dbutil = new DBUtil();
	public List<Message> queryAllMessages(int userInfoID) {
		String sql = "select userInfoID,��Ƹ��Ϣ��.recruitmentID,firmName,linkPhone,handleStatus,message from ��Ƹ��Ϣ��,\r\n" + 
				"��ҵ��,ӦƸ��\r\n" + 
				"where ӦƸ��.recruitmentID=��Ƹ��Ϣ��.recruitmentID  AND\r\n" + 
				"\r\n" + 
				"��Ƹ��Ϣ��.firmID=��ҵ��.firmID and userInfoID=?";
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
		
		String sql  = "delete from ӦƸ��  where recruitmentID = ?";  
		
		int result  = dbutil.update(sql, recruitmentID);
		return result>0;
		
	}
}
