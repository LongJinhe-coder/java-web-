package com.etc.entity;

import java.util.Date;

public class RecruitmentInformation {
	private int recruitmentID;
	private Firm firmID;
	private Position positionID;
	private Administrator adminID;
	private String positionDescribe;
	private String salary;
	private Date dueDate;
	private String checkStatus;
	private int count;
	private String age;
	public int getRecruitmentID() {
		return recruitmentID;
	}
	public void setRecruitmentID(int recruitmentID) {
		this.recruitmentID = recruitmentID;
	}
	public Firm getFirmID() {
		return firmID;
	}
	public void setFirmID(Firm firmID) {
		this.firmID = firmID;
	}
	public Position getPositionID() {
		return positionID;
	}
	public void setPositionID(Position positionID) {
		this.positionID = positionID;
	}
	public Administrator getAdminID() {
		return adminID;
	}
	public void setAdminID(Administrator adminID) {
		this.adminID = adminID;
	}
	public String getPositionDescribe() {
		return positionDescribe;
	}
	public void setPositionDescribe(String positionDescribe) {
		this.positionDescribe = positionDescribe;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public RecruitmentInformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RecruitmentInformation(int recruitmentID, Firm firmID, Position positionID, Administrator adminID,
			String positionDescribe, String salary, Date dueDate, String checkStatus, int count, String age) {
		super();
		this.recruitmentID = recruitmentID;
		this.firmID = firmID;
		this.positionID = positionID;
		this.adminID = adminID;
		this.positionDescribe = positionDescribe;
		this.salary = salary;
		this.dueDate = dueDate;
		this.checkStatus = checkStatus;
		this.count = count;
		this.age = age;
	}
	@Override
	public String toString() {
		return "RecruitmentInformation [recruitmentID=" + recruitmentID + ", firmID=" + firmID + ", positionID="
				+ positionID + ", adminID=" + adminID + ", positionDescribe=" + positionDescribe + ", salary=" + salary
				+ ", dueDate=" + dueDate + ", checkStatus=" + checkStatus + ", count=" + count + ", age=" + age + "]";
	}
	
}
