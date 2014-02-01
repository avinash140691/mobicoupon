<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Dash Board</title>
		<link href='<c:url value="/web/css/style.css"/>' rel="stylesheet"
			type="text/css" />
		<link href='<c:url value="/web/css/mstyles.css"/>' rel="stylesheet"
			type="text/css" />
	</head>
	
	<body>
		<div class="container">
		
			<div class="header">
				<jsp:include page="adminheader.jsp"></jsp:include>
				
				<div class="merchantview" id="merchantView" align="center">
						<h2>MERCHANT INFORMATION</h2>
					<table class="tableclass" id="tableclass">
						<c:forEach items="${viewMerchant}" var="list">
							<tr>
								<td>ID</td>
								<td>${list.merchantBean.merchantId}</td>
							</tr>
							<tr>
								<td>Merchant Name</td>
								<td>${list.merchantBean.merchantName}</td>
							</tr>
							<tr>
								<td>userName</td>
								<td>${list.merchantBean.userName}</td>
							</tr>
							<tr>
								<td>Authority</td>
								<td>${list.merchantBean.authority}</td>
							</tr>
							<tr>
								<td>Password</td>
								<td>${list.merchantBean.password}</td>							
							</tr>
							<tr>
								<td>Company Name</td>
								<td>${list.merchantBean.merchantName}</td>
							</tr>
							
							<tr>
								<td>DepartMent</td>
								<td>${list.departmentBean.deptName}</td>
							</tr>
							<tr>
								<td>Designation</td>
								<td>${list.designationBean.desgName}</td>
							</tr>
							<tr>
								<td>CompanyEmail</td>
								<td>${list.merchantBean.corporateEmailId}</td>
							</tr>
							<tr>
								<td>Phone</td>
								<td>${list.merchantBean.landLine}</td>
							</tr>
							<tr>
								<td>mobile</td>
								<td>${list.merchantBean.mobile}</td>
							</tr>
							<tr>
								<td>Website</td>
								<td>${list.merchantBean.website}</td>
							</tr>
							<tr>
								<td>Address</td>
								<td>${list.merchantBean.address}</td>
							</tr>
							<tr>
								<td>Personal Contact Num</td>
								<td>${list.merchantBean.personalContactNum}</td>
							</tr>
							<tr>
								<td colspan="2" align="right" style="color:green">
								<a href='<c:url value="/admin/editMerchant?merchantId=${list.merchantBean.merchantId}"></c:url>'>EDIT</a>
								</td>
							</tr>
						</c:forEach>				
					</table>
				</div>
				
			</div>
		
		</div>
	</body>
	
</html>