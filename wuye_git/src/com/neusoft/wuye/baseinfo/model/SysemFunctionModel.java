package com.neusoft.wuye.baseinfo.model;

public class SysemFunctionModel {
	private int funno;    //���ܱ��
	private String funName;   //��������
	private String funUrl;    //url����
	private int levelNo;      //���ܼ����
	
	private SystemModuleModel systemModule; //ģ����

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
