package com.mobicoupon.daoimpl;

import org.hibernate.validator.constraints.NotBlank;

public class DesignationBean {
	private int desgId;
	@NotBlank
	private String desgName;

	public int getDesgId() {
		return desgId;
	}

	public void setDesgId(int desgId) {
		this.desgId = desgId;
	}

	public String getDesgName() {
		return desgName;
	}

	public void setDesgName(String desgName) {
		this.desgName = desgName;
	}
}
