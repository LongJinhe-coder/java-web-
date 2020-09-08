package com.etc.entity;

public class User {
	private int userID;
	private String userName;
	private String userPwd;
	private String avatarName;
	private String email;
	private String accountStatus;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userID, String userName, String userPwd, String avatarName, String email, String accountStatus) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPwd = userPwd;
		this.avatarName = avatarName;
		this.email = email;
		this.accountStatus = accountStatus;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getAvatarName() {
		return avatarName;
	}
	public void setAvatarName(String avatarName) {
		this.avatarName = avatarName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", userPwd=" + userPwd + ", avatarName="
				+ avatarName + ", email=" + email + ", accountStatus=" + accountStatus + "]";
	}
	
	
}
