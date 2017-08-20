package com.neusoft.wuye.baseinfo.model;

public class ServiceModel {
	private int spno;      //服务类型序号
	private String spname;  //服务名称
	private double price;   //服务价格
	private String spDesc;  //服务价格说明
	
	private ServiceTypeModel serviceType;        //服务类型编号

	public int getSpno() {
		return spno;
	}

	public void setSpno(int spno) {
		this.spno = spno;
	}

	public String getSpname() {
		return spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSpDesc() {
		return spDesc;
	}

	public void setSpDesc(String spDesc) {
		this.spDesc = spDesc;
	}

	public ServiceTypeModel getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceTypeModel serviceType) {
		this.serviceType = serviceType;
	}
	
	
}
