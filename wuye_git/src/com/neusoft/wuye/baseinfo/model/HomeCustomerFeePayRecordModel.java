package com.neusoft.wuye.baseinfo.model;

import java.util.Date;

public class HomeCustomerFeePayRecordModel {
	private int payNo;  //记录号
	private double payAmount;     //付款金额
	private Date payDate;         //付款日期
	private String payPerson;     //付款人
	private String mobile;        //手机
	private String invoiceCode;   //发票号
	private String payNoteCode;   //付款凭证号
	private String payDesc;       //付款说明
	
	private RoomCustomerFeeModel roomCustomerFee; //房间收费记录号
	private PayTypeModel payType; //付款类型号
	public int getPayNo() {
		return payNo;
	}
	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}
	public double getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public String getPayPerson() {
		return payPerson;
	}
	public void setPayPerson(String payPerson) {
		this.payPerson = payPerson;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getInvoiceCode() {
		return invoiceCode;
	}
	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}
	public String getPayNoteCode() {
		return payNoteCode;
	}
	public void setPayNoteCode(String payNoteCode) {
		this.payNoteCode = payNoteCode;
	}
	public String getPayDesc() {
		return payDesc;
	}
	public void setPayDesc(String payDesc) {
		this.payDesc = payDesc;
	}
	public RoomCustomerFeeModel getRoomCustomerFee() {
		return roomCustomerFee;
	}
	public void setRoomCustomerFee(RoomCustomerFeeModel roomCustomerFee) {
		this.roomCustomerFee = roomCustomerFee;
	}
	public PayTypeModel getPayType() {
		return payType;
	}
	public void setPayType(PayTypeModel payType) {
		this.payType = payType;
	}
}
