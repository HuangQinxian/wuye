package com.neusoft.wuye.baseinfo.model;

import java.util.Date;

public class ParkCustomerModel {
	private int pcno;      //�����ͻ��������
	private Date startDate;//��ʼ����
	private Date endDate;   //��������
	private String pcStatus;//����״̬��Y ���ڹ��� N ���������
	
	private ParkModel park;        //��λ��
	private CustomerModel customer;//�ͻ���
	public int getPcno() {
		return pcno;
	}
	public void setPcno(int pcno) {
		this.pcno = pcno;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getPcStatus() {
		return pcStatus;
	}
	public void setPcStatus(String pcStatus) {
		this.pcStatus = pcStatus;
	}
	public ParkModel getPark() {
		return park;
	}
	public void setPark(ParkModel park) {
		this.park = park;
	}
	public CustomerModel getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}
}
