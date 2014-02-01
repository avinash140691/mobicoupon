<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Dash Board</title>
		<link href='<c:url value="/web/css/style.css"/>' rel="stylesheet"
			type="text/css" />
		<script src='<c:url value="/web/js/jquery.min.js"></c:url>'></script>
		<script type="text/javascript">
		
		$(document).ready(function(){
			
			<c:if test="${not empty updateFormErrors}" >
				
				<c:forEach items="${updateFormErrors}" var="list">
					
					var id = "#updateForm #${list.field}";
					var msg = "${list.defaultMessage}";
					
					$(id).after("<span style='color:red'>"+msg+"</span>");
					
				</c:forEach>
				
			</c:if>
		});
		
		</script>  
	</head>
	
	<body>
		<div class="container">
		
			<div class="header">
				<jsp:include page="adminheader.jsp"></jsp:include>
				<div class="merchantEditForm" id="merchantEditForm">
					<form action='<c:url value="/admin/updateMerchant"></c:url>' name="updateForm" id="updateForm" method="post">
										
						<table>
								<c:forEach items="${viewMerchant}" var="list">
								<tr>
									<td>ID</td>
									<td><input type="text" value="${list.merchantBean.merchantId} " name="merchantId"  id="merchantId" readonly="readonly"/></td>
								</tr>
								
								<tr>
									<td>Name</td>
									<td><input type="text" value="${list.merchantBean.merchantName}" name="merchantName" id="merchantName"/></td>
								</tr>
								
								<tr>
									<td>CompanyName</td>
									<td><input type="text" value="${list.merchantBean.companyName}"name="companyName" id="companyName"></td>
								</tr>
								
								<tr>
									
								
								<tr>
									<td>Address</td>
									<td><input type="text" value="${list.merchantBean.address}" name="address" id="address"/> </td>
								</tr>
								
								<tr>
									<td>Mobile</td>
									<td><input type="text" value="${list.merchantBean.mobile }" name="mobile" id="mobile"> </td>
								</tr>
								
								<tr>
									<td>Phone</td>
									<td><input type="text" value="${list.merchantBean.landLine}" name="landLine" id="landLine"></td>
								</tr>
								
								<tr>
									<td>email</td>
									<td><input type="text" value="${list.merchantBean.corporateEmailId}"  name="corporateEmailId" id="corporateEmailId" /></td>
								</tr>
								
								<tr>
									<td>Website</td>
									<td><input type="text" value="${list.merchantBean.website}" name="website" id="website" /></td>
								</tr>
								
								<tr>
									<td>username</td>
									<td><input type="text" value="${list.merchantBean.userName}" name="userName" id="userName"/></td>
								</tr>
								
								<tr>
									<td>password</td>
									<td><input type="password" value="${list.merchantBean.password}" name="password" id="password" /></td>
								</tr>
								
								<tr>
									<td>Authority</td>
									<td>
										<select id="authority" name="authority">
											<c:forEach items="${viewMerchant}" var="list">
												$("#authority").val("${list.merchantBean.authority}");
											</c:forEach>
											<option value="ROLE_MERCHANT">MERCHANT</option>
											<option value="ROLE_ADMIN">ADMIN</option>
											<option value="ROLE_USER">USER</option>
										</select>
									</td>
								</tr>
								<c:forEach items="${viewMerchant}" var="list">					
									<tr>
										<td>personalContactNum</td>
										<td><input type="text" value="${list.merchantBean.personalContactNum}" name="personalContactNum" id="personalContactNum" /></td>
									</tr>
								</c:forEach>
								<tr>
									<td>Department</td>
									<td>
										<select id="deptId" name="deptId">
											<c:forEach items="${departments}" var="list">
												<option value="${list.deptId}">${list.deptName}</option>
											</c:forEach>
												<script type="text/javascript">
													<c:forEach items="${viewMerchant}" var="list">
														$("#deptId").val("${list.merchantBean.deptId}");
													</c:forEach>
												</script>
										</select>
									</td>
								</tr>
								
								<tr>
									<td>Designation</td>
									<td>
										<select id="desgId" name="desgId">
											<c:forEach items="${viewDesignations}" var="list">
												<option value="${list.desgId}">${list.desgName}</option>
											</c:forEach>
										</select>
										<script type="text/javascript" >
											<c:forEach items="${viewMerchant}" var="list">
												$("#desgId").val("${list.merchantBean.desgId}");
											</c:forEach>
										</script>
									</td>
								</tr>
								
								<tr>
									<td  align="right"><input type="submit" value="update" /></td>
									<td colspan="2" align="right"><input type="reset" />  </td>
								</tr>
							
						</c:forEach>
						</table>					
					</form>
				
				</div>
			</div>
		
		</div>
	</body>
	
</html>