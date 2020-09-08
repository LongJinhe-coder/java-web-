package com.etc.entity;

import sun.util.calendar.LocalGregorianCalendar.Date;

public class Advert {
	private int advertID;
	private Administrator adminID;
	private String advertName;
	private Date launchTime;
	private String checkStatus;
	public int getAdvertID() {
		return advertID;
	}
	public void setAdvertID(int advertID) {
		this.advertID = advertID;
	}
	public Administrator getAdminID() {
		return adminID;
	}
	public void setAdminID(Administrator adminID) {
		this.adminID = adminID;
	}
	public String getAdvertName() {
		return advertName;
	}
	public void setAdvertName(String advertName) {
		this.advertName = advertName;
	}
	public Date getLaunchTime() {
		return launchTime;
	}
	public void setLaunchTime(Date launchTime) {
		this.launchTime = launchTime;
	}
	public String getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}
	public Advert() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Advert(int advertID, Administrator adminID, String advertName, Date launchTime, String checkStatus) {
		super();
		this.advertID = advertID;
		this.adminID = adminID;
		this.advertName = advertName;
		this.launchTime = launchTime;
		this.checkStatus = checkStatus;
	}
	@Override
	public String toString() {
		return "Advert [advertID=" + advertID + ", adminID=" + adminID + ", advertName=" + advertName + ", launchTime="
				+ launchTime + ", checkStatus=" + checkStatus + "]";
	}
	
}
