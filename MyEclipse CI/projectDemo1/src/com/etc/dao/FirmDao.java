package com.etc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.etc.entity.Firm;
import com.etc.entity.PageData;
import com.etc.entity.User;
import com.etc.util.DBUtil;

public class FirmDao {
	DBUtil dbUtil =  new DBUtil();
	public List<String> checkLogin(String email, String pwd) {
		String sql = "select * from ��ҵ�� where firmEmail = ? and firmPwd = ?";
		CachedRowSet crs = dbUtil.Query(sql, email,pwd);
		try {
			if (crs.next()) {
				List<String> list = new ArrayList<String>();
				String firmName = crs.getString("firmName");
				String accountSatus = crs.getString("accountStatus");
				list.add(firmName);
				list.add(accountSatus);
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	//��ѯ������ҵ
			public List<Firm> queryAllFirms() {
				String sql = "select * from ��ҵ��";
				List<Firm> list = (List<Firm>)dbUtil.Select(sql, Firm.class);
				System.out.println("��ҵ������="+list.size());
				return list;
				
			}
			public boolean addFirm(Firm firm) {
				//��дsql ���  insert into �û��� VALUES(null,"���ѧϰ",1)
				String sql  = "insert into ��ҵ�� values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				//��ʼ��һ��result����
					int result =  0;
					//����  ����  
					result  = dbUtil.update(sql,firm.getAdmin(),firm.getFirmAccount(),firm.getRegisterTime(),firm.getFirmName(),firm.getRegisterArea(),firm.getFirmNature(),firm.getRegisterFund(),firm.getFirmBrief(),firm.getLinkMan(),firm.getLinkPhone(),firm.getFirmArea(),firm.getRegisterNum(),firm.getFirmEmail(),firm.getCheckStatus(),firm.getFirmPwd(),firm.getAccountStatus());		
					return result>0;
						
				}
			
			//��ҳ��ѯ
			/*
			 * pageNo ��ǰҳ
			 * pageSize ÿҳ��������¼ 
			 */
			public PageData queryByPage(int pageNo,int pageSize) {
				
				String sql = "select * from ��ҵ�� order by checkStatus desc";
				
				//����dbutil��getpage����
				PageData pageData = dbUtil.getpage(sql, pageNo, pageSize, Firm.class);
				return pageData;
				
			}
				
			//�����û��˺�
			public boolean freezingAccount(int firmID) {
				int result = 0;
				String status = "������";
				String sql = "update ��ҵ�� set accountStatus = ? where firmID = ?";
				result = dbUtil.update(sql,status,firmID);
				return result>0;
				
			}
			
			//�����û��˺�
				public boolean removeFreezing(int firmID) {
					int result = 0;
					String status = "����";
					String sql = "update ��ҵ�� set accountStatus = ? where firmID = ?";
					result = dbUtil.update(sql,status,firmID);
					return result>0;
					
				}

			//ɾ���û��˺�
			public boolean deleteAccount(int firmID) {
				int result = 0;
				String sql = "delete from ��ҵ�� where firmID = ?";
				result = dbUtil.update(sql,firmID);
				return result>0;
				
			}
			
			//ģ����ѯ�ķ���
			public PageData queryLikeName(String firmName) {
				  
				  //sql���
				 String sql = "select * from ��ҵ�� where firmName like "+"'%"+firmName+"%'";
				//����dbutil��getpage����
					List<Firm> list = (List<Firm>) dbUtil.Select(sql, Firm.class);
					PageData pageData = new PageData(list,1,list.size(),list.size());
					return pageData;
						  
			}
			
			//����firmID��ѯ
			public Firm queryByID(int firmID) {
				String sql = "select * from ��ҵ�� where firmID = ?";
				List<Firm> list = (List<Firm>)dbUtil.Select(sql, Firm.class,firmID);
				Firm firm = list.get(0);
				return firm;
				
			}
			
			//�ı���ҵ���״̬
			public boolean changeCheckStatus(int firmID, String status) {
				int result = 0;
				String sql = "update ��ҵ�� set checkStatus = ? where firmID = ?";
				result = dbUtil.update(sql,status,firmID);
				return result>0;
				
			}
}