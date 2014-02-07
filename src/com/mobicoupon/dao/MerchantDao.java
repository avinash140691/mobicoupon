package com.mobicoupon.dao;


 import java.util.List;

import com.mobicoupon.bean.DdmBean;
import com.mobicoupon.bean.MerchantAddBean;
import com.mobicoupon.bean.MerchantBean4Edit;

public interface MerchantDao {
	
	public int addMerchant(MerchantAddBean merchantBean);
	
	public int editMerchant(MerchantBean4Edit merchantBean);
	
	public List<DdmBean> viewMerchant(String merchantId);
	
	public List<MerchantBean4Edit> viewMerchant();
	
	public int deleteMerchant(String merchantId);
	
	public List<MerchantBean4Edit> PartOfView();
	
	public int mobileView(String mobile);
	
	public int landlLineView(String landline);
	
	public int emailView(String email);
	
	public int personalContactView(String personalContactNum);
	
	public int mobileUpdateView(String merchantId , String mobile);
	
	public int landLineUpdateView(String merchantId , String landLine);
	
	public int emailUpdateView(String merchantId, String email);
	
	public int personalContactUpdateView(String merchantId , String personalContactNum);
	
 }
