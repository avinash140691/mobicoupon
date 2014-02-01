package com.mobicoupon.bean;

import com.mobicoupon.daoimpl.DepartmentBean;
import com.mobicoupon.daoimpl.DesignationBean;


public class DdmBean {
	
	private DesignationBean designationBean;
	private DepartmentBean departmentBean;
	private MerchantBean merchantBean;
	
	
	public DesignationBean getDesignationBean() {
		return designationBean;
	}
	
	public void setDesignationBean(DesignationBean designation) {
		this.designationBean = designation;
	}
	
	public DepartmentBean getDepartmentBean() {
		return departmentBean;
	}
	
	public void setDepartmentBean(DepartmentBean department) {
		this.departmentBean = department;
	}
	
	public MerchantBean getMerchantBean() {
		return merchantBean;
	}
	
	public void setMerchantBean(MerchantBean merchantBean) {
		this.merchantBean = merchantBean;
	}
	
}