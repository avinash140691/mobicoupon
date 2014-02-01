package com.mobicoupon.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mobicoupon.bean.UserBean;
import com.mobicoupon.bean.UserEditBean;
import com.mobicoupon.dao.UserDao;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	public  JdbcTemplate template;
	
	@Override
	public int add(UserBean userBean) {
		
		String userName = userBean.getUserName(); 
		String name = userBean.getName();  
		String company = userBean.getCompany(); 
		String password = userBean.getPassword(); 
		String designation = userBean.getDesignation();
		String mobile = userBean.getMobile(); 
		String email = userBean.getEmail();
		
		String query = "insert into "
						+ 	"user(name,company,designation,mobile,email,user_name,password) "
						+ 	"values(?,?,?,?,?,?,?)";
		
		int update = template.update(query,new Object[]{name,company,designation,mobile,email,userName,password});
		return update;
	}

	@Override
	public int update(UserEditBean userBean) {
		
		String id = userBean.getId();
		String userName = userBean.getUserName(); 
		String name = userBean.getName();  
		String company = userBean.getCompany(); 
		String password = userBean.getPassword(); 
		String designation = userBean.getDesignation();
		String mobile = userBean.getMobile(); 
		String email = userBean.getEmail();
		
		String query = "update user set user_name = ? , name = ? , company = ? , password = ? , "
					  +     "designation = ?  , mobile = ? , email = ? "
					  + 	" where id = ? ";
		int update = template.update(query,new Object[]{userName,name,company,password,designation,mobile,email,id});
		
		return update;
	}

	@Override
	public List<UserEditBean> view() {
		
		String query = "select name , company , designation , mobile , email , user_name ,password "
					 +  " , id from user ";
		List<UserEditBean> list = template.query(query, new RowMapper<UserEditBean>(){

			@Override
			public UserEditBean mapRow(ResultSet rs, int row)
					throws SQLException {
				
				UserEditBean userEditBean = new UserEditBean();
				
				userEditBean.setId(rs.getString("id"));
				userEditBean.setName(rs.getString("name"));
				userEditBean.setCompany(rs.getString("company"));
				userEditBean.setDesignation(rs.getString("designation"));
				userEditBean.setEmail(rs.getString("email"));
				userEditBean.setMobile(rs.getString("mobile"));
				userEditBean.setUserName(rs.getString("user_name"));
				userEditBean.setPassword(rs.getString("password"));
				
				return userEditBean;
			}
			
			
		});
		
		
		return list;
	}

	@Override
	public List<UserEditBean> view(String id) {
		
		String query = "select name , company , designation , mobile , email , user_name "
				 +  "id from user where id = ?";
	List<UserEditBean> list = template.query(query,new Object[]{id}  ,new RowMapper<UserEditBean>(){

		@Override
		public UserEditBean mapRow(ResultSet rs, int row)
				throws SQLException {
			
			UserEditBean userEditBean = new UserEditBean();
			
			userEditBean.setId(rs.getString("id"));
			userEditBean.setName(rs.getString("name"));
			userEditBean.setCompany(rs.getString("company"));
			userEditBean.setDesignation(rs.getString("designation"));
			userEditBean.setEmail(rs.getString("email"));
			userEditBean.setMobile(rs.getString("mobile"));
			userEditBean.setUserName(rs.getString("user_name"));
			userEditBean.setPassword(rs.getString("password"));
			
			return userEditBean;
		}
		
		
	});
	
	
	return list;

	}

	@Override
	public int delete(String id) {
		
		String query = "delete from user where id = ? ";
		int update = template.update(query , new Object[]{id});  
		
		return update;
	}

}
