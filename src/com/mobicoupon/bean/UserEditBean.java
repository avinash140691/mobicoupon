package com.mobicoupon.bean;

import org.hibernate.validator.constraints.NotBlank;


public class UserEditBean {
	
	@NotBlank
	private String id;
	@NotBlank
	private String name;
	@NotBlank
	private String company;
	@NotBlank
	private String designation;
	@NotBlank
	private String userName;
	@NotBlank
	private String password;
	@NotBlank
	private String email;
	@NotBlank
	private String mobile;

	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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
	
	
	@Override
	public String toString() {
		return "<user>" +
					"<id>"+id+"</id>"+
					"<name>"+ name+"</name>" +
					"<company>"+company+"</company>" +
					"<designation>"+designation +"</designation>"+
					"<email>"+email+"</email>"+
					"<mobile>"+mobile+"</mobile>"+
					"<username>"+userName+"</username>"+
					"<password>"+password+"</password>"+
				"</user>";
	}

}
