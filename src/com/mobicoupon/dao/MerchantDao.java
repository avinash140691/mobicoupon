package com.mobicoupon.dao;


 import java.util.List;

import com.mobicoupon.bean.DdmBean;
import com.mobicoupon.bean.MerchantAddBean;
import com.mobicoupon.bean.MerchantBean4Edit;

public interface MerchantDao {
	
	public int addMerchant(MerchantAddBean merchantBean);
	
	public int editMerchant(MerchantBean4Edit merchantBean);
	
	public List<DdmBean> viewMerchant(int merchantId);
	
	public int deleteMerchant(String merchantId);
	
	public List<MerchantBean4Edit> PartOfView();
	
	public int mobileView(String mobile);
	
	public int landlLineView(String landline);
	
	public int emailView(String email);
	
	public int personalContactView(String personalContactNum);
 }
