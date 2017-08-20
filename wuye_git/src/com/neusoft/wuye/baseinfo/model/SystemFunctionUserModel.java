package com.neusoft.wuye.baseinfo.model;

public class SystemFunctionUserModel {
	private SysemFunctionModel systemFunction; //功能号
	private UserInfoModel userInfo;   //操作员账号
	public SysemFunctionModel getSystemFunction() {
		return systemFunction;
	}
	public void setSystemFunction(SysemFunctionModel systemFunction) {
		this.systemFunction = systemFunction;
	}
	public UserInfoModel getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfoModel userInfo) {
		this.userInfo = userInfo;
	}
}
