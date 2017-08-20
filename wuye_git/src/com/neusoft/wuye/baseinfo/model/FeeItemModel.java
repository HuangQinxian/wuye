package com.neusoft.wuye.baseinfo.model;

public class FeeItemModel {
	private int itemNo;      //�շ���Ŀ���
	private String itemCode; //�շ���Ŀ����
	private String itemName; //�շ���Ŀ����
	private String itemUnit; //�շѵ�λ����/��/��/����
	private String feePayType;   //�Ʒѷ�ʽ����/��/��/�Σ�
	private String feeCycle;     //�Ƿ������ԣ�Y/N)
	private String itemStatus;   //�Ƿ��շѣ�Y/N)
	private String itemDesc;     //�շ���Ŀ˵��
	
	private FeeTypeModel feeType;//�շ����ͱ�

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}

	public String getFeePayType() {
		return feePayType;
	}

	public void setFeePayType(String feePayType) {
		this.feePayType = feePayType;
	}

	public String getFeeCycle() {
		return feeCycle;
	}

	public void setFeeCycle(String feeCycle) {
		this.feeCycle = feeCycle;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public FeeTypeModel getFeeType() {
		return feeType;
	}

	public void setFeeType(FeeTypeModel feeType) {
		this.feeType = feeType;
	}
}
