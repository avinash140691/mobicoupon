package com.mobicoupon.daoimpl;

import org.hibernate.validator.constraints.NotBlank;


public class DepartmentBean {

	private int deptId;
	
	@NotBlank
	private String deptName;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
