package com.mobicoupon.daoimpl;


 import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mobicoupon.bean.DdmBean;
import com.mobicoupon.bean.MerchantAddBean;
import com.mobicoupon.bean.MerchantBean;
import com.mobicoupon.bean.MerchantBean4Edit;
import com.mobicoupon.dao.MerchantDao;

@Transactional
@Repository("merchantDao")
public class MerchnatDaoImpl implements MerchantDao {
	
	@Autowired
	public JdbcTemplate jdbcTemplate;

	@Override
	public int addMerchant(MerchantAddBean merchantBean) {
		
		String queryInsertIntoMerchant = "insert into merchant"
			 	                       + 		"(merchant_id,merchant_name ,company_name,address,desg_id,landline,dept_id,"
			 	                       + 		"mobile,corporate_email_id,website,personal_contact_num) "
			 	                       + "values(?,?,?,?,?,?,?,?,?,?,?) ";
		
		String  queryInsertIntoLogin = " insert into login(username,password,authority) values(?,?,?)";
		
		String merchantName = merchantBean.getMerchantName();  
		String companyName = merchantBean.getCompanyName();  
		String address = merchantBean.getAddress(); 
		String desgId = merchantBean.getDesgId();  
		String landLine = merchantBean.getLandLine(); 
		String deptId = merchantBean.getDeptId();  
		String mobile = merchantBean.getMobile();
		String corporateEmailId = merchantBean.getCorporateEmailId();  
		String website = merchantBean.getWebsite(); 
		String personalContactNum = merchantBean.getPersonalContactNum();   
		
		String userName = merchantBean.getUserName();
		String password = merchantBean.getPassword();
		String authority = merchantBean.getAuthority();
		
		
		int update2 = jdbcTemplate.update(queryInsertIntoLogin, new Object[]{userName,password,authority});
		
		List<String> list = jdbcTemplate.query("select id from login where username=?", new Object[]{userName}, new RowMapper<String>(){

			@Override
			public String mapRow(ResultSet rs, int row) throws SQLException {
				return rs.getString("id");
			}
		});
		
		
		int update = jdbcTemplate.update(queryInsertIntoMerchant,new Object[]{list.get(0),merchantName,companyName,address,
											desgId,landLine,deptId,mobile,corporateEmailId,website,personalContactNum});

		if(update > 0 && update2 > 0){
		
			return 1;
		}

		return 0;
	}

	@Override
	public int editMerchant(MerchantBean4Edit merchantBean) {
		
		String merchantId = merchantBean.getMerchantId();
		String merchantName = merchantBean.getMerchantName();  
		String companyName = merchantBean.getCompanyName();  
		String address = merchantBean.getAddress(); 
		int desgId = merchantBean.getDesgId();  
		String landLine = merchantBean.getLandLine(); 
		int deptId = merchantBean.getDeptId();  
		String mobile = merchantBean.getMobile();
		String corporateEmailId = merchantBean.getCorporateEmailId();  
		String website = merchantBean.getWebsite(); 
		String personalContactNum = merchantBean.getPersonalContactNum();   
		
		String userName = merchantBean.getUserName();
		String password = merchantBean.getPassword();
		String authority = merchantBean.getAuthority();
		
		String updateQuery4Merchant = "update merchant set merchant_name = ?,address = ? ,desg_id = ? ,landline=?, "
									+ 	" dept_id=?, mobile=?, corporate_email_id=?, website=?, personal_contact_num=?, company_name=? "
									+ "where "
									+ 	"merchant_id = ? ";
		
		String updateQuery4Login = "update login set username = ? , password = ?,authority = ? where id = ? ";
		
		
		int update2 = jdbcTemplate.update(updateQuery4Login, new Object[]{userName,password,authority,merchantId});
		
		int update = jdbcTemplate.update(updateQuery4Merchant, new Object[]{merchantName,address,desgId,landLine
							,deptId,mobile,corporateEmailId,website,personalContactNum,companyName,merchantId});
		
		 
		
		if(update > 0 && update2 > 0){
			
			return 1;
		}
		
		return 0;
	}

