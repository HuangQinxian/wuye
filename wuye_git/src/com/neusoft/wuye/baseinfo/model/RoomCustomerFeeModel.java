package com.neusoft.wuye.baseinfo.model;

import java.util.Date;

public class RoomCustomerFeeModel {
	private int roomFeeNo;      //�ɷ����
	private String feeMonth;      //�ɷ��·�
	private double spay;   //Ӧ�ɷѽ��
	private double apay;   //ʵ�ɷѽ��
	private double derate; //������
	private Date startDate; //��ʼ����
	private Date endDate;   //��ֹ����
	private String feeStatus; //�ɷ�״̬��Y/N)
	
	private HomeFeeItemYearPriceModel feeYear;  //�ɷ����
	private CustomerHomeModel customerHome; //����ͻ��������
	private FeeItemModel feeItem; //�ɷ���Ŀ��
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
