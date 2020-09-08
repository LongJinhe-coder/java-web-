package com.etc.entity;

public class Recruitment {
	private Resume userInfoID;
	private RecruitmentInformation recruitmentID;
	private String handleStatus;
	public Resume getUserInfoID() {
		return userInfoID;
	}
	public void setUserInfoID(Resume userInfoID) {
		this.userInfoID = userInfoID;
	}
	public RecruitmentInformation getRecruitmentID() {
		return recruitmentID;
	}
	public void setRecruitmentID(RecruitmentInformation recruitmentID) {
		this.recruitmentID = recruitmentID;
	}
	public String getHandleStatus() {
		return handleStatus;
	}
	public void setHandleStatus(String handleStatus) {
		this.handleStatus = handleStatus;
	}
	public Recruitment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Recruitment(Resume userInfoID, RecruitmentInformation recruitmentID, String handleStatus) {
		super();
		this.userInfoID = userInfoID;
		this.recruitmentID = recruitmentID;
		this.handleStatus = handleStatus;
	}
	@Override
	public String toString() {
		return "Recruitment [userInfoID=" + userInfoID + ", recruitmentID=" + recruitmentID + ", handleStatus="
				+ handleStatus + "]";
	}
	
}
