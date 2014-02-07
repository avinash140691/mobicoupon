package com.mobicoupon.daoimpl;

import org.hibernate.validator.constraints.NotBlank;



public class SubSubProductBean {
	
	private String productId;
	private String ProductName;	
	private String subProductId;
	private String subProductName;
	@NotBlank
	private String subSubProductId;
	@NotBlank
	private String subSubProductName;
	
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
	
	public String getSubSubProductId() {
		return subSubProductId;
	}
	public void setSubSubProductId(String subSubProductId) {
		this.subSubProductId = subSubProductId;
	}
	
	public String getSubSubProductName() {
		return subSubProductName;
	}
	public void setSubSubProductName(String subSubProductName) {
		this.subSubProductName = subSubProductName;
	}
	
	@Override
	public String toString() {
		return "<SubSubProduct>"
				+ "<productId>"+productId+"</productId>"
				+ "<productName>"+ProductName+"</productName>"
				+ "<subProductId>"+subProductId+"</subProductId>"
				+ "<subProductName>"+subProductName+"</subProductName>"
				+ "<subSubProductId>"+subSubProductId+"</subSubProductId>"
				+ "<subSubProductName>"+subSubProductName+"</subSubProductName>"
			+ "</SubSubProduct>";
	}
	
	
}
