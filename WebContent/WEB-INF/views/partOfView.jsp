<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Merchant View</title>
		<link href='<c:url value="/web/css/style.css"/>' rel="stylesheet"
			type="text/css" />
		<link href='<c:url value="/web/css/mstyles.css"></c:url>' rel="stylesheet" type="text/css"/>
		<script type="text/javascript">
			$(document).ready(function(){
				
			});
		</script>
	</head>
	
	<body>
		<div class="container">
		
			<div class="header">
				<jsp:include page="adminheader.jsp"></jsp:include>
				<div class="d_form">
					<table class="tableclass">
						<tr>
							<td align="right" colspan="7">
							<a href='<c:url value="/admin/add"></c:url>'>+Merchant</a>
							</td>
						</tr>
						<tr>
							<th>MerchantName</th>
							<th>user Name</th>
							<th>mobile</th>
							<th>email</th>
							<th>authority</th>
							<th>companyName</th>
							<th></th>
						</tr>
						<c:forEach items="${partOfView}" var="list">
							<tr>
								<td>${list.merchantName}</td>
								<td>${list.userName}</td>
								<td>${list.mobile}</td>
								<td>${list.corporateEmailId}</td>
								<td>${list.authority}</td>
								<td>${list.companyName}</td>
								<td><a href='<c:url value="/admin/editMerchant?merchantId=${list.merchantId}"></c:url>' style="color:green">EDIT</a>
									<a href='<c:url value="/admin/viewMerchant?merchantId=${list.merchantId}"></c:url>' style="color:green">View</a>
									<a href='<c:url value="/admin/deleteMerchant?merchantId=${list.merchantId}">
									</c:url>'style="color:red">DELETE</a>
									
									</td>
							</tr>
						</c:forEach>
							
					</table>
				</div>
			</div>
		
		</div>
	</body>
	
</html>