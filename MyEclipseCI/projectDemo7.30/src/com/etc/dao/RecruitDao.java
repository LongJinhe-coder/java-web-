package com.etc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.etc.entity.Firm;
import com.etc.entity.PageData;
import com.etc.entity.Position;
import com.etc.entity.RecruitmentInformation;
import com.etc.entity.User;
import com.etc.util.DBUtil;

public class RecruitDao {

	DBUtil dbutil=new DBUtil();
	public List<RecruitmentInformation> queryAllRecruitmentAndPositionName(){
		  //1.����һ���б�����
		  List<RecruitmentInformation> list  = new ArrayList<RecruitmentInformation>();

		  //sql���
		  String sql = "select a.recruitmentID,a.firmID,a.positionID ,a.adminID,a.positionDescribe,a.salary,a.dueDate,a.checkStatus,a.count,a.age,b.positionName,b.positionType  FROM ��Ƹ��Ϣ�� a,ְλ�� b WHERE a.positionID=b.positionID";
		  CachedRowSet crs = dbutil.Query(sql);
		  System.out.println("crs�ĳ���"+crs.size());
		  //4.��ȡcrs�е�����
		  try {
		   while(crs.next()) {
		    int  recruitmentID=crs.getInt("recruitmentID");
		    String salary=crs.getString("salary");
		    int count=crs.getInt("count");
		    String age=crs.getString("age");
		    Date dueDate=crs.getDate("dueDate");
		  
		    //��2�ַ���
		    //����һ��ְλ���Ͷ���
		    Position position=new Position();
		    String positionName=crs.getString("positionName");
		    position.setPositionName(positionName);
		    
		    //������Ƹ��Ϣ
		   RecruitmentInformation ri=new RecruitmentInformation();
		   ri.setRecruitmentID(recruitmentID);
		   ri.setSalary(salary);
		   ri.setAge(age);
		   ri.setDueDate(dueDate);
		   ri.setPositionID(position);
		   ri.setCount(count);
		   
		    //6.����Ƹ��Ϣ���ӵ��б���
		    list.add(ri); 
		   }   
		  } catch (Exception e) {
		   // TODO: handle exception
		  } 
		  return list;
		  
		 }
	
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
	public PageData queryByPage(int pageNo,int pageSize) {
		
		String sql = "select a.recruitmentID,a.firmID,a.positionID ,a.adminID,a.positionDescribe,a.salary,a.dueDate,a.checkStatus,a.count,a.age,b.positionName,b.positionType  FROM ��Ƹ��Ϣ�� a,ְλ�� b WHERE a.positionID=b.positionID";
		
		//����dbutil��getpage����
		PageData pageData = dbutil.getpage(sql, pageNo, pageSize, RecruitmentInformation.class);
		return pageData;
		
	}
	
public PageData queryByPageAdmin(int pageNo,int pageSize,String checkStatus) {
		
		String sql = "select a.recruitmentID,a.firmID,a.positionID ,a.adminID,a.positionDescribe,a.salary,a.dueDate,a.checkStatus,a.count,a.age,b.positionName,b.positionType  FROM ��Ƹ��Ϣ�� a,ְλ�� b WHERE a.positionID=b.positionID and a.checkStatus = ?";
		
		//����dbutil��getpage����
		PageData pageData = dbutil.getpage(sql, pageNo, pageSize, RecruitmentInformation.class,checkStatus);
		return pageData;
		
	}
		
	

	//������Ƹ��Ϣ
	public boolean deleteRecruitmentInfo(int recruitmentID) {
		int result = 0;
		String sql = "delete from ��Ƹ��Ϣ�� where recruitmentID = ?";
		result = dbutil.update(sql,recruitmentID);
		return result>0;
		
	}
	
	//ģ����ѯ��Ƹ��Ϣ
		public PageData queryLikeName(String positionName) {
			List<Integer> positionIDList=getPositionID(positionName);
			  //System.out.println("positionID="+positionID);
			if (positionIDList.isEmpty()) {
				List<RecruitmentInformation> list = new ArrayList<RecruitmentInformation>();
				PageData pageData = new PageData(list,1,list.size(),list.size());
				return pageData;
			}
			List<RecruitmentInformation> allList = new ArrayList<RecruitmentInformation>();
			for (Integer positionID : positionIDList) {
				 String sql = "select a.recruitmentID,a.firmID,a.positionID,a.adminID,a.positionDescribe,a.salary,a.dueDate,a.checkStatus,a.count,a.age,b.positionName,b.positionType  FROM ��Ƹ��Ϣ�� a,ְλ�� b WHERE a.positionID=b.positionID and a.positionID like "+"'%"+positionID+"%'";
					//����dbutil��getpage����
						List<RecruitmentInformation> list = (List<RecruitmentInformation>)dbutil.Select(sql, RecruitmentInformation.class);
						for (RecruitmentInformation recruitmentInformation : list) {
							allList.add(recruitmentInformation);
						}
			}
			PageData pageData = new PageData(allList,1,allList.size(),allList.size());
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
}