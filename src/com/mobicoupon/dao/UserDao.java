package com.mobicoupon.dao;

import java.util.List;

import com.mobicoupon.bean.UserBean;
import com.mobicoupon.bean.UserEditBean;

public interface UserDao {
	
	public int add(UserBean userBean);
	
	public int update(UserEditBean userBean);
	
	public List<UserEditBean> view();
	
	public List<UserEditBean> view(String userId);
	
	public int delete(String id);
}
