package com.etc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.etc.entity.Firm;
import com.etc.entity.PageData;
import com.etc.entity.Position;
import com.etc.entity.Recruitment;
import com.etc.entity.RecruitmentInformation;
import com.etc.entity.User;
import com.etc.util.DBUtil;

public class RecruitDao {

	DBUtil dbutil=new DBUtil();

	//查询详细的招聘信息
		public RecruitmentInformation queryRecruitmentInfoById(int recruitmentID) {
			String sql = "select * from 招聘信息表 where recruitmentID="+recruitmentID;
			List<RecruitmentInformation> list = (List<RecruitmentInformation>)dbutil.Select(sql, RecruitmentInformation.class);
			System.out.println("招聘信息表长度------------->"+list.size());
			return list.get(0);
			
		}
	
	//分页查询
	/*
	 * pageNo 当前页
	 * pageSize 每页多少条记录 
	 */
		public PageData queryByPage(int pageNo,int pageSize,int firmID) {
			
			String sql = "select a.recruitmentID,a.firmID,a.positionID ,a.adminID,a.positionDescribe,a.salary,a.dueDate,a.checkStatus,a.count,a.age,b.positionName,b.positionType  FROM 招聘信息表 a,职位表 b WHERE a.positionID=b.positionID and firmID=?";
			
			//调用dbutil的getpage方法
			PageData pageData = dbutil.getpage(sql, pageNo, pageSize, RecruitmentInformation.class,firmID);
			return pageData;
			
		}
   public PageData queryByPageAdmin(int pageNo,int pageSize,String checkStatus) {
		
		String sql = "select a.recruitmentID,a.firmID,a.positionID ,a.adminID,a.positionDescribe,a.salary,a.dueDate,a.checkStatus,a.count,a.age,b.positionName,b.positionType  FROM 招聘信息表 a,职位表 b WHERE a.positionID=b.positionID and a.checkStatus = ?";
		
		//调用dbutil的getpage方法
		PageData pageData = dbutil.getpage(sql, pageNo, pageSize, RecruitmentInformation.class,checkStatus);
		return pageData;
		
	}
		
	
   //删除应聘信息/删除简历
 	public boolean deleteResumeInfo(int userInfoID) {
 		int result = 0;
 		String sql = "delete from 应聘表 where userInfoID = ?";
 		result = dbutil.update(sql,userInfoID);
 		return result>0;
 		
 	}

	//撤回招聘信息
	public boolean deleteRecruitmentInfo(int recruitmentID) {
		int result = 0;
		String sql = "delete from 招聘信息表 where recruitmentID = ?";
		result = dbutil.update(sql,recruitmentID);
		return result>0;
		
	}
	
	//模糊查询招聘信息
		public PageData queryLikeName(String positionName,int firmID) {
			List<Integer> positionIDList=getPositionID(positionName);
			  //System.out.println("positionID="+positionID);
			if (positionIDList.isEmpty()) {
				List<RecruitmentInformation> list = new ArrayList<RecruitmentInformation>();
				PageData pageData = new PageData(list,1,list.size(),list.size());
				return pageData;
			}
			List<RecruitmentInformation> allList = new ArrayList<RecruitmentInformation>();
			for (Integer positionID : positionIDList) {
				 String sql = "select a.recruitmentID,a.firmID,a.positionID,a.adminID,a.positionDescribe,a.salary,a.dueDate,a.checkStatus,a.count,a.age,b.positionName,b.positionType  FROM 招聘信息表 a,职位表 b WHERE a.positionID=b.positionID and a.positionID like "+"'%"+positionID+"%' and a.firmID=?";
					//调用dbutil的getpage方法
						List<RecruitmentInformation> list = (List<RecruitmentInformation>)dbutil.Select(sql, RecruitmentInformation.class,firmID);
						for (RecruitmentInformation recruitmentInformation : list) {
							allList.add(recruitmentInformation);
						}
			}
			PageData pageData = new PageData(allList,1,allList.size(),allList.size());
			return pageData;
					  
		}
		
		//模糊查询应聘信息
		public PageData queryLikeID(int userInfoID) {
			  //sql语句
			 String sql = "select * from 应聘表 where userInfoID="+userInfoID;
			//调用dbutil的getpage方法
				List<Recruitment> list = (List<Recruitment>)dbutil.Select(sql, Recruitment.class);
				PageData pageData = new PageData(list,1,list.size(),list.size());
				return pageData;
					  
		}
		
		
		//应聘信息的分页查询
		  public PageData queryByPage2(int pageNo,int pageSize) {
				
				String sql ="select *from 应聘表";
				
				//调用dbutil的getpage方法
				PageData pageData = dbutil.getpage(sql, pageNo, pageSize, Recruitment.class);
				return pageData;
				
			}
	
	
	public PageData queryLikeNameAdmin(String positionName,String checkStatus) {
		List<Integer> positionIDList = getPositionID(positionName);
		  //System.out.println("positionID="+positionID);
		  //sql语句
		if (positionIDList.isEmpty()) {
			List<RecruitmentInformation> list = new ArrayList<RecruitmentInformation>();
			PageData pageData = new PageData(list,1,list.size(),list.size());
			return pageData;
		}
		List<RecruitmentInformation> allList = new ArrayList<RecruitmentInformation>();
		for (Integer positionID : positionIDList) {
			 String sql = "select a.recruitmentID,a.firmID,a.positionID,a.adminID,a.positionDescribe,a.salary,a.dueDate,a.checkStatus,a.count,a.age,b.positionName,b.positionType  FROM 招聘信息表 a,职位表 b WHERE a.positionID=b.positionID and a.positionID = ? and a.checkStatus = ?";
				//调用dbutil的getpage方法
					List<RecruitmentInformation> list = (List<RecruitmentInformation>)dbutil.Select(sql, RecruitmentInformation.class,positionID,checkStatus);
					for (RecruitmentInformation recruitmentInformation : list) {
						allList.add(recruitmentInformation);
					}
		}
		PageData pageData = new PageData(allList,1,allList.size(),allList.size());
		return pageData;
				  
	}
	
