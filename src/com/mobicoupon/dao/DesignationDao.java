package com.mobicoupon.dao;

import java.util.List;

import com.mobicoupon.daoimpl.DesignationBean;

public interface DesignationDao {

	public List<DesignationBean> viewDesignations();

	public int editDesignation(DesignationBean designationBean);

	public int addDesignation(DesignationBean designationBean);

	public int deleteDesignation(String id);

}
