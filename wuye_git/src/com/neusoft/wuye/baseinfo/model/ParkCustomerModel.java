package com.neusoft.wuye.baseinfo.model;

import java.util.Date;

public class ParkCustomerModel {
	private int pcno;      //车辆客户关联序号
	private Date startDate;//开始日期
	private Date endDate;   //结束日期
	private String pcStatus;//关联状态（Y 正在关联 N 关联解除）
	
	private ParkModel park;        //车位号
	private CustomerModel customer;//客户号
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
