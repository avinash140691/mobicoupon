package com.mobicoupon.daoimpl;

 import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mobicoupon.dao.SubSubProductDao;

@Repository("subSubProductDao")
public class SubSubProductDaoImpl implements SubSubProductDao {
	
	@Autowired
	public JdbcTemplate template;

	@Override
	public int addSubSubProduct(SubSubSubProductBean4Add subSubProductBean) {
		
		String subProductId = subSubProductBean.getSubProductId(); 
		String subSubProductName = subSubProductBean.getSubSubProductName(); 
		
		String query = "insert into sub_sub_product(sub_sub_product_name,"
					    + "sub_product_id) values(?,?)";
		
		int update = template.update(query,new Object[]{subSubProductName,subProductId});
		
		return update;
	}

	@Override
	public int editSubSubProduct(SubSubProductBean subSubProductBean) {
		
		String subSubProductId = subSubProductBean.getSubSubProductId(); 
		String subSubProductName = subSubProductBean.getSubSubProductName();  
		String query = "update sub_sub_product set sub_sub_product_name = ? where sub_sub_product_id = ?";
		int update = template.update(query,new Object[]{subSubProductName,subSubProductId});
		return update;
	}

	@Override
	public List<SubSubProductBean> viewSubSubProduct() {
		
		String query = "select "
				       +       "product.product_id, product.product_name, "
				       +       "sub_product.sub_product_id, sub_product.sub_product_name, "
				       +       "sub_sub_product.sub_sub_product_id, sub_sub_product.sub_sub_product_name "
				       + "from "
				       +       "product "
				       + "left join "
				       +       "sub_product "
				       + "on "
				       +       "product.product_id=sub_product.product_id "
				       + "left join "
				       +       "sub_sub_product "
				       + "on "
				       +       "sub_product.sub_product_id=sub_sub_product.sub_product_id";
		
		List<SubSubProductBean> list = template.query(query,new RowMapper<SubSubProductBean>(){

			@Override
			public SubSubProductBean mapRow(ResultSet rs, int arg1) throws SQLException {
				
				SubSubProductBean subSubProductBean = new SubSubProductBean(); 
				subSubProductBean.setProductId(rs.getString(1));
				subSubProductBean.setProductName(rs.getString(2));  
				subSubProductBean.setSubProductId(rs.getString(3));
				subSubProductBean.setSubProductName(rs.getString(4));
				subSubProductBean.setSubSubProductId(rs.getString(5));  
				subSubProductBean.setSubSubProductName(rs.getString(6));  
				
				return subSubProductBean;
			}
			
		});
		
		return list;
	}

	@Override
	public int deleteSubSubProduct(String subSubProductId) {
		String query = "delete from sub_sub_product where sub_sub_product_id = ?";
		int update = template.update(query, new Object[]{subSubProductId});
		return update;
	}
	
}
