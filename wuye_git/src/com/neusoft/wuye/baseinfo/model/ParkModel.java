package com.neusoft.wuye.baseinfo.model;

public class ParkModel {
	private int parkNo;  //��λ���
	private ParkTypeModel parkType; //��λ����
	private String parkCode;   //��λ����
	private BuildingModel building; //¥��
	private String location;  //λ��
	private double area;     //���
	private String parkStatus;  //�Ƿ�����ͻ���Y/N)
	private double rentPrice;  //����۸�
	private String rentUnit;   //���޵�λ����/��/��/�꣩
	private String feeStatus;  //�շ�״̬��Y �շ�   N ���շѣ�
	public int getParkNo() {
		return parkNo;
	}
	public void setParkNo(int parkNo) {
		this.parkNo = parkNo;
	}
	public ParkTypeModel getParkType() {
		return parkType;
	}
	public void setParkType(ParkTypeModel parkType) {
		this.parkType = parkType;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public BuildingModel getBuilding() {
		return building;
	}
	public void setBuilding(BuildingModel building) {
		this.building = building;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public String getParkStatus() {
		return parkStatus;
	}
	public void setParkStatus(String parkStatus) {
		this.parkStatus = parkStatus;
	}
	public double getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
	public String getRentUnit() {
		return rentUnit;
	}
	public void setRentUnit(String rentUnit) {
		this.rentUnit = rentUnit;
	}
	public String getFeeStatus() {
		return feeStatus;
	}
	public void setFeeStatus(String feeStatus) {
		this.feeStatus = feeStatus;
	}
}
