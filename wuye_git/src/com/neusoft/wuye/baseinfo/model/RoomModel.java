package com.neusoft.wuye.baseinfo.model;

/**
 * @author oliver
 *
 */
public class RoomModel {
	private int no;
	
	private String departmentCode; //单元
	private String floor;     //楼层
	private String roomCode;  //房间号
	private double buildingArea; //使用面积
	private double feeArea;    //缴费面积
	private String roomStatus; //房间状态（空闲/入住
	private String roomType;  //房间类型（room 住宅  house 公建）
	
	private HouseTypeModel houseType;  //房屋户型编号
	private BuildingModel building;    //楼宇编号
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	public double getBuildingArea() {
		return buildingArea;
	}
	public void setBuildingArea(double buildingArea) {
		this.buildingArea = buildingArea;
	}
	public double getFeeArea() {
		return feeArea;
	}
	public void setFeeArea(double feeArea) {
		this.feeArea = feeArea;
	}
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public HouseTypeModel getHouseType() {
		return houseType;
	}
	public void setHouseType(HouseTypeModel houseType) {
		this.houseType = houseType;
	}
	public BuildingModel getBuilding() {
		return building;
	}
	public void setBuilding(BuildingModel building) {
		this.building = building;
	}
	
	
	
}
