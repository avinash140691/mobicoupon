package com.mobicoupon.dao;

import java.util.List;

import com.mobicoupon.daoimpl.SubSubProductBean;
import com.mobicoupon.daoimpl.SubSubSubProductBean4Add;

public interface SubSubProductDao {
	
	public int addSubSubProduct(SubSubSubProductBean4Add subSubProductBean);
	
	public int editSubSubProduct(SubSubProductBean subSubProductBean);
	
	public List<SubSubProductBean> viewSubSubProduct();
	
	public int deleteSubSubProduct(String subSubProductId);


}
