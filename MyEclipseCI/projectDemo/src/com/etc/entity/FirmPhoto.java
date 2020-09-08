package com.etc.entity;

public class FirmPhoto {
private int photoID;
private String photoName;
private String photoType;
private Firm firmID;
public int getPhotoID() {
	return photoID;
}
public void setPhotoID(int photoID) {
	this.photoID = photoID;
}
public String getPhotoName() {
	return photoName;
}
public void setPhotoName(String photoName) {
	this.photoName = photoName;
}
public String getPhotoType() {
	return photoType;
}
public void setPhotoType(String photoType) {
	this.photoType = photoType;
}
public Firm getFirmID() {
	return firmID;
}
public void setFirmID(Firm firmID) {
	this.firmID = firmID;
}

public FirmPhoto() {
	super();
	// TODO Auto-generated constructor stub
}
public FirmPhoto(int photoID, String photoName, String photoType, Firm firmID) {
	super();
	this.photoID = photoID;
	this.photoName = photoName;
	this.photoType = photoType;
	this.firmID = firmID;
}
@Override
public String toString() {
	return "FirmPhoto [photoID=" + photoID + ", photoName=" + photoName + ", photoType=" + photoType + ", firmID="
			+ firmID + "]";
}

}
