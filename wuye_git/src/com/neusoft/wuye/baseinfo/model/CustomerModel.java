package com.neusoft.wuye.baseinfo.model;

import java.util.Date;

public class CustomerModel {
	private String ccode;
	private String cname;
	private String contact;
	private String cardCode;
	private String mobile;
	private String tel;
	private String fax;
	private String qq;
	private String weixin;
	private Date feeStartDate;
	private Date feeEndDate;
	
	private CustomerTypeModel customerType;
	
	public CustomerTypeModel getCustomerType() {
		return customerType;
	}
	public void setCustomerType(CustomerTypeModel customerType) {
		this.customerType = customerType;
	}
	public String getCcode() {
		return ccode;
	}
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCardCode() {
		return cardCode;
	}
	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
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
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public Date getFeeStartDate() {
		return feeStartDate;
	}
	public void setFeeStartDate(Date feeStartDate) {
		this.feeStartDate = feeStartDate;
	}
	public Date getFeeEndDate() {
		return feeEndDate;
	}
	public void setFeeEndDate(Date feeEndDate) {
		this.feeEndDate = feeEndDate;
	}
}