	//通过职位编号获取职位名
	public String getPositionName(int positionID) {
		String sql="select *from 职位表 where positionID="+positionID+"";
		List<Position> list=(List<Position>)dbutil.Select(sql, Position.class);
		System.out.println("size="+list.size());
		String positionName=list.get(0).getPositionName();
		//System.out.println("positionName="+positionName);
		return positionName;
	}
	
	
	
	//通过职位名获取职位编号（模糊查询）
		public List<Integer> getPositionID(String positionName) {
			String sql="select *from 职位表 where positionName like"+"'%"+positionName+"%'";
			List<Position> list=(List<Position>)dbutil.Select(sql, Position.class);
			List<Integer> positionID = new ArrayList<Integer>();
			if (list.isEmpty()) {
				return positionID;
			}
			for (Position position : list) {
				positionID.add(position.getPositionID());
			}
			//System.out.println("positionID="+positionID);
			//System.out.println("list.size()="+list.size());
			return positionID;
		}
	
	//添加招聘信息
	public boolean addRecruit(RecruitmentInformation ri){
		String sql="insert into 招聘信息表 values(?,?,?,?,?,?,?,?,?,?)";//？参数
		//初始化
		int result=0;
 
		result=dbutil.update(sql,ri.getRecruitmentID(),ri.getFirmID().getFirmID(),ri.getPositionID().getPositionID(),ri.getAdminID().getAdminID(),
				ri.getPositionDescribe(),ri.getSalary(),ri.getDueDate(),ri.getCheckStatus(),ri.getCount(),ri.getAge());
			return result>0;
	}
	
	//
	public RecruitmentInformation queryByID(int recruitmentID) {
		String sql = "select a.recruitmentID,a.firmID,a.positionID,a.adminID,a.positionDescribe,a.salary,a.dueDate,a.checkStatus,a.count,a.age,b.positionName,b.positionType  FROM 招聘信息表 a,职位表 b WHERE a.positionID=b.positionID and a.recruitmentID = ?";
		List<RecruitmentInformation> list = (List<RecruitmentInformation>)dbutil.Select(sql, RecruitmentInformation.class,recruitmentID);
		RecruitmentInformation recruitmentInformation = list.get(0);
		return recruitmentInformation;
		
	}
	
	//改变招聘信息审核状态
	public boolean changeCheckStatus(int recruitmentID, String status) {
		int result = 0;
		String sql = "update 招聘信息表 set checkStatus = ? where recruitmentID = ?";
		result = dbutil.update(sql,status,recruitmentID);
		return result>0;
		
	}
	
	//获取企业联系电话
	public String getFirmPhone(int firmID) {
		String sql = "select linkPhone from 企业表 where firmID = ?";
		CachedRowSet crs = dbutil.Query(sql, firmID);
		try {
			if (crs.next()) {
				String linkPhone = crs.getString("linkPhone");
				return linkPhone;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	//获取企业地址
		public String getFirmArea(int firmID) {
			String sql = "select firmArea from 企业表 where firmID = ?";
			CachedRowSet crs = dbutil.Query(sql, firmID);
			try {
				if (crs.next()) {
					String firmArea = crs.getString("firmArea");
					return firmArea;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
			
		}
		
		//同意应聘
	public boolean accept(int userInfoID) {
		int result = 0;
		String status = "已应聘";
		String sql = "update 应聘表 set handleStatus = ? where userInfoID = ?";
		result = dbutil.update(sql,status,userInfoID);
		return result>0;
		
	}
	
	//拒绝应聘
		public boolean reject(int userInfoID) {
			int result = 0;
			String status = "未应聘";
			String sql = "update 应聘表 set handleStatus = ? where userInfoID = ?";
			result = dbutil.update(sql,status,userInfoID);
			return result>0;
			
		}
		
		//获取招聘企业的名称
		public String getFirmName(int firmID) {
			String sql = "select firmName from 企业表 where firmID = ?";
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
	
	
		public boolean setAdminID(int recruitmentID,int adminID) {

			String sql = "update 招聘信息表 set adminID = ? where recruitmentID = ?";
			int result = 0;
			result = dbutil.update(sql, adminID,recruitmentID);
			return result>0;
		}
		
			
			
}
