package com.etc.entity;



public class Resume {
	private int userInfoID;
	private User user;
	private String name;
	private String sex;
	private String birthDate;
	private String nation;
	private String marriage;
	private String politicStatus;
	private String school;
	private String learnMajor;
	private String degree;
	private String livingPlace;
	private String nativePlace;
	private String expectSalary;
	private String workStatus;
	private String skill;
	private String workExper;
	private String introduce;
	private String phone;
	public int getUserInfoID() {
		return userInfoID;
	}
	public void setUserInfoID(int userInfoID) {
		this.userInfoID = userInfoID;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getMarriage() {
		return marriage;
	}
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	public String getPoliticStatus() {
		return politicStatus;
	}
	public void setPoliticStatus(String politicStatus) {
		this.politicStatus = politicStatus;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getLearnMajor() {
		return learnMajor;
	}
	public void setLearnMajor(String learnMajor) {
		this.learnMajor = learnMajor;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getLivingPlace() {
		return livingPlace;
	}
	public void setLivingPlace(String livingPlace) {
		this.livingPlace = livingPlace;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getExpectSalary() {
		return expectSalary;
	}
	public void setExpectSalary(String expectSalary) {
		this.expectSalary = expectSalary;
	}
	public String getWorkStatus() {
		return workStatus;
	}
	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getWorkExper() {
		return workExper;
	}
	public void setWorkExper(String workExper) {
		this.workExper = workExper;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Resume() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Resume(int userInfoID, User userID, String name, String sex, String birthDate, String nation, String marriage,
			String politicStatus, String school, String learnMajor, String degree, String livingPlace,
			String nativePlace, String expectSalary, String workStatus, String skill, String workExper,
			String introduce, String phone) {
		super();
		this.userInfoID = userInfoID;
		this.user = user;
		this.name = name;
		this.sex = sex;
		this.birthDate = birthDate;
		this.nation = nation;
		this.marriage = marriage;
		this.politicStatus = politicStatus;
		this.school = school;
		this.learnMajor = learnMajor;
		this.degree = degree;
		this.livingPlace = livingPlace;
		this.nativePlace = nativePlace;
		this.expectSalary = expectSalary;
		this.workStatus = workStatus;
		this.skill = skill;
		this.workExper = workExper;
		this.introduce = introduce;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Resume [userInfoID=" + userInfoID + ", user=" + user + ", name=" + name + ", sex=" + sex
				+ ", birthDate=" + birthDate + ", nation=" + nation + ", marriage=" + marriage + ", politicStatus="
				+ politicStatus + ", school=" + school + ", learnMajor=" + learnMajor + ", degree=" + degree
				+ ", livingPlace=" + livingPlace + ", nativePlace=" + nativePlace + ", expectSalary=" + expectSalary
				+ ", workStatus=" + workStatus + ", skill=" + skill + ", workExper=" + workExper + ", introduce="
				+ introduce + ", phone=" + phone + "]";
	}
	
}
