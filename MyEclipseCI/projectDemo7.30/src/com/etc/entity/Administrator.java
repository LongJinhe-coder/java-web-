package com.etc.entity;

public class Administrator {
	private int adminID;
	private String adminName;
	private String adminPwd;
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Administrator(int adminID, String adminName, String adminPwd) {
		super();
		this.adminID = adminID;
		this.adminName = adminName;
		this.adminPwd = adminPwd;
	}
	@Override
	public String toString() {
		return "Administrator [adminID=" + adminID + ", adminName=" + adminName + ", adminPwd=" + adminPwd + "]";
	}
	
}
