package com.neusoft.wuye.baseinfo.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("Area")
public class AreaModel {
	private int no;
	private String name;
	private String aaddress;
	private String developer;
	private Double totalBuildingArea;
	private Double totalUserArea;
	private Double totalPackArea;
	private int totalHome;
	private int totalHouse;
	private int totalPack;
	
	private List<BuildingModel> buildings;
	
	public List<BuildingModel> getBuildings() {
		return buildings;
	}
	public void setBuildings(List<BuildingModel> buildings) {
		this.buildings = buildings;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAaddress() {
		return aaddress;
	}
	public void setAaddress(String aaddress) {
		this.aaddress = aaddress;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public Double getTotalBuildingArea() {
		return totalBuildingArea;
	}
	public void setTotalBuildingArea(Double totalBuildingArea) {
		this.totalBuildingArea = totalBuildingArea;
	}
	public Double getTotalUserArea() {
		return totalUserArea;
	}
	public void setTotalUserArea(Double totalUserArea) {
		this.totalUserArea = totalUserArea;
	}
	public Double getTotalPackArea() {
		return totalPackArea;
	}
	public void setTotalPackArea(Double totalPackArea) {
		this.totalPackArea = totalPackArea;
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
	public int getTotalPack() {
		return totalPack;
	}
	public void setTotalPack(int totalPack) {
		this.totalPack = totalPack;
	}
	
	
}
