package com.etc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.etc.entity.Administrator;
import com.etc.entity.Firm;
import com.etc.entity.PageData;
import com.etc.entity.User;
import com.etc.util.DBUtil;

public class FirmDao {
	DBUtil dbUtil =  new DBUtil();
	public List<String> checkLogin(String email, String pwd) {
		String sql = "select * from 企业表 where firmEmail = ? and firmPwd = ?";
		CachedRowSet crs = dbUtil.Query(sql, email,pwd);
		try {
			if (crs.next()) {
				List<String> list = new ArrayList<String>();
				String firmID = crs.getString("firmID");
				String firmName = crs.getString("firmName");
				String accountSatus = crs.getString("accountStatus");
				String checkStatus = crs.getString("checkStatus");
				list.add(firmName);
				list.add(accountSatus);
				list.add(checkStatus);
				list.add(firmID);
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	//查询所有企业
			public List<Firm> queryAllFirms() {
				String sql = "select * from 企业表";
				List<Firm> list = (List<Firm>)dbUtil.Select(sql, Firm.class);
				System.out.println("企业表长度="+list.size());
				return list;
				
			}
			public boolean addFirm(Firm firm) {
				//编写sql 语句  insert into 用户表 VALUES(null,"深度学习",1)
				String sql  = "insert into 企业表 values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				//初始化一个result变量
					int result =  0;
					//参数  名称  
					result  = dbUtil.update(sql,firm.getAdmin(),firm.getFirmAccount(),firm.getRegisterTime(),firm.getFirmName(),firm.getRegisterArea(),firm.getFirmNature(),firm.getRegisterFund(),firm.getFirmBrief(),firm.getLinkMan(),firm.getLinkPhone(),firm.getFirmArea(),firm.getRegisterNum(),firm.getFirmEmail(),firm.getCheckStatus(),firm.getFirmPwd(),firm.getAccountStatus());		
					return result>0;
						
				}
			
			//修改企业信息
			public boolean updateFirm(Firm firm) {
				
				String sql  ="update 企业表 a SET a.firmAccount=?,a.registerTime=?,a.firmName=?,a.registerArea=?,a.firmNature=?,a.registerFund=?,a.firmBrief=?,a.linkMan=?,a.linkPhone=?,a.firmArea=?,a.registerNum=?,a.firmEmail=?,a.checkStatus=?,a.firmPwd=?,a.accountStatus=? where firmID=?";
				//初始化一个result变量
					int result =  0;
					//参数  名称  
					result  = dbUtil.update(sql,firm.getFirmAccount(),firm.getRegisterTime(),firm.getFirmName(),firm.getRegisterArea(),firm.getFirmNature(),firm.getRegisterFund(),firm.getFirmBrief(),firm.getLinkMan(),firm.getLinkPhone(),firm.getFirmArea(),firm.getRegisterNum(),firm.getFirmEmail(),firm.getCheckStatus(),firm.getFirmPwd(),firm.getAccountStatus(),firm.getFirmID());		
					return result>0;
						
				}
			
			//分页查询
			/*
			 * pageNo 当前页
			 * pageSize 每页多少条记录 
			 */
			public PageData queryByPage(int pageNo,int pageSize) {
				
				String sql = "select * from 企业表 order by checkStatus desc";
				
				//调用dbutil的getpage方法
				PageData pageData = dbUtil.getpage(sql, pageNo, pageSize, Firm.class);
				return pageData;
				
			}
				
			//冻结用户账号
			public boolean freezingAccount(int firmID) {
				int result = 0;
				String status = "冻结中";
				String sql = "update 企业表 set accountStatus = ? where firmID = ?";
				result = dbUtil.update(sql,status,firmID);
				return result>0;
				
			}
			
			//冻结用户账号
				public boolean removeFreezing(int firmID) {
					int result = 0;
					String status = "正常";
					String sql = "update 企业表 set accountStatus = ? where firmID = ?";
					result = dbUtil.update(sql,status,firmID);
					return result>0;
					
				}

			//删除用户账号
			public boolean deleteAccount(int firmID) {
				int result = 0;
				String sql = "delete from 企业表 where firmID = ?";
				result = dbUtil.update(sql,firmID);
				return result>0;
				
			}
			
			//模糊查询的方法
			public PageData queryLikeName(String firmName) {
				  
				  //sql语句
				 String sql = "select * from 企业表 where firmName like "+"'%"+firmName+"%'";
				//调用dbutil的getpage方法
					List<Firm> list = (List<Firm>) dbUtil.Select(sql, Firm.class);
					PageData pageData = new PageData(list,1,list.size(),list.size());
					return pageData;
						  
			}
			
			//根据firmID查询
			public Firm queryByID(int firmID) {
				String sql = "select * from 企业表 where firmID = ?";
				List<Firm> list = (List<Firm>)dbUtil.Select(sql, Firm.class,firmID);
				Firm firm = list.get(0);
				return firm;
				
			}
			
			//改变企业审核状态
			public boolean changeCheckStatus(int firmID, String status) {
				int result = 0;
				String sql = "update 企业表 set checkStatus = ? where firmID = ?";
				result = dbUtil.update(sql,status,firmID);
				return result>0;
				
			}
			
			public boolean setAdminID(int firmID,int adminID) {

				String sql = "update 企业表 set admin = ? where firmID = ?";
				int result = 0;
				result = dbUtil.update(sql, adminID,firmID);
				return result>0;
			}
			
}
