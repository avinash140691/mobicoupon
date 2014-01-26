package com.mobicoupon.dao;

import java.util.List;

import com.mobicoupon.daoimpl.ProductBean;

public interface ProductDao {

	public int addProduct(String productName);

	public int editProduct(String productName,String productId);
	
	public List<ProductBean> viewProduct();

	public int deleteProduct(String productId);
}
