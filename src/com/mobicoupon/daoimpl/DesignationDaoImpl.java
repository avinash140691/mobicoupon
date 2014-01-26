 package com.mobicoupon.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mobicoupon.dao.DesignationDao;

@Repository("designationDao")
public class DesignationDaoImpl implements DesignationDao {

	@Autowired
	private JdbcTemplate template;

	@Override
	public List<DesignationBean> viewDesignations() {
		String query = "select desg_id,desg_name from designation";
		List<DesignationBean> designationBean = template.query(query,
				new RowMapper<DesignationBean>() {

					@Override
					public DesignationBean mapRow(ResultSet rs, int arg1)
							throws SQLException {
						DesignationBean desgBean = new DesignationBean();
						desgBean.setDesgId(rs.getInt("desg_id"));
						desgBean.setDesgName(rs.getString("desg_name"));
						return desgBean;
					}

				});
		return designationBean;

	}

	@Override
	public int editDesignation(DesignationBean bean) {
		int desgId = bean.getDesgId();
		String desgName = bean.getDesgName();
		String query = "update designation set desg_name=? where desg_id=?";
		int count = template.update(query, new Object[] { desgName, desgId });
		return count;
	}

	@Override
	public int addDesignation(DesignationBean bean) {
		String desg = bean.getDesgName();
		System.out.println(desg);
		String query = "insert into designation(desg_name) values(?)";
		int count = template.update(query, new Object[] { desg });
		return count;
	}

	@Override
	public int deleteDesignation(String id) {
		String query = "delete from designation where desg_id=?";
		int count = template.update(query, new Object[]{id});
		return count;
	}
	
	

}
