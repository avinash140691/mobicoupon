package com.mobicoupon.dao;

import java.util.List;

import com.mobicoupon.bean.MerchantBean;

public interface MerchantDao {
	
	public int addMerchant(MerchantBean merchantBean);
	
	public int editMerchant(MerchantBean merchantBean);
	
	public List<MerchantBean> viewMerchant();
	
	public int deleteMerchant(String merchantId);
 }
