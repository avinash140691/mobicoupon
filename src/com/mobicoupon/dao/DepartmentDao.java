package com.mobicoupon.dao;

import java.util.List;

import com.mobicoupon.daoimpl.DepartmentBean;

public interface DepartmentDao {
	public List<DepartmentBean> getDepartments();
	public void addDept(DepartmentBean bean);
	public void editDept(DepartmentBean editBean);
	public void removeDept(String id);
}
