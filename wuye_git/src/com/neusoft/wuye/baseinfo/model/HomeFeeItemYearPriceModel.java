package com.neusoft.wuye.baseinfo.model;

import java.util.Date;

public class HomeFeeItemYearPriceModel {
	//��� �� ��Ŀ�������������
	private String feeYear;      //����   �շ����
	private double unitPrice;    //����
	private Date startDate;      //��ʼ����
	private Date endDate;        //��������
	
	private FeeItemModel feeItem;//���� ��� �շ���Ŀ

	public String getFeeYear() {
		return feeYear;
	}

	public void setFeeYear(String feeYear) {
		this.feeYear = feeYear;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
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

	public FeeItemModel getFeeItem() {
		return feeItem;
	}

	public void setFeeItem(FeeItemModel feeItem) {
		this.feeItem = feeItem;
	}
	
	
	
}
