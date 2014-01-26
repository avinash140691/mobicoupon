package com.mobicoupon.daoimpl;

import org.hibernate.validator.constraints.NotBlank;

public class SubProductBean4Edit {
	private String productId;
	private String ProductName;
	@NotBlank
	private String subProductId;
	@NotBlank
	private String subProductName;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
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
	public void setSubProductName(String subProductName) {
		this.subProductName = subProductName;
	}
}
