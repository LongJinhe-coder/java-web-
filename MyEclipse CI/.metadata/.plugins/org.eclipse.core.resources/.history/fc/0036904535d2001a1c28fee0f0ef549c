package com.etc.dao;

import com.etc.entity.Firm;
import com.etc.entity.Resume;
import com.etc.util.DBUtil;

public class ResumeDao {
	DBUtil dbUtil =  new DBUtil();
	public boolean addResume(Resume resume) {
		//编写sql 语句  insert into 简历表 values(null,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);

		String sql  = "insert into 简历表 values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		//初始化一个result变量
			int result =  0;
			//参数  名称  
			result  = dbUtil.update(sql,resume.getUser().getUserID(),resume.getName(),resume.getSex(),resume.getBirthDate(),resume.getNation(),resume.getMarriage(),resume.getPoliticStatus(),resume.getSchool(),resume.getLearnMajor(),resume.getDegree(),resume.getLivingPlace(),resume.getNativePlace(),resume.getExpectSalary(),resume.getWorkStatus(),resume.getSkill(),resume.getWorkExper(),resume.getIntroduce(),resume.getPhone());
			return result>0;
				
		}
}