	@Override
	public List<DdmBean> viewMerchant(String merchantId) {
		
		String merchantViewQuery = "select merchant.merchant_id, merchant.merchant_name, merchant.address, designation.desg_id, designation.desg_name, merchant.landline, department.dept_id, department.dept_name, "
								 +		"merchant.corporate_email_id, merchant.website, merchant.company_name, merchant.mobile, merchant.personal_contact_num, "
								 +		"login.username, login.password, login.authority  "
								 +	"from "
								 + 		"merchant "
								 +	"left outer join "
								 +		"login "
								 +	"on "
								 +		"merchant.merchant_id = login.id "
								 +	"left outer join "
								 +		"department "
								 +	"on "
								 +		"merchant.dept_id = department.dept_id "
								 +	"left outer join "
								 +		"designation "
								 +	"on "
								 +		"merchant.desg_id = designation.desg_id "
								 +	  "where "
								 +		"merchant.merchant_id = ? ";
		
		List<DdmBean> list = jdbcTemplate.query(merchantViewQuery,new Object[]{merchantId} ,new RowMapper<DdmBean>(){

			@Override
			public DdmBean mapRow(ResultSet rs, int arg1) throws SQLException {
				DdmBean ddmBean = new DdmBean();
				
				MerchantBean merchantBean4Edit = new MerchantBean();  
				
				
				merchantBean4Edit.setMerchantId( rs.getInt("merchant_id"));;
				merchantBean4Edit.setMerchantName(rs.getString("merchant_name"));
				merchantBean4Edit.setAddress(rs.getString("address"));
				merchantBean4Edit.setMobile(rs.getString("mobile"));
				merchantBean4Edit.setLandLine(rs.getString("landline"));
				merchantBean4Edit.setCorporateEmailId(rs.getString("corporate_email_id"));
				merchantBean4Edit.setWebsite(rs.getString("website"));
				merchantBean4Edit.setPersonalContactNum(rs.getString("personal_contact_num"));
				merchantBean4Edit.setCompanyName(rs.getString("company_name"));
				merchantBean4Edit.setAuthority(rs.getString("authority"));
				merchantBean4Edit.setUserName(rs.getString("username"));
				merchantBean4Edit.setPassword(rs.getString("password"));
				merchantBean4Edit.setDeptName(rs.getString("dept_name"));
				merchantBean4Edit.setDesgName(rs.getString("desg_name"));
				merchantBean4Edit.setDeptId(rs.getString("dept_id"));
				merchantBean4Edit.setDesgId(rs.getString("desg_id"));
				
				
				DepartmentBean departmentBean = new DepartmentBean();
				departmentBean.setDeptId(rs.getInt("dept_id"));
				departmentBean.setDeptName(rs.getString("dept_name"));
				
				DesignationBean designationBean = new DesignationBean();
				designationBean.setDesgId(rs.getInt("desg_id"));
				designationBean.setDesgName(rs.getString("desg_name"));
				
				ddmBean.setMerchantBean(merchantBean4Edit);
				ddmBean.setDepartmentBean(departmentBean); 
				ddmBean.setDesignationBean(designationBean); 
				
				return ddmBean;
			}
			
		});
		
		return list;
	}

	@Override
	public int deleteMerchant(String merchantId) {
		
		String deleteQuery4Merchant = "delete from merchant where merchant_id = ?";
		String  deleteQuery4Login = "delete from login where id = ?";
		
		int update2 = jdbcTemplate.update(deleteQuery4Merchant,new Object[]{merchantId});
		int update = jdbcTemplate.update(deleteQuery4Login, new Object[]{merchantId});
		
		
		if(update2 < 0 && update < 0 ){
			
			return 0;
		}
		
		return 1;
	}

	@Override
	public List<MerchantBean4Edit> PartOfView() {
		
		String partOfViewQuery = "select "
				                 +		"merchant_id,merchant_name ,company_name ,mobile ,corporate_email_id ,username,authority  "
				                 + "from "
				                 +  	"merchant "
				                 +"left join "
				                 + 		"login "
				                 +"on "
				                 + 		"merchant.merchant_id = login.id  ";
	
		List<MerchantBean4Edit> merchantBean = jdbcTemplate.query(partOfViewQuery,new RowMapper<MerchantBean4Edit>(){

			@Override
			public MerchantBean4Edit mapRow(ResultSet rs, int row) throws SQLException {
				
				MerchantBean4Edit mbe = new MerchantBean4Edit();
				mbe.setMerchantId(rs.getString("merchant_id"));
				mbe.setMerchantName(rs.getString("merchant_name"));
				mbe.setCompanyName(rs.getString("company_name"));
				mbe.setMobile(rs.getString("mobile"));
				mbe.setAuthority(rs.getString("authority"));
				mbe.setUserName(rs.getString("username"));
				mbe.setCorporateEmailId(rs.getString("corporate_email_id"));
				
				
				return mbe;
			} 
			
		});
		
		return merchantBean;
		
		
	}

