package com.etc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.etc.entity.Resume;
import com.etc.entity.User;
import com.etc.util.DBUtil;

public class ResumeDao {
	DBUtil dbUtil =  new DBUtil();
	public boolean addResume(Resume resume) {
		//��дsql ���  insert into ������ values(null,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);

		String sql  = "insert into ������ values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		//��ʼ��һ��result����
			int result =  0;
			//����  ����  
			result  = dbUtil.update(sql,resume.getUser().getUserID(),resume.getName(),resume.getSex(),resume.getBirthDate(),resume.getNation(),resume.getMarriage(),resume.getPoliticStatus(),resume.getSchool(),resume.getLearnMajor(),resume.getDegree(),resume.getLivingPlace(),resume.getNativePlace(),resume.getExpectSalary(),resume.getWorkStatus(),resume.getSkill(),resume.getWorkExper(),resume.getIntroduce(),resume.getPhone());
			return result>0;
				
		}
	//����
	public boolean updateResume(Resume Resume) {
		//��дsql���
		String sql  = "update ������ set name= ? , sex= ? , birthDate= ? , nation= ? , marriage= ? , politicStatus= ?  , school= ?  , learnMajor= ? , degree= ? , livingPlace= ? , nativePlace= ? , expectSalary= ? , workStatus= ? , skill= ? , workExper= ? , introduce= ? , phone= ? where userInfoID= ? ";
		//��ʼ��һ��result����
		int result =  0;
		result= dbUtil.update(sql, Resume.getName(),Resume.getSex(),Resume.getBirthDate(),Resume.getNation(),Resume.getMarriage(),Resume.getPoliticStatus(),Resume.getSchool(),Resume.getLearnMajor(),Resume.getDegree(),Resume.getLivingPlace(),Resume.getNativePlace(),Resume.getExpectSalary(),Resume.getWorkStatus(),Resume.getSkill(),Resume.getWorkExper(),Resume.getIntroduce(),Resume.getPhone(),Resume.getUserInfoID());//����˳��
		return result>0;
		
	}
	//��ѯ���м���
	public List<Resume> queryAllResumes() {
		List<Resume> list  = new ArrayList<Resume>();
		String sql = "SELECT ������.birthDate,������.degree,������.expectSalary,������.introduce,������.learnMajor,������.livingPlace,������.marriage,������.`name`,������.nation,������.nativePlace,������.phone,������.politicStatus,������.school,������.sex,������.skill,������.userID,������.userInfoID,������.workExper,������.workStatus,�û���.userID from ������,�û��� WHERE ������.userID= �û���.userID";
		CachedRowSet crs = dbUtil.Query(sql);
		System.out.println("crs�ĳ���"+crs.size());
		try {
			while(crs.next()) {
				int uid  = crs.getInt("userID");
				User user  = new User();
				user.setUserID(uid);
				
				int userInfoID  = crs.getInt("userInfoID");
				String name = crs.getString("name");
				String sex = crs.getString("sex");
				String birthDate = crs.getString("birthDate");
				String nation = crs.getString("nation");
				String marriage = crs.getString("marriage");
				String politicStatus = crs.getString("politicStatus");
				String school = crs.getString("school");
				String learnMajor = crs.getString("learnMajor");
				String degree = crs.getString("degree");
				String livingPlace = crs.getString("livingPlace");
				String nativePlace = crs.getString("nativePlace");
				String expectSalary = crs.getString("expectSalary");
				String workStatus = crs.getString("workStatus");
				String skill = crs.getString("skill");
				String workExper = crs.getString("workExper");
				String introduce = crs.getString("introduce");
				String phone = crs.getString("phone");
				Resume resume =new Resume();
				resume.setBirthDate(birthDate);
				resume.setDegree(degree);
				resume.setExpectSalary(expectSalary);
				resume.setIntroduce(introduce);
				resume.setLearnMajor(learnMajor);
				resume.setLivingPlace(livingPlace);
				resume.setMarriage(marriage);
				resume.setName(name);
				resume.setNation(nation);
				resume.setNativePlace(nativePlace);
				resume.setPhone(phone);
				resume.setPoliticStatus(politicStatus);
				resume.setSchool(school);
				resume.setSex(sex);
				resume.setSkill(skill);
				resume.setUser(user);
				resume.setUserInfoID(userInfoID);
				resume.setWorkExper(workExper);
				resume.setWorkStatus(workStatus);
				list.add(resume);	
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		return list;	
	}
	
	
	//ͨ��������Ų�ѯĳ������
	public Resume queryResumesById(int userInfoID) {
		String sql = "SELECT ������.birthDate,������.degree,������.expectSalary,������.introduce,������.learnMajor,������.livingPlace,������.marriage,������.`name`,������.nation,������.nativePlace,������.phone,������.politicStatus,������.school,������.sex,������.skill,������.userID,������.userInfoID,������.workExper,������.workStatus from ������ WHERE ������.userInfoID=?";
		CachedRowSet crs = dbUtil.Query(sql,userInfoID);
		System.out.println("crs�ĳ���--------------------->"+crs.size());
		try {
			while(crs.next()) {
				int uid  = crs.getInt("userID");
				User user  = new User();
				user.setUserID(uid);
				
				String name = crs.getString("name");
				String sex = crs.getString("sex");
				String birthDate = crs.getString("birthDate");
				String nation = crs.getString("nation");
				String marriage = crs.getString("marriage");
				String politicStatus = crs.getString("politicStatus");
				String school = crs.getString("school");
				String learnMajor = crs.getString("learnMajor");
				String degree = crs.getString("degree");
				String livingPlace = crs.getString("livingPlace");
				String nativePlace = crs.getString("nativePlace");
				String expectSalary = crs.getString("expectSalary");
				String workStatus = crs.getString("workStatus");
				String skill = crs.getString("skill");
				String workExper = crs.getString("workExper");
				String introduce = crs.getString("introduce");
				String phone = crs.getString("phone");
				Resume resume =new Resume(userInfoID, user, name, sex, birthDate, nation, marriage, politicStatus, school, learnMajor, degree, livingPlace, nativePlace, expectSalary, workStatus, skill, workExper, introduce, phone);
			
				return resume;
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}	
			Resume resum=new Resume();
			return resum;
	}
}
