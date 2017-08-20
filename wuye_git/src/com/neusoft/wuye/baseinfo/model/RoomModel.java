package com.neusoft.wuye.baseinfo.model;

/**
 * @author oliver
 *
 */
public class RoomModel {
	private int no;
	
	private String departmentCode; //��Ԫ
	private String floor;     //¥��
	private String roomCode;  //�����
	private double buildingArea; //ʹ�����
	private double feeArea;    //�ɷ����
	private String roomStatus; //����״̬������/��ס
	private String roomType;  //�������ͣ�room סլ  house ������
	
	private HouseTypeModel houseType;  //���ݻ��ͱ��
	private BuildingModel building;    //¥����
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
