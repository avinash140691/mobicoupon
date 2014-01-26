package com.mobicoupon.daoimpl;

import org.hibernate.validator.constraints.NotBlank;


public class SubSubSubProductBean4Add {
	
	@NotBlank
	private String productId;
	private String ProductName;
	private String subProductName;
	@NotBlank
	private String subProductId;
	@NotBlank
	private String subSubProductName;
	
	
	public String getProductName() {
		return ProductName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getSubProductName() {
		return subProductName;
	}
	public void setSubProductName(String subProductName) {
		this.subProductName = subProductName;
	}
	
	public String getSubProductId() {
		return subProductId;
	}
	public void setSubProductId(String subProductId) {
		this.subProductId = subProductId;
	}
	public String getSubSubProductName() {
		return subSubProductName;
	}
	public void setSubSubProductName(String subSubProductName) {
		this.subSubProductName = subSubProductName;
	}
	
	
	
	
}
