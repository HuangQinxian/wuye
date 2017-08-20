package com.neusoft.wuye.baseinfo.model;

import java.util.Date;

public class HomeFeeItemYearPriceModel {
	//年度 和 项目编号联合做主键
	private String feeYear;      //主键   收费年度
	private double unitPrice;    //单价
	private Date startDate;      //开始日期
	private Date endDate;        //结束日期
	
	private FeeItemModel feeItem;//主键 外键 收费项目

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
