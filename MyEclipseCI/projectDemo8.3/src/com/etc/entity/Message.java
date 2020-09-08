package com.etc.entity;

public class Message {
	private int recruitmentID;
	private int userInfoID;

	private String firmName;
	private String linkPhone;
	private String handleStatus;
	private String message;

	public Message() {
		super();
	}

	public Message(int recruitmentID, int userInfoID, String firmName, String linkPhone,String handleStatus, String message) {
		super();
		this.recruitmentID = recruitmentID;
		this.userInfoID = userInfoID;
		this.firmName = firmName;
		this.linkPhone = linkPhone;
		this.handleStatus = handleStatus;
		this.message = message;
	}

	public int getRecruitmentID() {
		return recruitmentID;
	}

	public void setRecruitmentID(int recruitmentID) {
		this.recruitmentID = recruitmentID;
	}

	public int getUserInfoID() {
		return userInfoID;
	}

	public void setUserInfoID(int userInfoID) {
		this.userInfoID = userInfoID;
	}

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	public String getHandleStatus() {
		return handleStatus;
	}

	public void setHandleStatus(String handleStatus) {
		this.handleStatus = handleStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [recruitmentID=" + recruitmentID + ", userInfoID=" + userInfoID + ", firmName=" + firmName
				+ ", linkPhone=" + linkPhone + ", handleStatus=" + handleStatus + ", message=" + message + "]";
	}

	

}
