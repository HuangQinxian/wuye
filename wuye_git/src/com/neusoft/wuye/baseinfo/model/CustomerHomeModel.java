package com.neusoft.wuye.baseinfo.model;

import java.util.Date;

public class CustomerHomeModel {
	private int chNO;                 //�ͻ������
	private Date receiveDate;         //�շ�����
	private Date liveDate;            //��ס����
	private Date feeStartDate;        //�ɷѿ�ʼ����
	private Date feeEndDate;          //�ɷѽ�������
	private int humanCount;           //��ס����
	
	private CustomerModel customer;   //�ͻ���
	private RoomModel room;           //�����
	private LivingTypeModel livingType;//��ס���ͺ�
	
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
