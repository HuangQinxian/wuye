package com.neusoft.wuye.baseinfo.model;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	//入住日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date startDate;
	
	
	// 文件上传
	private byte[] photo;
	private String photoFileName;
	private String photoContentType;
	
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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
