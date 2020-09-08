package com.etc.entity;

public class ResumePosition {
	private Position positionID;
	private Resume userInfoID;
	public Position getPositionID() {
		return positionID;
	}
	public void setPositionID(Position positionID) {
		this.positionID = positionID;
	}
	public Resume getUserInfoID() {
		return userInfoID;
	}
	public void setUserInfoID(Resume userInfoID) {
		this.userInfoID = userInfoID;
	}
	public ResumePosition() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResumePosition(Position positionID, Resume userInfoID) {
		super();
		this.positionID = positionID;
		this.userInfoID = userInfoID;
	}
	@Override
	public String toString() {
		return "ResumePosition [positionID=" + positionID + ", userInfoID=" + userInfoID + "]";
	}
	
}
