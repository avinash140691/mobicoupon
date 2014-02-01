package com.mobicoupon.bean;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

public class MerchantBean4Edit {
	
	
	@Min(1)
	private int merchantId;
	@NotBlank
	private String merchantName;
	@NotBlank
	private String companyName;
	@NotBlank
	private String address;
	@Min(1)
	private int desgId;
	@NotBlank
	private String landLine;
	@Min(1)
	private int deptId;
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
	private String password;
	@NotBlank
	private String authority;
	
	private String id;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

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

	public int getDesgId() {
		return desgId;
	}

	public void setDesgId(int desgId) {
		this.desgId = desgId;
	}

	public String getLandLine() {
		return landLine;
	}

	public void setLandLine(String landLine) {
		this.landLine = landLine;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
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
