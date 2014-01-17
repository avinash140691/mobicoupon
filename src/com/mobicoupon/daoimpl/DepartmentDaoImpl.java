package com.mobicoupon.daoimpl;

 import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.mobicoupon.dao.DepartmentDao;

@Repository("departmentDao")
public class DepartmentDaoImpl implements DepartmentDao{

	@Autowired
	public JdbcTemplate template;
	
	public List<DepartmentBean> getDepartments() {
		String query = "select dept_id,dept_name from department";
		
		List<DepartmentBean>  departments =template.query(query, new RowMapper<DepartmentBean>(){

			@Override
			public DepartmentBean mapRow(ResultSet rs, int arg1) throws SQLException {
				DepartmentBean departmentBean = new DepartmentBean();
				departmentBean.setDeptId(rs.getInt("dept_id"));
				departmentBean.setDeptName(rs.getString("dept_name"));
				return departmentBean;
			}		
		});
		return departments;
	}
	
	public void addDept(DepartmentBean bean) {
		String deptName = bean.getDeptName();
		
		String query = "insert into department(dept_name) values(?)";
	    template.update(query, new Object[]{deptName});
	
	}

	public void editDept(DepartmentBean editBean) {
		String deptName = editBean.getDeptName();
		int deptId = editBean.getDeptId();	
		System.out.println(deptId);
		System.out.println(deptName);
		
		String query = "update department set dept_name=? where dept_id=?";
		template.update(query,new Object[]{deptName,deptId});		
	}

	public void removeDept(String id) {
		String query = "delete from department where dept_id=?";
		template.update(query,new Object[]{id});
		
	}
	
}