package com.mobicoupon.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mobicoupon.dao.SubProductDao;

@Repository("subProductDao")
public class SubProductDaoImpl implements SubProductDao {
	
	@Autowired
	public JdbcTemplate template;
	
	@Override
	public int addSubProduct(SubProductBean subProductBean) {
		
		String productId = subProductBean.getProductId();
		String subProductName = subProductBean.getSubProductName();
		
		String query = "insert into sub_product(product_id,sub_product_name) values (?,?) ";
		int update = template.update(query,new Object[]{productId,subProductName});
		return update;
	}

	@Override
	public int editSubProduct(SubProductBean4Edit subProductBean) {
		
		String subProductId = subProductBean.getSubProductId();
		String subProductName = subProductBean.getSubProductName();
		String query = "update sub_product set sub_product_name = ? "
				+ "where sub_product_id = ?";
		
		int update = template.update(query,new Object[]{subProductName,subProductId});
		return update;
	}

	@Override
	public List<SubProductBean> viewSubProduct() {
		String query = "select product.product_id, product.product_name,sub_product.sub_product_id,"
				+ "sub_product.sub_product_name from product left join sub_product  on "
				+ "product.product_id = sub_product.product_id";
		 List<SubProductBean> query2 = template.query(query,new RowMapper<SubProductBean>(){

			@Override
			public SubProductBean mapRow(ResultSet rs, int arg1)
					throws SQLException {
				
				SubProductBean subProductBean = new SubProductBean();
				subProductBean.setProductId(rs.getString("product_id"));
				subProductBean.setSubProductId(rs.getString("sub_product_id"));
				subProductBean.setProductName(rs.getString("product_name"));
				subProductBean.setSubProductName(rs.getString("sub_product_name"));
				
				return subProductBean;
			}
			
		});
		return query2;
	}

	@Override
	public int deleteSubProduct(String subProductId) {
		String query = "delete from sub_product where sub_product_id = ? ";
		int update = template.update(query,new Object[]{subProductId});
		return update;
	}

	@Override
	public List<SubProductBean> viewSubProduct(String productId) {
		String query = "select * from sub_product where product_id=?";
		 List<SubProductBean> query2 = template.query(query,new Object[]{productId},new RowMapper<SubProductBean>(){

			@Override
			public SubProductBean mapRow(ResultSet rs, int arg1)
					throws SQLException {
				
				SubProductBean subProductBean = new SubProductBean();
				subProductBean.setSubProductId(rs.getString("sub_product_id"));
				subProductBean.setSubProductName(rs.getString("sub_product_name"));
				
				return subProductBean;
			}
			
		});
		return query2;
	}

}
