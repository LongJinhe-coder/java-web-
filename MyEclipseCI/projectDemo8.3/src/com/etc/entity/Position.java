package com.etc.entity;

public class Position {
	private int positionID;
	private String positionName;
	private String positionType;
	public int getPositionID() {
		return positionID;
	}
	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getPositionType() {
		return positionType;
	}
	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Position(int positionID, String positionName, String positionType) {
		super();
		this.positionID = positionID;
		this.positionName = positionName;
		this.positionType = positionType;
	}
	@Override
	public String toString() {
		return "Position [positionID=" + positionID + ", positionName=" + positionName + ", positionType="
				+ positionType + "]";
	}
	
	
}
