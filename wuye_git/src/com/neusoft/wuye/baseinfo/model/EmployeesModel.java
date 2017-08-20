package com.neusoft.wuye.baseinfo.model;

import java.util.Date;

public class EmployeesModel {
	private String empID;         //员工编号
	private String empName;     //员工姓名
	private String sex;    //性别
	private int age;  
	private Date joinDate;  //入职日期
	private String job;       //职位
	private String mobile;    //手机
	private String tel;       //电话
	private String qq;
	private String wx;
	
	private DepartmentsModel dept; //部门序号
	
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public DepartmentsModel getDept() {
		return dept;
	}
	public void setDept(DepartmentsModel dept) {
		this.dept = dept;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWx() {
		return wx;
	}
	public void setWx(String wx) {
		this.wx = wx;
	}
	
}
