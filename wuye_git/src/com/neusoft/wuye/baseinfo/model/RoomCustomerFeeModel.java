package com.neusoft.wuye.baseinfo.model;

import java.util.Date;

public class RoomCustomerFeeModel {
	private int roomFeeNo;      //缴费序号
	private String feeMonth;      //缴费月份
	private double spay;   //应缴费金额
	private double apay;   //实缴费金额
	private double derate; //减免金额
	private Date startDate; //开始日期
	private Date endDate;   //截止日期
	private String feeStatus; //缴费状态（Y/N)
	
	private HomeFeeItemYearPriceModel feeYear;  //缴费年份
	private CustomerHomeModel customerHome; //房间客户关联序号
	private FeeItemModel feeItem; //缴费项目号
	public int getRoomFeeNo() {
		return roomFeeNo;
	}
	public void setRoomFeeNo(int roomFeeNo) {
		this.roomFeeNo = roomFeeNo;
	}
	public String getFeeMonth() {
		return feeMonth;
	}
	public void setFeeMonth(String feeMonth) {
		this.feeMonth = feeMonth;
	}
	public double getSpay() {
		return spay;
	}
	public void setSpay(double spay) {
		this.spay = spay;
	}
	public double getApay() {
		return apay;
	}
	public void setApay(double apay) {
		this.apay = apay;
	}
	public double getDerate() {
		return derate;
	}
	public void setDerate(double derate) {
		this.derate = derate;
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
	public String getFeeStatus() {
		return feeStatus;
	}
	public void setFeeStatus(String feeStatus) {
		this.feeStatus = feeStatus;
	}
	public HomeFeeItemYearPriceModel getFeeYear() {
		return feeYear;
	}
	public void setFeeYear(HomeFeeItemYearPriceModel feeYear) {
		this.feeYear = feeYear;
	}
	public CustomerHomeModel getCustomerHome() {
		return customerHome;
	}
	public void setCustomerHome(CustomerHomeModel customerHome) {
		this.customerHome = customerHome;
	}
	public FeeItemModel getFeeItem() {
		return feeItem;
	}
	public void setFeeItem(FeeItemModel feeItem) {
		this.feeItem = feeItem;
	}
}
