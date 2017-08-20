package com.neusoft.wuye.baseinfo.model;

public class FeeItemModel {
	private int itemNo;      //收费项目序号
	private String itemCode; //收费项目编码
	private String itemName; //收费项目名称
	private String itemUnit; //收费单位（米/户/人/车）
	private String feePayType;   //计费方式（年/月/日/次）
	private String feeCycle;     //是否周期性（Y/N)
	private String itemStatus;   //是否收费（Y/N)
	private String itemDesc;     //收费项目说明
	
	private FeeTypeModel feeType;//收费类型表

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
