package com.mobicoupon.daoimpl;

import org.hibernate.validator.constraints.NotBlank;

public class SubProductBean {
	
	@NotBlank
	private String productId;
	private String productName;
	private String subProductId;
	@NotBlank
	private String subProductName;
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSubProductId() {
		return subProductId;
	}

	public void setSubProductId(String subProductId) {
		this.subProductId = subProductId;
	}

	public String getSubProductName() {
		return subProductName;
	}

	public void setSubProductName(String subSubProductName) {
		this.subProductName = subSubProductName;
	}
	
	@Override
	public String toString() {
		
		return "<SubProduct>"
				+ "<productId>"+productId+"</productId>"
				+ "<productName>"+productName+"</productName>"
				+ "<subProductId>"+subProductId+"</subProductId>"
				+ "<subProductName>"+subProductName+"</subProductName>"
			+ "</SubProduct>";
	}

}
