package com.neusoft.wuye.baseinfo.model;

public class ServiceModel {
	private int spno;      //�����������
	private String spname;  //��������
	private double price;   //����۸�
	private String spDesc;  //����۸�˵��
	
	private ServiceTypeModel serviceType;        //�������ͱ��

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