	@Override
	public int mobileView(String mobile) {
		
		String mobileQuery = "select count(*) from merchant where mobile = ?";
		
		Integer count = jdbcTemplate.query(mobileQuery, new Object[]{mobile}, new ResultSetExtractor<Integer>(){

			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next())
					return rs.getInt(1);
				return -1;
			}
			
		});
		return count.intValue();
	}

	@Override
	public int landlLineView(String landline) {
		
		String landlineQuery = "select count(*) from merchant where landline= ?";
		
		Integer count = jdbcTemplate.query(landlineQuery,new Object[]{landline},new ResultSetExtractor<Integer>(){

			@Override
			public Integer extractData(ResultSet rs) throws SQLException,DataAccessException {
				
				if(rs.next())
					return rs.getInt(1);
				
				return -1;
			}
			
		});
		
		return count.intValue();
	}

	@Override
	public int emailView(String email) {
		String emailQuery = "select count(*) from merchant where corporate_email_id = ?";
	
		Integer count = jdbcTemplate.query(emailQuery,new Object[]{email},new ResultSetExtractor<Integer>(){

			@Override
			public Integer extractData(ResultSet rs) throws SQLException,DataAccessException {
			
				if(rs.next())
					return rs.getInt(1);
			
				return -1;
			}
		
	});
	
	return count.intValue();

	}

	@Override
	public int personalContactView(String personalContactNum) {
		
		String pcQuery = "select count(*) from merchant  where personal_contact_num = ? ";
		
		Integer count = jdbcTemplate.query(pcQuery,new Object[]{personalContactNum},new ResultSetExtractor<Integer>(){

			@Override
			public Integer extractData(ResultSet rs) throws SQLException,DataAccessException {
				
				if(rs.next())
					return rs.getInt(1);
				
				return -1;
			}
			
		});
		return count;
	}

	@Override
	public int mobileUpdateView(String merchantId, String mobile) {
		
		String mobileQuery = "select count(*) from merchant where mobile = ? and merchant_id != ?";
		
		Integer count = jdbcTemplate.query(mobileQuery, new Object[]{mobile , merchantId}, new ResultSetExtractor<Integer>(){

			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next())
					return rs.getInt(1);
				return -1;
			}
			
		});
		return count.intValue();
	}

	@Override
	public int landLineUpdateView(String merchantId, String landLine) {
		String landlineQuery = "select count(*) from merchant where landline= ? and merchant_id != ?";
		
		Integer count = jdbcTemplate.query(landlineQuery,new Object[]{landLine ,merchantId},new ResultSetExtractor<Integer>(){

			@Override
			public Integer extractData(ResultSet rs) throws SQLException,DataAccessException {
				
				if(rs.next())
					return rs.getInt(1);
				
				return -1;
			}
			
		});
		
		return count.intValue();

	}

	@Override
	public int emailUpdateView(String merchantId, String email) {
		String emailQuery = "select count(*) from merchant where corporate_email_id = ? and merchant_id != ?";
		
		Integer count = jdbcTemplate.query(emailQuery,new Object[]{email,merchantId},new ResultSetExtractor<Integer>(){

			@Override
			public Integer extractData(ResultSet rs) throws SQLException,DataAccessException {
			
				if(rs.next())
					return rs.getInt(1);
			
				return -1;
			}
		
	});
	
	return count.intValue();

	}

	@Override
	public int personalContactUpdateView(String merchantId,String personalContactNum) {
		
		String pcQuery = "select personal_contact_num from merchant where personal_contact_num = ? and merchant_id != ? ";
		
		Integer count = jdbcTemplate.query(pcQuery, new Object[]{personalContactNum,merchantId},new ResultSetExtractor<Integer>(){

			@Override
			public Integer extractData(ResultSet rs) throws SQLException,DataAccessException {
				
				if(rs.next())
					return rs.getInt(1);
				
				return -1;
			}
			
		});
		return count;
	}

	@Override
	public List<MerchantBean4Edit> viewMerchant() {
		String partOfViewQuery = "select "
							+		"merchant_id,merchant_name,address,company_name,department.dept_id,designation.desg_id,desg_name, "
							+		"corporate_email_id,landline,mobile,personal_contact_num,website, "
							+		"login.id,username,password,authority " 
							+	"from   "
							+ 		"merchant " 
							+	"left join "  
							+		"login " 
							+	"on "  
							+		"merchant.merchant_id = login.id " 
							+	"left join "  
							+		"department "
							+	"on "    
							+		"merchant.dept_id = department.dept_id "  
							+	"left join " 
							+		"designation " 
							+	"on " 
							+		"merchant.desg_id = designation.desg_id ";

				List<MerchantBean4Edit> merchantBean = jdbcTemplate.query(partOfViewQuery,new RowMapper<MerchantBean4Edit>(){
				
					@Override
					public MerchantBean4Edit mapRow(ResultSet rs, int row) throws SQLException {
					
						MerchantBean4Edit mbe = new MerchantBean4Edit();
						
						mbe.setMerchantId(rs.getString("merchant_id"));
						mbe.setMerchantName(rs.getString("merchant_name"));
						mbe.setAddress(rs.getString("address"));
						mbe.setCompanyName(rs.getString("company_name"));
						mbe.setDesgId(rs.getInt("desg_id"));
						mbe.setDesgName(rs.getString("desg_name"));
						mbe.setDeptId(rs.getInt("dept_id"));
						mbe.setDeptName(rs.getString("desg_name"));
						mbe.setCorporateEmailId(rs.getString("corporate_email_id"));
						mbe.setMobile(rs.getString("mobile"));
						mbe.setPersonalContactNum(rs.getString("personal_contact_num"));
						mbe.setWebsite(rs.getString("website"));
						mbe.setId(rs.getString("id"));
						mbe.setUserName(rs.getString("username"));
						mbe.setPassword(rs.getString("password"));
						mbe.setAuthority(rs.getString("authority"));
						
						return mbe;
					} 
					
					});
				
				return merchantBean;
			}



}
 