package com.mobicoupon.dao;

import java.util.List;

import com.mobicoupon.daoimpl.SubProductBean;
import com.mobicoupon.daoimpl.SubProductBean4Edit;

public interface SubProductDao {
	
	public int addSubProduct(SubProductBean subProductBean);
	
	public int editSubProduct(SubProductBean4Edit subProductBean);
	
	public List<SubProductBean> viewSubProduct();
	
	public int deleteSubProduct(String subProductId);

	public List<SubProductBean> viewSubProduct(String productId);

}
