package com.mobicoupon.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mobicoupon.dao.ProductDao;


@Repository("productDao")
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	public JdbcTemplate  template;
	
	@Override
	public int addProduct(String productName) {
		String query = "insert into product(product_name) values(?)";
		int count	= template.update(query, new Object[]{productName});
		return count;
	}

	@Override
	public int editProduct(String productName ,String productId) {
		String query = "update product set product_name=? where product_id=? ";
		int count = template.update(query,new Object[]{productName,productId});
		return count;
	}
	
	@Override
	public List<ProductBean> viewProduct(){
		String query = "select product_id,product_name from product";
		List<ProductBean> list = template.query(query,new RowMapper<ProductBean>() {

			@Override
			public ProductBean mapRow(ResultSet rs, int arg1) throws SQLException {
				ProductBean pb = new ProductBean();
				pb.setProductId(rs.getString("Product_id"));
				pb.setProductName(rs.getString("product_name"));
				return pb;
			}
		});
		return list;
	}
	
	@Override
	public int deleteProduct(String productId) {
		String query = "delete from product where product_id = ?";
		int count = template.update(query,new Object[]{productId});
		return count;
	}

}
