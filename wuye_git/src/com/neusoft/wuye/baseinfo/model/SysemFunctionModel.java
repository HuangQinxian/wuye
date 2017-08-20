package com.neusoft.wuye.baseinfo.model;

public class SysemFunctionModel {
	private int funno;    //功能编号
	private String funName;   //功能名称
	private String funUrl;    //url名称
	private int levelNo;      //功能级别号
	
	private SystemModuleModel systemModule; //模块编号

	public int getFunno() {
		return funno;
	}

	public void setFunno(int funno) {
		this.funno = funno;
	}

	public String getFunName() {
		return funName;
	}

	public void setFunName(String funName) {
		this.funName = funName;
	}

	public String getFunUrl() {
		return funUrl;
	}

	public void setFunUrl(String funUrl) {
		this.funUrl = funUrl;
	}

	public int getLevelNo() {
		return levelNo;
	}

	public void setLevelNo(int levelNo) {
		this.levelNo = levelNo;
	}

	public SystemModuleModel getSystemModule() {
		return systemModule;
	}

	public void setSystemModule(SystemModuleModel systemModule) {
		this.systemModule = systemModule;
	}
}
