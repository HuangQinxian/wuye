package com.neusoft.wuye.baseinfo.model;

public class UserInfoModel {
	private String uuserId;     //����Ա��¼�˺�
	private String upassword;   //��¼����
	private String uname;       //����
	private String userStatus;  //��¼״̬��Y/N)
	public String getUuserId() {
		return uuserId;
	}
	public void setUuserId(String uuserId) {
		this.uuserId = uuserId;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
}
