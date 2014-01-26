<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Dash Board</title>
<link href='<c:url value="/web/css/style.css"/>' rel="stylesheet"
	type="text/css" />
<link href='<c:url value="/web/css/mstyles.css"></c:url>' rel="stylesheet" type="text/css"/>
<script src='<c:url value="/web/js/jquery.min.js"></c:url>'></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		
		$("#addProduct").click(function(){
			$('#editForm').css('display','none');
			$("#form").css('display','block');
		});
		
		$("table tr td #editButton").click(function(){
			
			$("#form").css('display','none');
			$('#editForm').css('display','block');
			
			var row = $(this).parent().parent();
			var productId = row.find('td').eq(0).html();
			var productName = row.find('td').eq(1).html();
			
			$('#editForm #productId').val(productId);
			$('#editForm #productName').val(productName);
		});
		
			<c:if test="${not empty addErrorMsg}">
				$('#editForm').css('display','none');
				$("#form").css('display','block');
				$('#form #productName').after("<span style='color:red'>'${addErrorMsg}'</span>");
			</c:if>
			
			<c:if test="${not empty editErrorMsg}" >
				$("#form").css('display','none');
				$('#editForm').css('display','block');
				$("#editForm #productName").after("<span style='color:red'>'${editErrorMsg}'</span>");
			</c:if>
	});

</script>

</head>
<body>
<div class="container">

	<div class="header">
		<jsp:include page="adminheader.jsp"></jsp:include>
		<div id="productForm">
					<h2 style="text-align: center; text-color: #666666">
						<b>Product</b>
					</h2>
					<table align="center" class="tableclass">
						<tr>
							<td align="right" colspan="4"><input type="button"
								value="+PRODUCT" id="addProduct"></td>
						</tr>
						<tr>
							<th>PID</th>
							<th>PNAME</th>
							<th>EDIT</th>
							<th>DELETE</th>
						</tr>
						<c:forEach items="${list}" var="list">
							<tr>
								<td>${list.productId}</td>
								<td>${list.productName}</td>
								<td><input type="button" value="EDIT" id="editButton"/></td>
								<td><a
									href="<c:url value="/admin/deleteProduct?productId=${list.productId}" />">
									 <b style="color:red">DELETE</b>
								</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<br />
				
				<form autocomplete="off" action='<c:url value="/admin/addProduct" ></c:url>' style="display:none" id="form"
				 name = "form">
					<table align="left">
						<tr>
							<td>Product Name:<input type="text" name="productName" id="productName"/> <br /> </td>
						</tr>
						<tr>
							<td> <input type="submit" value="SUBMIT"> &nbsp; &nbsp; 
							<input type="reset" value="RESET" /> </td>
						</tr>
					</table>
				</form>
				
				<form autocomplete="off" action='<c:url value="/admin/editProduct"/>' style="display:none" id="editForm"
				name = "editForm" >
					<table align="left">
						<tr>
							<td>ProductID:<input type="text" name="productId" id="productId" readonly="readonly"/></td>
						</tr>
						<tr>
							<td>ProductName:<input type="text" name="productName" id="productName"/></td>
						</tr>
						<tr>
							<td> <input type="submit" value="SUBMIT"/> </td>
							<td> <input type="reset" value="RESET"/> </td>
						</tr>
					</table>				
				</form>
			</div>
	</div>
</body>
</html>