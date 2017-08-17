package com.neusoft.wuye.baseinfo.model;

import org.apache.ibatis.type.Alias;

@Alias("Building")
public class BuildingModel {
	private int no;
	
	private String code;
	private String address;
	
	private String direction;
	private int totalHome;
	private int totalHouse;
	
	private AreaModel area;
	private BuildingTypeModel buildingType;	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public int getTotalHome() {
		return totalHome;
	}
	public void setTotalHome(int totalHome) {
		this.totalHome = totalHome;
	}
	public int getTotalHouse() {
		return totalHouse;
	}
	public void setTotalHouse(int totalHouse) {
		this.totalHouse = totalHouse;
	}
	public AreaModel getArea() {
		return area;
	}
	public void setArea(AreaModel area) {
		this.area = area;
	}
	public BuildingTypeModel getBuildingType() {
		return buildingType;
	}
	public void setBuildingType(BuildingTypeModel buildingType) {
		this.buildingType = buildingType;
	}	
}
