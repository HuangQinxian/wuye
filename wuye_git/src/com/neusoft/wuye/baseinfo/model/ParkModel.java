package com.neusoft.wuye.baseinfo.model;

public class ParkModel {
	private int parkNo;  //车位序号
	private ParkTypeModel parkType; //车位类型
	private String parkCode;   //车位编码
	private BuildingModel building; //楼号
	private String location;  //位置
	private double area;     //面积
	private String parkStatus;  //是否关联客户（Y/N)
	private double rentPrice;  //出租价格
	private String rentUnit;   //租赁单位（天/月/季/年）
	private String feeStatus;  //收费状态（Y 收费   N 不收费）
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
