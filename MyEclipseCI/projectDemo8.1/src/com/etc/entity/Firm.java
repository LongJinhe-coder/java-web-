package com.etc.entity;

public class Firm {
private int firmID;
private Administrator admin;
private String firmAccount;
private String registerTime;
private String firmName;
private String registerArea;
private String firmNature;
private String registerFund;
private String firmBrief;
private String linkMan;
private String linkPhone;
private String firmArea;
private String registerNum;
private String firmEmail;
private String checkStatus;
private String firmPwd;
private String accountStatus;
public int getFirmID() {
	return firmID;
}
public void setFirmID(int firmID) {
	this.firmID = firmID;
}

public Administrator getAdmin() {
	return admin;
}
public void setAdmin(Administrator admin) {
	this.admin = admin;
}
public String getFirmAccount() {
	return firmAccount;
}
public void setFirmAccount(String firmAccount) {
	this.firmAccount = firmAccount;
}
public String getRegisterTime() {
	return registerTime;
}
public void setRegisterTime(String registerTime) {
	this.registerTime = registerTime;
}
public String getFirmName() {
	return firmName;
}
public void setFirmName(String firmName) {
	this.firmName = firmName;
}
public String getRegisterArea() {
	return registerArea;
}
public void setRegisterArea(String registerArea) {
	this.registerArea = registerArea;
}
public String getFirmNature() {
	return firmNature;
}
public void setFirmNature(String firmNature) {
	this.firmNature = firmNature;
}
public String getRegisterFund() {
	return registerFund;
}
public void setRegisterFund(String registerFund) {
	this.registerFund = registerFund;
}
public String getFirmBrief() {
	return firmBrief;
}
public void setFirmBrief(String firmBrief) {
	this.firmBrief = firmBrief;
}
public String getLinkMan() {
	return linkMan;
}
public void setLinkMan(String linkMan) {
	this.linkMan = linkMan;
}
public String getLinkPhone() {
	return linkPhone;
}
public void setLinkPhone(String linkPhone) {
	this.linkPhone = linkPhone;
}
public String getFirmArea() {
	return firmArea;
}
public void setFirmArea(String firmArea) {
	this.firmArea = firmArea;
}
public String getRegisterNum() {
	return registerNum;
}
public void setRegisterNum(String registerNum) {
	this.registerNum = registerNum;
}
public String getFirmEmail() {
	return firmEmail;
}
public void setFirmEmail(String firmEmail) {
	this.firmEmail = firmEmail;
}
public String getCheckStatus() {
	return checkStatus;
}
public void setCheckStatus(String checkStatus) {
	this.checkStatus = checkStatus;
}
public String getFirmPwd() {
	return firmPwd;
}
public void setFirmPwd(String firmPwd) {
	this.firmPwd = firmPwd;
}
public String getAccountStatus() {
	return accountStatus;
}
public void setAccountStatus(String accountStatus) {
	this.accountStatus = accountStatus;
}
public Firm() {
	super();
	// TODO Auto-generated constructor stub
}
public Firm(int firmID, Administrator admin, String firmAccount, String registerTime, String firmName,
		String registerArea, String firmNature, String registerFund, String firmBrief, String linkMan, String linkPhone,
		String firmArea, String registerNum, String firmEmail, String checkStatus, String firmPwd,
		String accountStatus) {
	super();
	this.firmID = firmID;
	this.admin = admin;
	this.firmAccount = firmAccount;
	this.registerTime = registerTime;
	this.firmName = firmName;
	this.registerArea = registerArea;
	this.firmNature = firmNature;
	this.registerFund = registerFund;
	this.firmBrief = firmBrief;
	this.linkMan = linkMan;
	this.linkPhone = linkPhone;
	this.firmArea = firmArea;
	this.registerNum = registerNum;
	this.firmEmail = firmEmail;
	this.checkStatus = checkStatus;
	this.firmPwd = firmPwd;
	this.accountStatus = accountStatus;
}
@Override
public String toString() {
	return "Firm [firmID=" + firmID + ", admin=" + admin + ", firmAccount=" + firmAccount + ", registerTime="
			+ registerTime + ", firmName=" + firmName + ", registerArea=" + registerArea + ", firmNature=" + firmNature
			+ ", registerFund=" + registerFund + ", firmBrief=" + firmBrief + ", linkMan=" + linkMan + ", linkPhone="
			+ linkPhone + ", firmArea=" + firmArea + ", registerNum=" + registerNum + ", firmEmail=" + firmEmail
			+ ", checkStatus=" + checkStatus + ", firmPwd=" + firmPwd + ", accountStatus=" + accountStatus + "]";
}

}
