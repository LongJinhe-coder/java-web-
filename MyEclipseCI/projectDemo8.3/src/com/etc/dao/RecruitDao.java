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

	//��ѯ��ϸ����Ƹ��Ϣ
		public RecruitmentInformation queryRecruitmentInfoById(int recruitmentID) {
			String sql = "select * from ��Ƹ��Ϣ�� where recruitmentID="+recruitmentID;
			List<RecruitmentInformation> list = (List<RecruitmentInformation>)dbutil.Select(sql, RecruitmentInformation.class);
			System.out.println("��Ƹ��Ϣ������------------->"+list.size());
			return list.get(0);
			
		}
	
	//��ҳ��ѯ
	/*
	 * pageNo ��ǰҳ
	 * pageSize ÿҳ��������¼ 
	 */
	public PageData queryByPage(int pageNo,int pageSize,int firmID) {
			
			String sql = "select a.recruitmentID,a.firmID,a.positionID ,a.adminID,a.positionDescribe,a.salary,a.dueDate,a.checkStatus,a.count,a.age,b.positionName,b.positionType  FROM ��Ƹ��Ϣ�� a,ְλ�� b WHERE a.positionID=b.positionID and firmID=?";
			
			//����dbutil��getpage����
			PageData pageData = dbutil.getpage(sql, pageNo, pageSize, RecruitmentInformation.class,firmID);
			return pageData;
			
		}
	
   public PageData queryByPageAdmin(int pageNo,int pageSize,String checkStatus) {
		
		String sql = "select a.recruitmentID,a.firmID,a.positionID ,a.adminID,a.positionDescribe,a.salary,a.dueDate,a.checkStatus,a.count,a.age,b.positionName,b.positionType  FROM ��Ƹ��Ϣ�� a,ְλ�� b WHERE a.positionID=b.positionID and a.checkStatus = ?";
		
		//����dbutil��getpage����
		PageData pageData = dbutil.getpage(sql, pageNo, pageSize, RecruitmentInformation.class,checkStatus);
		return pageData;
		
	}
		
	
   //ɾ��ӦƸ��Ϣ/ɾ������
 	public boolean deleteResumeInfo(int userInfoID,int recruitmentID) {
 		int result = 0;
 		String sql = "delete from ӦƸ�� where userInfoID = ? and recruitmentID= ?";
 		result = dbutil.update(sql,userInfoID,recruitmentID);
 		return result>0;
 		
 	}

	//������Ƹ��Ϣ
	public boolean deleteRecruitmentInfo(int recruitmentID) {
		int result = 0;
		String sql = "delete from ��Ƹ��Ϣ�� where recruitmentID = ?";
		result = dbutil.update(sql,recruitmentID);
		return result>0;
		
	}
	
	//ģ����ѯ��Ƹ��Ϣ
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
				 String sql = "select a.recruitmentID,a.firmID,a.positionID,a.adminID,a.positionDescribe,a.salary,a.dueDate,a.checkStatus,a.count,a.age,b.positionName,b.positionType  FROM ��Ƹ��Ϣ�� a,ְλ�� b WHERE a.positionID=b.positionID and a.positionID like "+"'%"+positionID+"%' and a.firmID=?";
					//����dbutil��getpage����
						List<RecruitmentInformation> list = (List<RecruitmentInformation>)dbutil.Select(sql, RecruitmentInformation.class,firmID);
						for (RecruitmentInformation recruitmentInformation : list) {
							allList.add(recruitmentInformation);
						}
			}
			PageData pageData = new PageData(allList,1,allList.size(),allList.size());
			return pageData;
					  
		}
		//ģ����ѯӦƸ��Ϣ
		public PageData queryLikeID(int userInfoID,int firmID) {
			  //sql���
			
			 String sql = "SELECT a.userInfoID,a.recruitmentID,a.handleStatus from ӦƸ�� a,��Ƹ��Ϣ��  b where b.firmID=? and a.recruitmentID=b.recruitmentID and a.userInfoID like '"+userInfoID+"'";
			//����dbutil��getpage����
				List<Recruitment> list = (List<Recruitment>)dbutil.Select(sql, Recruitment.class,firmID);
				PageData pageData = new PageData(list,1,list.size(),list.size());
				return pageData;
					  
		}
		
		
		//ӦƸ��Ϣ�ķ�ҳ��ѯ
		  public PageData queryByPage2(int pageNo,int pageSize,int firmID) {
				
				String sql ="SELECT a.userInfoID,a.recruitmentID,a.handleStatus,c.positionName,b.positionID from ӦƸ�� a,��Ƹ��Ϣ��  b,ְλ�� c where b.firmID=? and a.recruitmentID=b.recruitmentID and b.positionID=c.positionID";
				
				//����dbutil��getpage����
				PageData pageData = dbutil.getpage(sql, pageNo, pageSize, Recruitment.class,firmID);
				return pageData;
				
			}
	
	
	public PageData queryLikeNameAdmin(String positionName,String checkStatus) {
		List<Integer> positionIDList = getPositionID(positionName);
		  //System.out.println("positionID="+positionID);
		  //sql���
		if (positionIDList.isEmpty()) {
			List<RecruitmentInformation> list = new ArrayList<RecruitmentInformation>();
			PageData pageData = new PageData(list,1,list.size(),list.size());
			return pageData;
		}
		List<RecruitmentInformation> allList = new ArrayList<RecruitmentInformation>();
		for (Integer positionID : positionIDList) {
			 String sql = "select a.recruitmentID,a.firmID,a.positionID,a.adminID,a.positionDescribe,a.salary,a.dueDate,a.checkStatus,a.count,a.age,b.positionName,b.positionType  FROM ��Ƹ��Ϣ�� a,ְλ�� b WHERE a.positionID=b.positionID and a.positionID = ? and a.checkStatus = ?";
				//����dbutil��getpage����
					List<RecruitmentInformation> list = (List<RecruitmentInformation>)dbutil.Select(sql, RecruitmentInformation.class,positionID,checkStatus);
					for (RecruitmentInformation recruitmentInformation : list) {
						allList.add(recruitmentInformation);
					}
		}
		PageData pageData = new PageData(allList,1,allList.size(),allList.size());
		return pageData;
				  
	}
	
	//ͨ��ְλ��Ż�ȡְλ��
	public String getPositionName(int positionID) {
		String sql="select *from ְλ�� where positionID="+positionID+"";
		List<Position> list=(List<Position>)dbutil.Select(sql, Position.class);
		System.out.println("size="+list.size());
		String positionName=list.get(0).getPositionName();
		//System.out.println("positionName="+positionName);
		return positionName;
	}
	
	
	
	//ͨ��ְλ����ȡְλ��ţ�ģ����ѯ��
		public List<Integer> getPositionID(String positionName) {
			String sql="select *from ְλ�� where positionName like"+"'%"+positionName+"%'";
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
	
	//������Ƹ��Ϣ
	public boolean addRecruit(RecruitmentInformation ri){
		String sql="insert into ��Ƹ��Ϣ�� values(?,?,?,?,?,?,?,?,?,?)";//������
		//��ʼ��
		int result=0;
 
		result=dbutil.update(sql,ri.getRecruitmentID(),ri.getFirmID().getFirmID(),ri.getPositionID().getPositionID(),ri.getAdminID().getAdminID(),
				ri.getPositionDescribe(),ri.getSalary(),ri.getDueDate(),ri.getCheckStatus(),ri.getCount(),ri.getAge());
			return result>0;
	}
	
	//
	public RecruitmentInformation queryByID(int recruitmentID) {
		String sql = "select a.recruitmentID,a.firmID,a.positionID,a.adminID,a.positionDescribe,a.salary,a.dueDate,a.checkStatus,a.count,a.age,b.positionName,b.positionType  FROM ��Ƹ��Ϣ�� a,ְλ�� b WHERE a.positionID=b.positionID and a.recruitmentID = ?";
		List<RecruitmentInformation> list = (List<RecruitmentInformation>)dbutil.Select(sql, RecruitmentInformation.class,recruitmentID);
		RecruitmentInformation recruitmentInformation = list.get(0);
		return recruitmentInformation;
		
	}
	
	//�ı���Ƹ��Ϣ���״̬
	public boolean changeCheckStatus(int recruitmentID, String status) {
		int result = 0;
		String sql = "update ��Ƹ��Ϣ�� set checkStatus = ? where recruitmentID = ?";
		result = dbutil.update(sql,status,recruitmentID);
		return result>0;
		
	}
	
	//��ȡ��ҵ��ϵ�绰
	public String getFirmPhone(int firmID) {
		String sql = "select linkPhone from ��ҵ�� where firmID = ?";
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
	
	//��ȡ��ҵ��ַ
		public String getFirmArea(int firmID) {
			String sql = "select firmArea from ��ҵ�� where firmID = ?";
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
		

		//ͬ��ӦƸ
				public boolean accept(int userInfoID,int recruitmentID) {
					int result = 0;
					String status = "��ӦƸ";
					String sql = "update ӦƸ�� a,��Ƹ��Ϣ�� b set a.handleStatus = ? where a.userInfoID = ? and a.recruitmentID=?";
					result = dbutil.update(sql,status,userInfoID,recruitmentID);
					return result>0;
					
				}
				
				//�ܾ�ӦƸ
						public boolean reject(int userInfoID,int recruitmentID) {
							int result = 0;
							String status = "δӦƸ";
							String sql = "update ӦƸ�� a,��Ƹ��Ϣ�� b set handleStatus = ? where a.userInfoID = ? and a.recruitmentID=?";
							result = dbutil.update(sql,status,userInfoID,recruitmentID);
							return result>0;
							
						}
		//��ȡ��Ƹ��ҵ������
		public String getFirmName(int firmID) {
			String sql = "select firmName from ��ҵ�� where firmID = ?";
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
		
		//��ѯ��ϸ����Ƹ��Ϣ
		public List<Position> queryAllPosition() {
			String sql = "select * from ְλ�� ";
			List<Position> list = (List<Position>)dbutil.Select(sql, Position.class);
			System.out.println("ְλ������------------->"+list.size());
			return list;
			
		}
		
		public boolean setAdminID(int recruitmentID,int adminID) {

			String sql = "update ��Ƹ��Ϣ�� set adminID = ? where recruitmentID = ?";
			int result = 0;
			result = dbutil.update(sql, adminID,recruitmentID);
			return result>0;
		}
	
			
			
}