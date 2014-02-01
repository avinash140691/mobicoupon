package com.mobicoupon.bean;

import org.hibernate.validator.constraints.NotBlank;

public class MerchantAddBean {
	
	@NotBlank
	private String merchantName;
	@NotBlank
	private String companyName;
	@NotBlank
	private String address;
	@NotBlank
	private String  desgId;
	@NotBlank
	private String landLine;
	@NotBlank
	private String deptId;
	@NotBlank
	private String mobile;
	@NotBlank
	private String corporateEmailId;
	@NotBlank
	private String website;
	@NotBlank
	private String personalContactNum;
	@NotBlank
	private String userName;
	@NotBlank
	private  String password;
	@NotBlank
	private String authority;
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesgId() {
		return desgId;
	}
	public void setDesgId(String desgId) {
		this.desgId = desgId;
	}
	public String getLandLine() {
		return landLine;
	}
	public void setLandLine(String landLine) {
		this.landLine = landLine;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCorporateEmailId() {
		return corporateEmailId;
	}
	public void setCorporateEmailId(String corporateEmailId) {
		this.corporateEmailId = corporateEmailId;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getPersonalContactNum() {
		return personalContactNum;
	}
	public void setPersonalContactNum(String personalContactNum) {
		this.personalContactNum = personalContactNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	

}
