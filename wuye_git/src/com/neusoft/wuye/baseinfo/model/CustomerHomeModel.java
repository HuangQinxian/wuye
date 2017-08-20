package com.neusoft.wuye.baseinfo.model;

import java.util.Date;

public class CustomerHomeModel {
	private int chNO;                 //客户房间号
	private Date receiveDate;         //收房日期
	private Date liveDate;            //入住日期
	private Date feeStartDate;        //缴费开始日期
	private Date feeEndDate;          //缴费结束日期
	private int humanCount;           //居住人数
	
	private CustomerModel customer;   //客户号
	private RoomModel room;           //房间号
	private LivingTypeModel livingType;//居住类型号
	
	public int getChNO() {
		return chNO;
	}
	public void setChNO(int chNO) {
		this.chNO = chNO;
	}
	public CustomerModel getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}
	public RoomModel getRoom() {
		return room;
	}
	public void setRoom(RoomModel room) {
		this.room = room;
	}
	public LivingTypeModel getLivingType() {
		return livingType;
	}
	public void setLivingType(LivingTypeModel livingType) {
		this.livingType = livingType;
	}
	public Date getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}
	public Date getLiveDate() {
		return liveDate;
	}
	public void setLiveDate(Date liveDate) {
		this.liveDate = liveDate;
	}
	public Date getFeeStartDate() {
		return feeStartDate;
	}
	public void setFeeStartDate(Date feeStartDate) {
		this.feeStartDate = feeStartDate;
	}
	public Date getFeeEndDate() {
		return feeEndDate;
	}
	public void setFeeEndDate(Date feeEndDate) {
		this.feeEndDate = feeEndDate;
	}
	public int getHumanCount() {
		return humanCount;
	}
	public void setHumanCount(int humanCount) {
		this.humanCount = humanCount;
	}
}
