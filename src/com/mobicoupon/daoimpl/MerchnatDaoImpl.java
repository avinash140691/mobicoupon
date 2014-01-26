package com.mobicoupon.daoimpl;

import java.util.List;

import com.mobicoupon.bean.MerchantBean;
import com.mobicoupon.dao.MerchantDao;

public class MerchnatDaoImpl implements MerchantDao {

	@Override
	public int addMerchant(MerchantBean merchantBean) {
		
		String queryInsertIntoMerchant = "insert into merchant "
			 	                       + "values(merchnat_name ,company_id,address,desg_id,landline,dept_id,"
			 	                       + "mobile,corporate_email_id,website,personal_contact_num ) ";
		return 0;
	}

	@Override
	public int editMerchant(MerchantBean merchantBean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MerchantBean> viewMerchant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteMerchant(String merchantId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
